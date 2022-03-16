package com.spring.model2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model2.dto.MemberDto;
import com.spring.service.JoinService;

@Controller
public class JoinController {
	
	@Autowired
	private JoinService joinService;
	
	/** 회원가입 폼 **/
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {		
		return "/join/join";
	}
	
	/** 회원가입 처리 **/
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public ModelAndView join(MemberDto dto) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/join");
		int result = joinService.insert(dto);
		if(result == 1) {
			mv.setViewName("/login/login");
			mv.addObject("result", "ok");
		}
		return mv;
		
		
		//MemberDao dao = new MemberDao();
		/*int result = dao.insert(dto);
		String result_page = "";
		
		if(result == 1) {
			result_page = "/login/login";
			mv.setViewName(result_page);
			mv.addObject("result", "ok");
		}
		
		return mv;*/
	}
}






