package jp.dcnet.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.dcnet.object.BuildObject;
import jp.dcnet.object.UserSession;
import jp.dcnet.service.BuildService;
import jp.dcnet.service.CompanyService;

@Controller
public class AllBuildController {
	@Autowired
	CompanyService companyService;
	@Autowired
	BuildService buildService;

	@RequestMapping("/allbuild")
	public ModelAndView allBuildInfo(HttpSession session) {

		ModelAndView mv = new ModelAndView("allbuild");
		UserSession us = (UserSession) session.getAttribute("userRole");

		int companyId = companyService.getCompanyId(us.getId());

		List<BuildObject> buildList = buildService.findAllBuild(companyId);
		for (BuildObject b : buildList) {

		}
		mv.addObject("buildList", buildList);
		return mv;

	}

	@RequestMapping("/showAllBuild")
	public ModelAndView showAllBuild() {

		ModelAndView mv = new ModelAndView("showAllBuild"); // roomInfoEdit
		// build idを取り出す
		List<BuildObject> xx = buildService.FindAllBuildRoom();
		mv.addObject("build", xx);

		return mv;

	}

	/**
	 * admin関する
	 * @return
	 */
	@RequestMapping("/adminshowbuild")
	public ModelAndView adminShowBuild() {

		ModelAndView mv = new ModelAndView("adminshowbuild");
		List<BuildObject> xx = buildService.FindAllBuildRoom();
		mv.addObject("build", xx);

		return mv;

	}
	
	
	
	@RequestMapping("/adminDeleteBuild/{id}")
	public String adminDeleteBuild(@PathVariable("id") int buildId) {

		buildService.adminDeleteBuild(buildId);
		
		return "redirect:/adminshowlogin";
	}
	
	
	
	
	
	
	
}
