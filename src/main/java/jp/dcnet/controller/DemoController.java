package jp.dcnet.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.dcnet.object.UserSession;
import jp.dcnet.service.BuildService;

@Controller
public class DemoController {

	@Autowired
	BuildService buildService;

	@RequestMapping("/demo1")
	public ModelAndView demoContro() {

		ModelAndView mv = new ModelAndView("demo1");

		return mv;
	}

	@PostMapping("/addPicture")
	public String addPicture(@RequestPart(name = "icon") MultipartFile[] icon, RedirectAttributes redirectAttributes,
			HttpSession session) throws Exception, IOException {
		if (icon.length > 0) {
			ArrayList<String> pics = new ArrayList<String>();
			Timestamp createTime = new Timestamp(System.currentTimeMillis());
			UserSession userRole = (UserSession) session.getAttribute("userRole");
			for (int x = 0, y = icon.length; x < y; x++) {
				if (!icon[x].isEmpty()) {
					String originalFilename = icon[x].getOriginalFilename();
					String fileType = originalFilename.substring(originalFilename.lastIndexOf("."),
							originalFilename.length());
					String iconName = userRole.getId()
							+ createTime.toString().replace("-", "").replace(" ", "").replace(":", "").replace(".", "")
							+ x + fileType;
					icon[x].transferTo(new File("" + iconName));
					pics.add(iconName);
				}
		//		buildService.savePicture(userRole.getId(), pics);
				redirectAttributes.addFlashAttribute("message", "アイコンを追加しました");
			}
		} else {
			redirectAttributes.addFlashAttribute("message", "アイコンを選択してください");
		}
		return "redirect:/login/companyPicture";
	}

}
