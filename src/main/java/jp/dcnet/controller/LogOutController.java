package jp.dcnet.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LogOutController {

	//@Autowired
	
	/*
	 * logout　　
	 */

	@RequestMapping("/logout")//画面に"/logout"　調用する
	public String logOut(HttpSession session) {

		//session 消します
		session.removeAttribute("userRole");
		return "redirect:/index";
	}
}
