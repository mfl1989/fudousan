package jp.dcnet.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.dcnet.object.FavoriteObject;
import jp.dcnet.object.UserSession;
import jp.dcnet.service.FavoriteService;
import jp.dcnet.service.RoomService;

@Controller
public class FavoritesController {
	@Autowired
	FavoriteService favoriteService;
	@Autowired
	RoomService roomService;

	/**
	 * 
	 * 気に入り 画面表示する
	 * 
	 * @param session
	 * @return
	 */

	@RequestMapping("/favorites")
	public ModelAndView logininfo(HttpSession session) {

		UserSession se = (UserSession) session.getAttribute("userRole");
//		ModelAndView mv = new ModelAndView("favorites");
		ModelAndView mv = new ModelAndView("favorites");
		List<FavoriteObject> xx = favoriteService.findById(se.getId());
		

		mv.addObject("item", xx);
		return mv;

	}

	/**
	 * 気に入り処理
	 * 
	 * @param roomId
	 * @param buildId
	 * @param redirectAttributes
	 * @param session
	 * @return
	 */

	@RequestMapping("/favorites/{id}/{buildId}")
	public String likeTheRoom(@PathVariable("id") int roomId, @PathVariable("buildId") int buildId,
			RedirectAttributes redirectAttributes, HttpSession session) {
		// 二つidを届け
		UserSession se = (UserSession) session.getAttribute("userRole");

		int userId = se.getId();

		boolean res = roomService.getFav(roomId);

		if (res) {

			favoriteService.deleteFav(roomId);

		} else {

			favoriteService.getLikeList(roomId, userId);

		}

		return "redirect:/showAllRoom/" + buildId;

	}

	@RequestMapping("/showRooms/{id}")
	public String likeRooms(@PathVariable("id") int roomId, RedirectAttributes redirectAttributes,
			HttpSession session) {

		UserSession se = (UserSession) session.getAttribute("userRole");

		int userId = se.getId();
		
		boolean res = roomService.getFav(roomId);

		if (res) {

			favoriteService.deleteFav(roomId);

		} else {

			favoriteService.getLikeList(roomId, userId);

		}

		return "redirect:/showrooms";

	}

}
