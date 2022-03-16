package com.spring.model2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model2.dto.BoardDto;
import com.spring.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	/**
	 * ���� : �Խ��� ����Ʈ
	 * @return
	 *//*
	@RequestMapping(value="/board_list", method=RequestMethod.GET)
	public ModelAndView board_list() {
		ModelAndView mv = new ModelAndView();
		//BoardDao dao = new BoardDao();
		//ArrayList<BoardDto> list = dao.select();
		ArrayList<BoardDto> list = (ArrayList<BoardDto>) boardService.getList();
		
		mv.setViewName("/board/board_list");
		mv.addObject("list", list);
		
		return mv;
	}*/
	
	/**
	 * ���� : �Խ��� ����Ʈ
	 * @return
	 */
	@RequestMapping(value="/board_list", method=RequestMethod.GET)
	public ModelAndView board_list(String rpage) {
		ModelAndView mv = new ModelAndView();
		
		//����¡ ó�� - startCount, endCount ���ϱ�
		int startCount = 0;
		int endCount = 0;
		int pageSize = 5;	//���������� �Խù� ��
		int reqPage = 1;	//��û������	
		int pageCount = 1;	//��ü ������ ��
		int dbCount = boardService.getTotalCount();	//DB���� ������ ��ü ���
		
		//�� ������ �� ���
		if(dbCount % pageSize == 0){
			pageCount = dbCount/pageSize;
		}else{
			pageCount = dbCount/pageSize+1;
		}
		
		//��û ������ ���
		if(rpage != null){
			reqPage = Integer.parseInt(rpage);
			startCount = (reqPage-1) * pageSize+1;
			endCount = reqPage *pageSize;
		}else{
			startCount = 1;
			endCount = 5;
		}
		
		ArrayList<BoardDto> list = (ArrayList<BoardDto>)boardService.getList(startCount, endCount);
		
		mv.setViewName("/board/board_list");
		mv.addObject("list", list);
		mv.addObject("dbCount", dbCount);
		mv.addObject("rpage", rpage);
		mv.addObject("pageSize", pageSize);
		
		return mv;
	}
	
	/**
	 * ���� : �Խ��� �۾��� ȭ��
	 * @return
	 */
	@RequestMapping(value="/board_write", method=RequestMethod.GET)
	public String board_write() {
		return "/board/board_write";
	}
	
	
	/**
	 * ���� : �Խ��� �󼼺���
	 * @return
	 */
	@RequestMapping(value="/board_content", method=RequestMethod.GET)
	public ModelAndView board_content(String bid) {
		ModelAndView mv = new ModelAndView();
		/*
		BoardDao dao = new BoardDao();
		dao.updateHit(bid);
		BoardDto dto = dao.select(bid);
		*/
		BoardDto dto = boardService.select(bid);
		
		mv.setViewName("/board/board_content");
		mv.addObject("board", dto);
		
		return mv;
	}
	
	/**
	 * ���� : �Խ��� ���� ȭ�� 
	 * @return
	 */
	@RequestMapping(value="/board_update", method=RequestMethod.GET)
	public ModelAndView board_update(String bid) {
		ModelAndView mv = new ModelAndView();
		BoardDto dto = boardService.select(bid);
		/*
		BoardDao dao = new BoardDao();
		BoardDto dto = dao.select(bid);
		*/
		mv.setViewName("/board/board_update");
		mv.addObject("board", dto);		
		
		return mv;
	}
	
	/**
	 * ���� : �Խ��� ���� ó�� 
	 * @return
	 */
	@RequestMapping(value="/board_update", method=RequestMethod.POST)
	public ModelAndView board_update(BoardDto dto) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("");
		int result = boardService.update(dto);
		/*
		BoardDao dao = new BoardDao();
		int result = dao.update(dto);*/
		if(result ==1) {
			mv.setViewName("redirect:/board_list");
		}
			
		
		return mv;
	}
	
	/**
	 * ���� : �Խ��� ����ȭ�� 
	 * @return
	 */
	@RequestMapping(value="/board_delete", method=RequestMethod.GET)
	public ModelAndView board_delete(String bid) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/board/board_delete");
		mv.addObject("bid",bid);
		
		return mv;
	}
	
	/**
	 * ���� : �Խ��� ���� ó�� ������ 
	 * @return
	 */
	@RequestMapping(value="/board_delete", method=RequestMethod.POST)
	public ModelAndView board_delete_proc(String bid) {
		ModelAndView mv = new ModelAndView();
		int result = boardService.delete(bid);
		/*
		BoardDao dao = new BoardDao();
		int result = dao.delete(bid);	
		*/
		if(result == 1) {
			mv.setViewName("redirect:/board_list");
		}
		
		return mv;
	}
	/**
	 * ���� : �Խ��� �۾��� ���
	 * @return
	 *//*
	@RequestMapping(value="/board_write", method=RequestMethod.POST)
	public String board_write(BoardDto dto) {
		//String result_page = "";
		//BoardDao dao = new BoardDao(); 	//DB���� Dao ��ü ����
		//int result = dao.insert(dto);	//Dao���� insert �޼ҵ� ȣ���ϰ� �����(���ϰ�) ����
	 
		int result = boardService.insert(dto);
		if(result == 1) {
			return "redirect:/board_list";
		}
		
		return "/board_write";
	}*/
	
	/**
	 * ���� : �Խ��� �۾��� ���
	 * @return
	 */
	@RequestMapping(value="/board_write", method=RequestMethod.POST)
	public String board_write(BoardDto dto, HttpServletRequest request) throws Exception {
		int result = 0;
			//���� ����
			String root_path = request.getSession().getServletContext().getRealPath("/");
			String attach_path = "\\resources\\upload\\";
			
			for(int i=0;i<dto.getFile().length;i++) {
				if(!dto.getFile()[i].getOriginalFilename().equals("")) {
					UUID uuid = UUID.randomUUID();
					String bfile = dto.getFile()[i].getOriginalFilename();
					String bsfile = uuid +"_"+dto.getFile()[i].getOriginalFilename();
					
				
				if(i==0) {
				dto.setBfile(bfile);
				dto.setBsfile(bsfile);
				}else{
					dto.setBfile2(bfile);
					dto.setBsfile2(bsfile);
				}
			}else {
				if(i==0) {
				dto.setBfile("");
				dto.setBsfile("");
				}else {
				dto.setBfile2("");
				dto.setBsfile2("");	
				}
			}
		}	

			result = boardService.getWrite(dto);
		String result_page = "";
		if(result == 1) {
			result_page = "redirect:/board_list";
			
				if(!dto.getBsfile().equals("")) {
					File file  = new File(root_path + attach_path + dto.getBsfile());
					dto.getFile1().transferTo(file);
				}
				if(!dto.getBsfile2().equals("")) {
					File file2  = new File(root_path + attach_path + dto.getBsfile2());
					dto.getFile2().transferTo(file2);
				}
				
		}
		
		return result_page;
	}

/**
 * ���� : ���� �ٿ�ε�
 * @return
 */	
	@RequestMapping(value="/download", method=RequestMethod.GET)
	@ResponseBody
	public byte[] downlod(HttpServletResponse response,@RequestParam String filename) throws IOException{

		String FILE_PATH = "C:\\TOP\\SWS_0302\\0307\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\0307\\\\resources\\upload\\";	
		//C:\TOP\SWS_0302\0307\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\0307\resources
		File file = new File(FILE_PATH, filename);

		byte[] bytes = FileCopyUtils.copyToByteArray(file);

		String fn = new String(file.getName().getBytes(), "utf-8");
		response.setHeader("Content-Disposition", "attachment;filename=\"" + fn + "\"");
		response.setContentLength(bytes.length);

		return bytes;
	}

}











