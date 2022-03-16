package com.spring.model2;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model2.dto.BoardDto;
import com.spring.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="/notice", method=RequestMethod.GET)
	public ModelAndView notice(String rpage) {
		ModelAndView mv = new ModelAndView();
	
		//페이징 처리 - startCount, endCount 구하기
		int startCount = 0;
		int endCount = 0;
		int pageSize = 5;	//한페이지당 게시물 수
		int reqPage = 1;	//요청페이지	
		int pageCount = 1;	//전체 페이지 수
		int dbCount = noticeService.getTotalCount();	//DB에서 가져온 전체 행수
		
		//총 페이지 수 계산
		if(dbCount % pageSize == 0){
			pageCount = dbCount/pageSize;
		}else{
			pageCount = dbCount/pageSize+1;
		}
		
		//요청 페이지 계산
		if(rpage != null){
			reqPage = Integer.parseInt(rpage);
			startCount = (reqPage-1) * pageSize+1;
			
			
			
			
			
			endCount = reqPage *pageSize;
		}else{
			startCount = 1;
			endCount = 5;
		}
		
		ArrayList<BoardDto> list = (ArrayList<BoardDto>)noticeService.getList(startCount, endCount);
		
		mv.setViewName("/notice/notice_list");
		mv.addObject("list", list);
		mv.addObject("dbCount", dbCount);
		mv.addObject("rpage", rpage);
		mv.addObject("pageSize", pageSize);
		
		return mv;
	}
	
	@RequestMapping(value="/notice_content", method=RequestMethod.GET)
	public ModelAndView notice_content(String bid) {
		ModelAndView mv =new ModelAndView();
		BoardDto dto = noticeService.content(bid);
		mv.setViewName("/notice/notice_content");
		mv.addObject("board", dto);
		return mv;
	}
	
	@RequestMapping(value="/admin/notice_list", method=RequestMethod.GET)
	public ModelAndView notice_list(String rpage){
		ModelAndView mv = new ModelAndView();
	
		//페이징 처리 - startCount, endCount 구하기
		int startCount = 0;
		int endCount = 0;
		int pageSize = 5;	//한페이지당 게시물 수
		int reqPage = 1;	//요청페이지	
		int pageCount = 1;	//전체 페이지 수
		int dbCount = noticeService.getTotalCount();	//DB에서 가져온 전체 행수
		
		//총 페이지 수 계산
		if(dbCount % pageSize == 0){
			pageCount = dbCount/pageSize;
		}else{
			pageCount = dbCount/pageSize+1;
		}
		
		//요청 페이지 계산
		if(rpage != null){
			reqPage = Integer.parseInt(rpage);
			startCount = (reqPage-1) * pageSize+1;
			endCount = reqPage *pageSize;
		}else{
			startCount = 1;
			endCount = 5;
		}
		
		ArrayList<BoardDto> list = (ArrayList<BoardDto>)noticeService.getList(startCount, endCount);
		
		mv.setViewName("/admin/notice/notice_list");
		mv.addObject("list", list);
		mv.addObject("dbCount", dbCount);
		mv.addObject("rpage", rpage);
		mv.addObject("pageSize", pageSize);
		
		return mv;
	}
	
	@RequestMapping(value="/admin/notice_content", method=RequestMethod.GET)
	public ModelAndView admin_notice_content(String bid) {
		ModelAndView mv =new ModelAndView();
		BoardDto dto = noticeService.content(bid);
		mv.setViewName("/admin/notice/notice_content");
		mv.addObject("board", dto);
		return mv;
	}
	
	@RequestMapping(value="/admin/notice_update", method=RequestMethod.GET)
	public ModelAndView notice_update(String bid) {
		ModelAndView mv = new ModelAndView();
		BoardDto dto = noticeService.select(bid);
		mv.setViewName("/admin/notice/notice_update");
		mv.addObject("board", dto);		
		
		return mv;
	}
	
	
	@RequestMapping(value="/admin/notice_update", method=RequestMethod.POST)
	public ModelAndView notice_update(BoardDto dto) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("");
		int result = noticeService.update(dto);

		if(result ==1) {
			mv.setViewName("redirect:/admin/notice_list");
		
	}
		return mv;
}
	@RequestMapping(value="/admin/notice_write", method=RequestMethod.POST)
	public String notice_write(BoardDto dto) {		 
				int result = noticeService.insert(dto);
				if(result == 1) {
					return "redirect:/admin/notice_list";
				}
				return "/admin/notice/notice_write";
	}

	@RequestMapping(value="/admin/notice_delete", method=RequestMethod.POST)
	public ModelAndView notice_delete(String bid) {
		
		ModelAndView mv = new ModelAndView();
		int result = noticeService.delete(bid);

		if(result == 1) {
			mv.setViewName("redirect:/admin/notice_list");
		}
		
		return mv;
	}
	
	
	
}
