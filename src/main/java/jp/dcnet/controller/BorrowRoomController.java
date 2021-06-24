package jp.dcnet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BorrowRoomController {

	@RequestMapping("/borrowroom")
	public ModelAndView demoContro() {
		
		
		ModelAndView mv =new ModelAndView("borrowroom");
		
		
		return mv;
	}
	
	@RequestMapping("/area")
	public ModelAndView areaContro() {
		
		
		ModelAndView mv =new ModelAndView("area");
		
		
		return mv;
	}
	@RequestMapping("/station")
	public ModelAndView stationContro() {
		
		
		ModelAndView mv =new ModelAndView("station");
		
		
		return mv;
	}
	@RequestMapping("/home")
	public ModelAndView homeContro() {
		
		
		ModelAndView mv =new ModelAndView("home");
		
		
		return mv;
	}
}
