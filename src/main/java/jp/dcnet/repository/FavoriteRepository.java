package jp.dcnet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.dcnet.entity.Favorite;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {

	Favorite findByRoomId(int roomId);

	Long deleteByRoomId(int roomId);

	List<Favorite> findByUserId(int userId);

}
