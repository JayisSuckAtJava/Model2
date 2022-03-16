package com.spring.model2;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MycgvController {
	@RequestMapping(value="/mypage", method=RequestMethod.GET)
	public ModelAndView mypage(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String sid = (String) session.getAttribute("sid");
		
		mv.setViewName("/login/login");
		mv.addObject("loginPlz", "loginPlz");
		if(sid!=null) {	// �α��� ���������� �̷������� ó�� ����,
			// �㳪 �׻�� ����� ���� = Intercepter �� �̸��̾�, �̰� servlet-context �� SessionAuthInterCepot �� �����Ѵ�.!
			mv.setViewName("/mypage/mycgv");
			return mv;
		}
		return mv;
	}
}
