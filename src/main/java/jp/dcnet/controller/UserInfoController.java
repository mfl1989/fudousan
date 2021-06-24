package jp.dcnet.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jp.dcnet.object.CompanyObject;
import jp.dcnet.object.UserInfoObject;
import jp.dcnet.object.UserSession;
import jp.dcnet.service.CompanyService;
import jp.dcnet.service.UserInfoService;
import jp.dcnet.service.UserService;

@Controller
public class UserInfoController {

	@Autowired
	UserInfoService userInfoService;
	@Autowired
	UserService userService;
	@Autowired
	CompanyService companyService;
	@RequestMapping("/userinfo")
	public ModelAndView logininfo() {
		ModelAndView mv = new ModelAndView("userinfo");

		return mv;
	}

	/*
	 * 显示个人信息
	 * 
	 */
	@RequestMapping("/userinfodisplay")
	public ModelAndView userInfoDisplay(HttpSession session, String email) {

		UserSession us = (UserSession) session.getAttribute("userRole");
//用if去判断登录角色
		ModelAndView mv = new ModelAndView();
		if(us.getUserRole().equals("user") ) {
			
			// session通过email取到当前对应的这一条信息
			// UserIntoObject userLogin =
			// userService.getUserLogin(email);//用UserIntoObject类去接收service传回来的值
			mv.setViewName("userinfodisplay");
			UserInfoObject userobj = userInfoService.userInfoDisplay(us.getId());
			mv.addObject("item", userobj);
			
			return mv;
		}else {
			mv.setViewName("company");
			// 通过session取得id
			UserSession userRole = (UserSession) session.getAttribute("userRole");
			int companyId = companyService.getCompanyId(userRole.getId());
			
			CompanyObject companyObj = companyService.companyView(companyId);
			mv.addObject("item", companyObj);

			
			return mv;
		}
	}

	@RequestMapping("/getInformation")
	public String getInformation(@RequestParam("name") String name, @RequestParam("tel") int tel,
			@RequestParam("address") String address, HttpSession session) throws IOException {

		UserSession us = (UserSession) session.getAttribute("userRole");

		UserInfoObject infoobj = new UserInfoObject();
		infoobj.setUserId(us.getId());
		infoobj.setName(name);
		infoobj.setTel(tel);
		infoobj.setAddress(address);
		userInfoService.userInfoGet(infoobj);
		return "redirect:/userinfo";
	}

}