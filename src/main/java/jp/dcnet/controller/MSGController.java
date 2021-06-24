package jp.dcnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.dcnet.object.MSGObject;
import jp.dcnet.service.MSGService;

@Controller
public class MSGController {
	
	@Autowired
	MSGService msgser;
	@RequestMapping("/msg")
	public ModelAndView logininfo() {
		
		ModelAndView mv =new ModelAndView("msg");
		
		
		
		return mv;
		
	}
	
	@RequestMapping("/setMSG")
	public  String setMSG(MSGObject msgobj) {
		
		msgser.getMSGToDb(msgobj);
		 
		
		
		
	 return "redirect:/msg";
	}




}
