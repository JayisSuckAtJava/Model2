package com.spring.model2;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model2.dto.MemberDto;
import com.spring.service.MemberService;

@Controller
public class AdminController {
	
	
	@Autowired
	private MemberService memberService;
	
	/**
	 * 제목 : 회원 리스트 페이지
	 * @return
	 */
	
	@RequestMapping(value="/admin/member_list", method=RequestMethod.GET)
	public ModelAndView member_list(String rpage) {
		ModelAndView mv = new ModelAndView();

		//페이징 처리 - startCount, endCount 구하기
		int startCount = 0;
		int endCount = 0;
		int pageSize = 3;	//한페이지당 게시물 수
		int reqPage = 1;	//요청페이지	
		int pageCount = 1;	//전체 페이지 수
		int dbCount = memberService.getTotalCount();	//DB에서 가져온 전체 행수
		
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
			endCount = 3;
		}
		
		ArrayList<MemberDto> list = (ArrayList<MemberDto>)memberService.getList(startCount, endCount);
		mv.setViewName("/admin/member/member_list");
		mv.addObject("list", list);
		mv.addObject("dbCount", dbCount);
		mv.addObject("rpage", rpage);
		mv.addObject("pageSize", pageSize);
		
		return mv;	
	}
	
	@RequestMapping(value="/admin/member_content",method=RequestMethod.GET)
	public ModelAndView member_content(String id) {
		ModelAndView mv =new ModelAndView();
		MemberDto result = memberService.select(id);
		mv.setViewName("/admin/member/member_content");
		mv.addObject("detail", result);
		return mv;
	}
	
	/**
	 * 제목 : 관리자 메인화면
	 * @return
	 */
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String admin(HttpSession session) {
		String id =(String) session.getAttribute("sid");
		System.out.println(id+" : 현재 접속한 아이디");
		String admin = "jay";
		if(id.equals(admin)) {
		return "/admin/admin";
		}
		return "main";
	}
	
	/**
	 * 제목 : 관리자-공지사항 리스트
	 * @return
	 *//*
	@RequestMapping(value="/admin/notice_list", method=RequestMethod.GET)
	public String notice_list() {
		return "/admin/notice/notice_list";
	}*/
	
	/**
	 * 제목 : 관리자-공지사항 글쓰기
	 * @return
	 */
	@RequestMapping(value="/admin/notice_write", method=RequestMethod.GET)
	public String notice_write() {
		return "/admin/notice/notice_write";
	}
	
	/**
	 * 제목 : 관리자-공지사항 상세보기
	 * @return
	 *//*
	@RequestMapping(value="/admin/notice_content", method=RequestMethod.GET)
	public String notice_content() {
		return "/admin/notice/notice_content";
	}*/
	
	/**
	 * 제목 : 관리자-공지사항 수정페이지
	 * @return
	 *//*
	@RequestMapping(value="/admin/notice_update", method=RequestMethod.GET)
	public String notice_update() {
		return "/admin/notice/notice_update";
	}*/
	
	/**
	 * 제목 : 관리자-공지사항 삭제페이지
	 * @return
	 */
	@RequestMapping(value="/admin/notice_delete", method=RequestMethod.GET)
	public ModelAndView notice_delete(String bid) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/notice/notice_delete");
		mv.addObject("bid",bid);
		return mv;
	}
}
