package jp.dcnet.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.dcnet.object.BuildObject;
import jp.dcnet.object.UserSession;
import jp.dcnet.service.BuildService;

@Controller
public class BuildInfoUpdateController {

	@Autowired
	BuildService buildService;

	/**
	 * 建物情報更新画面
	 * @return
	 */
	@RequestMapping("/buildinfoupdate")
	public ModelAndView buildInfoUpdateView() {

		ModelAndView mv = new ModelAndView("buildinfoupdate");

		return mv;

	}

	/**
	 * 建物情報更新処理
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
	@RequestMapping("/buildInfoUpdate/{id}")
	public ModelAndView buildInfoUpdate(@PathVariable("id") int buildId,

			@RequestParam("buildName") String buildName,

			@RequestParam("address") String address,

			@RequestParam("station") String station,

			@RequestParam("parkinglot") String parkinglot,

			@RequestParam("dateofconstruction") String dateofconstruction,

			@RequestParam("mainlightingsurface") String mainlightingsurface, RedirectAttributes redirectAttributes,
			HttpSession session) {
		ModelAndView mv = new ModelAndView("buildinfoupdate");
		UserSession getsession = (UserSession) session.getAttribute("userRole");

		BuildObject buildobj = new BuildObject();
		buildobj.setBuildName(buildName);
		buildobj.setAddress(address);
		buildobj.setStation(station);
		buildobj.setParkinglot(parkinglot);
		buildobj.setDateofconstruction(dateofconstruction);
		buildobj.setMainlightingsurface(mainlightingsurface);
		buildService.buildUpdate(buildobj, getsession.getId());

		mv.addObject("build", buildobj);
		return mv;

	}

}
