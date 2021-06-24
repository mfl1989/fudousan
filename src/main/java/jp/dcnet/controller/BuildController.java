package jp.dcnet.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.dcnet.object.BuildObject;
import jp.dcnet.object.BuildPicObject;
import jp.dcnet.object.BuildViewObject;
import jp.dcnet.object.RoomObject;
import jp.dcnet.object.UserSession;
import jp.dcnet.service.BuildService;
import jp.dcnet.service.CompanyService;
import jp.dcnet.service.RoomService;

@Controller
public class BuildController {
	@Autowired
	BuildService buildService;
	@Autowired
	RoomService roomService;
	@Autowired
	CompanyService companyService;

	@RequestMapping("/build")
	public ModelAndView buildInfo() {

		ModelAndView mv = new ModelAndView("build");
		// mv.addObject("buildId", buildId);
		return mv;
	}

	/**
	 * 
	 * 建物情報編集
	 * 
	 * @param buildId
	 * @return
	 */
	@RequestMapping("/rooms/{id}")
	public ModelAndView rooms(@PathVariable("id") int buildId,

			RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView("rooms");
		System.out.println("dddddddddddddddddddddddddd");
		BuildViewObject buildinfo = buildService.getBuildViewInfo(buildId);
		List<RoomObject> rooms = roomService.findAllRoomById(buildId);

		mav.addObject("build", buildinfo);// 情報は画面表示
		mav.addObject("room", rooms);

		return mav;

	}

	/**
	 * 建物を削除ｂｙ ｉｄ
	 * 
	 * @param buildId
	 */
	@RequestMapping("/deleteBuild/{id}")
	public String deleteBuild(@PathVariable("id") int buildId) {

		buildService.delete(buildId);
		return "redirect:/allbuild";
	}

	@RequestMapping("/builddisplay")
	public ModelAndView userInfoDisplay(HttpSession session, String email) {

		ModelAndView mv = new ModelAndView("builddisplay");

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

	@RequestMapping("/buildInfo")
	public String buildInfo(@RequestParam("buildName") String buildName,

			@RequestParam("address") String address,

			@RequestParam("station") String station,

			@RequestParam("parkinglot") String parkinglot,

			@RequestParam("dateofconstruction") String dateofconstruction,

			@RequestParam("mainlightingsurface") String mainlightingsurface,

			RedirectAttributes redirectAttributes,

			HttpSession session) {
		UserSession us = (UserSession) session.getAttribute("userRole");

		int companyId = companyService.getCompanyId(us.getId());
		BuildObject buildobj = new BuildObject();

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

	/***
	 * +
	 * 
	 * @param buildId
	 * @param buildName
	 * @param address
	 * @param station
	 * @param parkinglot
	 * @param dateofconstruction
	 * @param mainlightingsurface
	 * @param redirectAttributes
	 * @param session
	 * @return
	 */
	@PostMapping("/saveBuildInfo/{id}")
	public String buildUpLoad(@PathVariable("id") int buildId, @RequestParam("buildName") String buildName,

			@RequestParam("address") String address,

			@RequestParam("station") String station,

			@RequestParam("parkinglot") String parkinglot,

			@RequestParam("dateofconstruction") String dateofconstruction,

			@RequestParam("mainlightingsurface") String mainlightingsurface, RedirectAttributes redirectAttributes,
			HttpSession session) {
		UserSession us = (UserSession) session.getAttribute("userRole");

		int companyId = companyService.getCompanyId(us.getId());

		BuildObject buildobj = new BuildObject();

		buildobj.setCompanyId(companyId);
		buildobj.setBuildName(buildName);
		buildobj.setAddress(address);
		buildobj.setStation(station);
		buildobj.setParkinglot(parkinglot);
		buildobj.setDateofconstruction(dateofconstruction);
		buildobj.setMainlightingsurface(mainlightingsurface);
		buildService.buildUpdate(buildobj, buildId);

		return "redirect:/allbuild";
	}

	/**
	 * build 編集情報
	 * 
	 * @param buildId
	 * @return
	 */

	@RequestMapping("/buildInfoEdit/{id}")
	public ModelAndView buildInfoEdit(@PathVariable("id") int buildId) {

		ModelAndView mv = new ModelAndView("buildInfoEdit");
		BuildObject findByBuildId = buildService.findByBuildId(buildId);
		List<BuildPicObject> buildP= buildService.findAllBuildPic(buildId);
		mv.addObject("buildPic", buildP);
		mv.addObject("item", findByBuildId);
		return mv;
	}

}
