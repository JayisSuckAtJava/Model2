package com.spring.model2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	/** main.jsp 概俏林家 **/
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main() {
		return "main";
	}
	
	/** header.jsp 概俏林家 **/
	@RequestMapping(value = "/header", method = RequestMethod.GET)
	public String header() {
		return "header";
	}
	
	/** footer.jsp 概俏林家 **/
	@RequestMapping(value = "/footer", method = RequestMethod.GET)
	public String footer() {
		return "footer";
	}
	
	
}
