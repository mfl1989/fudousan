package jp.dcnet.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.dcnet.object.BuildObject;
import jp.dcnet.object.UserSession;
import jp.dcnet.service.BuildService;
import jp.dcnet.service.CompanyService;
import jp.dcnet.service.UserService;

@Controller
public class BuildUploadController {

	@Autowired
	BuildService buildService;
	@Autowired
	UserService userService;
	@Autowired
	CompanyService companyService;

	
	@RequestMapping("/buildupload")
	public ModelAndView buildUploadView(HttpSession session) {

		UserSession us = (UserSession) session.getAttribute("userRole");
		ModelAndView mv = new ModelAndView("buildupload");
	
		// 这一步是通过查表取得CompanyId

		// int companyId = companyService.getCompanyId(us.getId());

		BuildObject buildobj = new BuildObject();
		// buildobj.setBuildId(companyId);
		// buildobj = buildService.buildView(companyId);

		// mv.addObject("item", buildobj);

		return mv;
	}

	/**
	 * 建物情報登録処理
	 * 
	 * @param companyName
	 * @param address
	 * @param station
	 * @param parkinglot
	 * @param dateofconstruction
	 * @param mainlightingsurface
	 * @param redirectAttributes
	 * @param session
	 * @return
	 */
	@RequestMapping("/getBuildInfo")
	public String getBuildInfo(@RequestParam("buildName") String buildName, 
			@RequestParam("address") String address,
			@RequestParam("station") String station, 
			@RequestParam("parkinglot") String parkinglot,
			@RequestParam("dateofconstruction") String dateofconstruction,
			@RequestParam("mainlightingsurface") String mainlightingsurface,
			RedirectAttributes redirectAttributes,

			HttpSession session) {

		BuildObject buildobj = new BuildObject();
		UserSession usersess = (UserSession) session.getAttribute("userRole");

		// 这一步是通过查表取得CompanyId
		int companyId = companyService.getCompanyId(usersess.getId());
		buildobj.setCompanyId(companyId);

		buildobj.setBuildName(buildName);
		buildobj.setAddress(address);
		buildobj.setStation(station);
		buildobj.setParkinglot(parkinglot);
		buildobj.setDateofconstruction(dateofconstruction);
		buildobj.setMainlightingsurface(mainlightingsurface);

		buildService.buildService(buildobj);

		return "redirect:/allbuild";

	}

	
	
	
	
	
}
