package jp.dcnet.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.dcnet.entity.Picture;
import jp.dcnet.object.BuildPicObject;
import jp.dcnet.object.PictureObject;
import jp.dcnet.object.RoomObject;
import jp.dcnet.service.RoomService;

@Controller
public class RoomInfoController {

	@Autowired
	RoomService roomService;

	@RequestMapping("/roominfo/{id}")
	public ModelAndView roomView(@PathVariable("id") int buildId) {

		ModelAndView mv = new ModelAndView("roominfo");
		// build idを取り出す
		mv.addObject("buildId", buildId);

		return mv;

	}

	@RequestMapping("/roomInfoEdit/{id}")
	public ModelAndView roomEditView(@PathVariable("id") int roomId) {

		ModelAndView mv = new ModelAndView("roomInfoEdit");// roomInfoEdit
		// build idを取り出す
		RoomObject rooms = roomService.roomInfoEdit(roomId);
		List<PictureObject> picture =roomService.findPicByRoomId(roomId);
		mv.addObject("room", rooms);
		mv.addObject("pic", picture);
		return mv;

	}

	@RequestMapping("/addRoom")
	public String addRoom(@RequestParam("buildId") int buildId, @RequestParam("roomName") String roomName,
			@RequestParam("rent") String rent, @RequestParam("managementfee") String managementfee,
			@RequestParam("securitydeposit") String securitydeposit, @RequestParam("keymoney") String keymoney,
			@RequestParam("floorplan") String floorplan, @RequestParam("area") String area,
			@RequestParam("dateofconstruction") String dateofconstruction, @RequestParam("event") String event,
			@RequestParam("floor") String floor, @RequestParam("address") String address,
			@RequestParam("station") String station,

			RedirectAttributes redirectAttributes, HttpSession session) {

		RoomObject roomObject = new RoomObject();

		roomObject.setBuildId(buildId);
		roomObject.setRoomName(roomName);
		roomObject.setRent(rent);
		roomObject.setManagementfee(managementfee);
		roomObject.setSecuritydeposit(securitydeposit);
		roomObject.setKeymoney(keymoney);
		roomObject.setFloorplan(floorplan);
		roomObject.setArea(area);
		roomObject.setDateofconstruction(dateofconstruction);
		roomObject.setEvent(event);
		roomObject.setFloor(floor);
		roomObject.setAddress(address);
		roomObject.setStation(station);
		roomService.addRoomInfo(roomObject);

		return "redirect:/rooms/" + buildId;

	}

	/***
	 * 編集
	 * 
	 * @param buildId
	 * @param model
	 * @return
	 */

	@RequestMapping("/roomInfoEditProcess/{id}")
	public String roomInfoEdit(@PathVariable("id") int roomId, @RequestParam("roomName") String roomName,
			@RequestParam("rent") String rent, @RequestParam("managementfee") String managementfee,
			@RequestParam("securitydeposit") String securitydeposit, @RequestParam("keymoney") String keymoney,
			@RequestParam("floorplan") String floorplan, @RequestParam("area") String area,
			@RequestParam("dateofconstruction") String dateofconstruction, @RequestParam("event") String event,
			@RequestParam("floor") String floor, @RequestParam("address") String address,
			@RequestParam("station") String station,

			RedirectAttributes redirectAttributes, HttpSession session) {
		int buildId = roomService.getBuildId(roomId);
		RoomObject roomObject = new RoomObject();
		roomObject.setBuildId(buildId);
		roomObject.setRoomName(roomName);
		roomObject.setRent(rent);
		roomObject.setManagementfee(managementfee);
		roomObject.setSecuritydeposit(securitydeposit);
		roomObject.setKeymoney(keymoney);
		roomObject.setFloorplan(floorplan);
		roomObject.setArea(area);
		roomObject.setDateofconstruction(dateofconstruction);
		roomObject.setEvent(event);
		roomObject.setFloor(floor);
		roomObject.setAddress(address);
		roomObject.setStation(station);
		roomService.roomEdit(roomObject, roomId);

		return "redirect:/rooms/" + buildId;
	}

	/**
	 * 削除
	 */
	@RequestMapping("/deleteRoom/{id}")
	public String deleteRoom(@PathVariable("id") int roomId) {

		int buildId = roomService.getBuildId(roomId);
		roomService.delete(roomId);
		return "redirect:/rooms/" + buildId;
	}

	/**
	 * ルーム一覧
	 * 
	 * @param buildId
	 * @param model
	 * @return
	 */
	@RequestMapping("/showTheRoom/{id}")
	public String showTheRoom(@PathVariable("id") int buildId, Model model) {

		List<RoomObject> rooms = roomService.findAllRoomById(buildId);

		model.addAttribute("room", rooms);
		return "redirect:/build";
	}

	@RequestMapping("/showAllRoom/{id}")
	public ModelAndView showAllRoom(@PathVariable("id") int buildId) {

		ModelAndView mv = new ModelAndView("showAllRoom");

		List<RoomObject> robj = roomService.findAllRoomById(buildId);

		mv.addObject("room", robj);

		return mv;
	}

	/**
	 * 
	 * 
	 * 
	 */
	@RequestMapping("/showrooms")
	public ModelAndView findAllRooms() {

		ModelAndView mv = new ModelAndView("showrooms");
		List<RoomObject> rooms = roomService.findAllxx();

		mv.addObject("room", rooms);
		return mv;
	}

}
