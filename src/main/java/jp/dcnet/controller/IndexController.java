package jp.dcnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@Autowired
	
	@RequestMapping("/index") 
	public ModelAndView indexcontro() {
		
		
		ModelAndView mv =new ModelAndView("index");
		
		
		return mv;
	}
	
	

}
