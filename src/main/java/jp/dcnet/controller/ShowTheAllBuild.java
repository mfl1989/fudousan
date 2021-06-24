package jp.dcnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShowTheAllBuild {
@Autowired
	@RequestMapping("/showTheAllBuild")
	public ModelAndView theView() {
	
	
	ModelAndView mv =new ModelAndView("showTheAllBuild");
	
	
	return mv;
	
	
}
	
}
