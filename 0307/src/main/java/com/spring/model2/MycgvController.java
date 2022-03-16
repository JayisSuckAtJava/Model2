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
		if(sid!=null) {	// 로그인 되지않으면 이런식으로 처리 가능,
			// 허나 항상된 기능이 있음 = Intercepter 다 이말이야, 이건 servlet-context 와 SessionAuthInterCepot 로 설정한다.!
			mv.setViewName("/mypage/mycgv");
			return mv;
		}
		return mv;
	}
}
