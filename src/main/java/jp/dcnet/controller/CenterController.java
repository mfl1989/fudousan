package jp.dcnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.dcnet.object.MSGObject;
import jp.dcnet.service.MSGService;

@Controller
public class CenterController {

	@Autowired
	MSGService msgser;
	
	@RequestMapping("/center")
	public ModelAndView companyContro() {
		
		ModelAndView mv =new ModelAndView("center");
		
		
		return mv;
	}

	

	
	
	
	
	
	
}
