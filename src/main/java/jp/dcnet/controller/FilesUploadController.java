package jp.dcnet.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.dcnet.entity.BuildPic;
import jp.dcnet.entity.Picture;
import jp.dcnet.entity.Room;
import jp.dcnet.object.UserInfoObject;
import jp.dcnet.object.UserSession;
import jp.dcnet.service.BuildService;
import jp.dcnet.service.RoomService;
import jp.dcnet.service.UserInfoService;

/**
 * 多文件上传控制类
 * 
 * @author Administrator
 */
@Controller
public class FilesUploadController {
	@Autowired
	UserInfoService userInfoService;
	@Autowired
	BuildService buildService;
	@Autowired
	RoomService roomService;
	/*
	 * // 读取application.properties文件中的自定义配置项
	 * 
	 * @Value("${spring.fileupload.destination}") private String destination;
	 * 
	 * @RequestMapping("/files") public String index() { return "uploads"; }
	 */

	/**
	 * 多文件上传类 文件会自动绑定到MultipartFile中
	 * 
	 * @param request     获取请求信息
	 * @param description 文件描述
	 * @param file        上传的文件
	 * @return 上传成功或失败结果
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	@RequestMapping("/fileUPLoad/{id}")
	public ModelAndView filesUpload(@PathVariable("id") int roomId) {

		ModelAndView mv = new ModelAndView("fileUPLoad");
		Room room = new Room();
		room.setRoomId(roomId);
		mv.addObject("room", room);

		return mv;
	}

	@PostMapping("/userUploads")
	public String fileUpload(@RequestParam("files") MultipartFile icon, HttpSession session) throws IOException {

		UserSession role = (UserSession) session.getAttribute("userRole");

		String userIcon = icon.getOriginalFilename();

		try {
			icon.transferTo(
					new File("C:\\Users\\mfl\\eclipse-workspace\\fudousan\\src\\main\\resources\\static\\images\\icon\\"
							+ userIcon));
		} catch (Exception e) {
			e.printStackTrace();
		}
		UserInfoObject obj = new UserInfoObject();
		obj.setIcon(userIcon);
		userInfoService.saveIcon(obj, role.getId());

		return "redirect:/userinfodisplay";

	}

	/**
	 * 写真登録 the build picture
	 * 
	 * @param request
	 * @param product
	 * @return all build /build/{id} {id}/filesUpload
	 * 
	 *         Object
	 */
	@PostMapping("/filesUpload/{id}")
	public String filesUpload(@PathVariable("id") int buildId, @RequestParam("file") MultipartFile[] img, Model model,
			RedirectAttributes redirectAttributes, HttpSession session) {

		List<BuildPic> build = buildService.findOne(buildId);
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx");
		model.addAttribute("build", build);
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < img.length; i++) {
			MultipartFile file = img[i];
			// 保存文件
			list = buildService.saveFile(file, list);
		}

		buildService.createPicture(buildId, list);

		return "redirect:/buildInfoEdit/" + buildId;
	}

	/**
	 * the room picture
	 * 
	 * @param roomId
	 * @param img
	 * @param model
	 * @param redirectAttributes
	 * @param session
	 * @return
	 */
	@RequestMapping("/fileUP/{id}")
	public String fileUpLoad(@PathVariable("id") int roomId, @RequestParam("icon") MultipartFile[] img, Model model,
			RedirectAttributes redirectAttributes, HttpSession session) {

		// UserSession user = (UserSession) session.getAttribute("userRole");
		List<Picture> rooms = roomService.findOne(roomId);

		int buildId = roomService.findBidByRid(roomId);

		model.addAttribute("room", rooms);
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < img.length; i++) {
			MultipartFile file = img[i];
			// 保存文件
			list = buildService.saveRoomsFile(file, list);
		}

		buildService.createRoomPicture(roomId, list);

		return "redirect:/rooms/" + buildId;
	}

	/**
	 * buildId 下の写真 すべて削除
	 * 
	 * @param buildId
	 * @return
	 */
	@RequestMapping("/deleteBuildPicture/{id}")
	public String deleteBuildPicture(@PathVariable("id") int buildId) {

		
		buildService.deleteByBuildId(buildId);
		return "redirect:/buildInfoEdit/" + buildId;
	}

	/**
	 * 
	 * byBuildPid の写真 一つ削除
	 * 
	 * @param buildPid
	 * @return
	 */
	@RequestMapping("/deleteOnePictureByBuild/{id}")
	public String deleteOnePictureByBuild(@PathVariable("id") int buildPid) {

		int buildId = buildService.findBidByRid(buildPid);
		buildService.deleteById(buildPid);

		return "redirect:/buildInfoEdit/" + buildId;
	}

	/**
	 * roomId 下の写真 すべて削除
	 * @param roomId
	 * @return
	 */
	@RequestMapping("/deleteRoomPicture/{id}")
	public String deleteRoomPicture(@PathVariable("id") int roomId) {

		
		roomService.deleteByRoomId(roomId);
		return "redirect:/roomInfoEdit/" + roomId;
	}
	
	/**
	 * byPicIdの写真 一つ削除
	 * @param picId
	 * @return
	 */
	@RequestMapping("/deleteOnePictureByRoom/{id}")
	public String Room(@PathVariable("id") int picId) {

		int roomId = roomService.findRidByPid(picId);
		roomService.deleteById(picId);

		return "redirect:/roomInfoEdit/" + roomId;
	}

	
}
