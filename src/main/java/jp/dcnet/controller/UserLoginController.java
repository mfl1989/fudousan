package jp.dcnet.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.dcnet.object.UserIntoObject;
import jp.dcnet.object.UserSession;
import jp.dcnet.service.UserService;

@Controller
public class UserLoginController {

	@Autowired
	UserService userService;

	@RequestMapping("/login")
	public ModelAndView logininfo() {

		ModelAndView mv = new ModelAndView("login");

		return mv;

	}

	@PostMapping("/loginProcess")
	public String loginProcess(@RequestParam("email") String email, @RequestParam("password") String password,
			RedirectAttributes redirectAttributes, HttpSession session) {

		UserIntoObject UserObj = new UserIntoObject();
		UserObj.setEmail(email);
		UserObj.setPassword(password);

		int res = userService.loginService(UserObj);
		if (res == 0) {
			UserSession userSession = new UserSession();// session通过email取到当前对应的这一条信息
			UserIntoObject userLogin = userService.getUserLogin(email);// 用UserIntoObject类去接收service传回来的值
			userSession.setEmail(email);
			userSession.setId(userLogin.getUserId());
			userSession.setUserRole(userLogin.getUserRole());
			userSession.setStatus(userLogin.getStatus());
			// 保存的session通过userrole 保存userSession信息
			session.setAttribute("userRole", userSession);
			redirectAttributes.addFlashAttribute("msg", "登録成功");
			return "redirect:/index ";
		}
		if (res == 1) {

			redirectAttributes.addFlashAttribute("msg", "パスワード間違いです");
			return "redirect:/login ";
		}
		redirectAttributes.addFlashAttribute("msg", "ユーザ存在しません");
		return "redirect:/login ";

	}

	@RequestMapping("/adminLogin")
	public String adminLogin(@RequestParam("email") String email, @RequestParam("password") String password,
			RedirectAttributes redirectAttributes, HttpSession session) {

		UserIntoObject UserObj = new UserIntoObject();
		UserObj.setEmail(email);
		UserObj.setPassword(password);

		int res = userService.adminService1(UserObj);

		if (res == 0) {
			UserSession userSession = new UserSession();// session通过email取到当前对应的这一条信息
			UserIntoObject userLogin = userService.getUserLogin(email);// 用UserIntoObject类去接收service传回来的值
			userSession.setEmail(email);
			userSession.setId(userLogin.getUserId());
			userSession.setUserRole(userLogin.getUserRole());
			userSession.setStatus(userLogin.getStatus());
			// 保存的session通过userrole 保存userSession信息
			session.setAttribute("userRole", userSession);
			redirectAttributes.addFlashAttribute("msg", "管理人登録成功");
			return "redirect:/index ";
		}

		if (res == 1) {

			redirectAttributes.addFlashAttribute("msg", "パスワード間違いです");
			return "redirect:/login ";

		}

		redirectAttributes.addFlashAttribute("msg", "ユーザ存在しません");
		return "redirect:/login ";

	}

	@RequestMapping("/adminshowlogin")
	public ModelAndView adminShowLogin() {

		ModelAndView mv = new ModelAndView("adminshowlogin");
		List<UserIntoObject> userinto = userService.findAll();

		mv.addObject("userinto", userinto);

		return mv;

	}

	@RequestMapping("/admintheview/{id}")
	public ModelAndView adminTheView(@PathVariable("id") int userId) {

		ModelAndView mv = new ModelAndView("admintheview");
		UserIntoObject obj = new UserIntoObject();
		obj = userService.updateAdminTheview(userId);
		mv.addObject("item", obj);

		return mv;

	}

	@RequestMapping("/admintheadit/{id}")
	public String adminTheAdit(@PathVariable("id") int userId, UserIntoObject obj) {
		
		userService.updateAdminTheRep(obj, userId);

		return "redirect:/adminshowlogin";

	}

	@RequestMapping("/deleteById/{id}")
	public String deleteById(@PathVariable("id")int userId) {

		userService.deleteById(userId);

		return "redirect:/adminshowlogin";
	}

}