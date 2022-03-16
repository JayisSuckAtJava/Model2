package com.spring.model2;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model2.dto.MemberDto;
import com.spring.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	/** login ȭ�� ���� �ּ� **/
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "/login/login";
	}
	
	/** login ������ ó�� **/
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(MemberDto dto,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		//MemberDao dao = new MemberDao();
		int result = loginService.select(dto);//dao.select(dto); 
		if(result == 1) {
			session.setAttribute("sid", dto.getId());
			mv.setViewName("/main");
			mv.addObject("login_result", "succ");
		}else {
			mv.setViewName("/login/login");
			mv.addObject("login_result", "fail");
		}
		return mv;
	}	
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		System.out.println(session.getAttribute("sid")+" ���� �α׾ƿ� �߽��ϴ�.");
		if(session.getAttribute("sid")!=null) {
		session.removeAttribute("sid");
		session.invalidate();
		
		mv.setViewName("/main");
		mv.addObject("logout_result", "succ");
		}else {
			mv.addObject("fuck", "fuck");
			mv.setViewName("/main");
		}
		return mv;
	}

}









