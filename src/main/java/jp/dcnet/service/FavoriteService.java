package jp.dcnet.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.dcnet.entity.Favorite;
import jp.dcnet.object.FavoriteObject;
import jp.dcnet.repository.FavoriteRepository;
import jp.dcnet.repository.RoomRepository;
import jp.dcnet.repository.UserRepository;

@Service
public class FavoriteService {

	@Autowired
	FavoriteRepository favoriteRepository;
	@Autowired
	RoomRepository roomRepository;
	@Autowired
	UserRepository userRepository;

	/**
	 * 気に入り確認処理
	 * 
	 * @param buildId
	 */
	public boolean findFav(int roomId) {

		boolean res = false;

		Favorite fav = favoriteRepository.findByRoomId(roomId);

		if (fav != null) {

			res = true;
		}
		return res;
	}

	/**
	 * 
	 * 気に入り登録処理
	 * 
	 * @param roomId
	 * @param userId
	 */

	public void getLikeList(int roomId, int userId) {

		Favorite favorite = new Favorite();
		favorite.setRoomId(roomId);
		favorite.setUserId(userId);
		favorite.setUpdatetime(new Timestamp(System.currentTimeMillis()));
		favoriteRepository.save(favorite);

	}
/**
 * 気に入り削除処理
 * 
 * @param roomId
 */
	@Transactional
	public void deleteFav(int roomId) {
		// TODO 自動生成されたメソッド・スタブ

		
			favoriteRepository.deleteByRoomId(roomId);
		
	}

	
	/**
	 * 
	 * @param UserId
	 * @return
	 */
	public List<FavoriteObject> findById(int UserId) {
		// TODO 自動生成されたメソッド・スタブ
		List<Favorite> fas = favoriteRepository.findByUserId(UserId);
		List<FavoriteObject> favList = new ArrayList<>();
		for (Favorite fa : fas) {

			FavoriteObject favobj = new FavoriteObject();
			favobj.setRoomId(fa.getRoomId());
			favobj.setStatus(0);
			favobj.setUserId(fa.getUserId());
			favobj.setUpdatetime(fa.getUpdatetime());
			favList.add(favobj);
		}

		return favList;
	}

}
