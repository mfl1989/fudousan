package jp.dcnet.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.dcnet.object.UserIntoObject;
import jp.dcnet.object.UserSession;
import jp.dcnet.service.UserService;

@Controller
public class PasswordController {
	@Autowired
	UserService userService ;
	@RequestMapping("/password")
	public ModelAndView passwordContro() {

		ModelAndView mv = new ModelAndView("password");

		return mv;
	}

	@PostMapping("/passwordUpdate")
	public String passwordUpdate(@RequestParam("password") String password,
			@RequestParam("newpassword")String newpassword ,
			HttpSession session,
			RedirectAttributes redirectAttributes ) {
         UserSession us=(UserSession) session.getAttribute("userRole");
	
         
         UserIntoObject userObject =new UserIntoObject();
         userObject.setEmail(us.getEmail());
		 userObject.setPassword(password);
		 System.out.println(userObject.toString());
		int res = userService.passwordUpDate(userObject, newpassword);
		if(res==0) {
			
			
			
			
			redirectAttributes.addFlashAttribute("msg","パスワード変更成功");
			return "redirect:/center";
		} if(res==1) {
		
		
		
			redirectAttributes.addFlashAttribute("msg","パスワード間違いです");
			return "redirect:/password";
	}
		
	
		return "redirect:/password";
	}

}
