package jp.dcnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.dcnet.object.UserIntoObject;
import jp.dcnet.service.UserService;

@Controller
public class UserRegistController {

	@Autowired
	UserService userService;

	@RequestMapping("/regist")
	public ModelAndView registinfo() {

		ModelAndView mv = new ModelAndView("regist");

		return mv;
	}

	@RequestMapping("/companyregist")
	public ModelAndView companyRegistinfo() {

		ModelAndView mv = new ModelAndView("companyregist");

		return mv;
	}

	/**
	 * 新規
	 * @param email
	 * @param password
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping("/registProcess")
	public String registProcess(@RequestParam("email") String email, @RequestParam("password") String password,
			RedirectAttributes redirectAttributes) {

		UserIntoObject usero = new UserIntoObject();
		usero.setEmail(email);
		usero.setPassword(password);
		int res = userService.registService(usero);
		if (res == 1) {
			redirectAttributes.addFlashAttribute("msg", "ユーザ存在します");
			System.out.println(email);

			return "redirect:/regist";
		}

		redirectAttributes.addFlashAttribute("msg", email + "登録成功");
		return "redirect:/login";
	}
	
	/**
	 * company新規
	 * @param email
	 * @param password
	 * @param redirectAttributes
	 * @return
	 */

	@PostMapping("/companyregistProcess")
	public String companyRegistProcess(@RequestParam("email") String email, @RequestParam("password") String password,
			RedirectAttributes redirectAttributes) {

		UserIntoObject usero = new UserIntoObject();
		usero.setEmail(email);
		usero.setPassword(password);
		int res = userService.companyRegistService(usero);
		if (res == 1) {
			redirectAttributes.addFlashAttribute("msg", "ユーザ存在します");
			System.out.println(email);

			return "redirect:/regist";
		}

		redirectAttributes.addFlashAttribute("msg", email + "登録成功");
		return "redirect:/login";
	}

}