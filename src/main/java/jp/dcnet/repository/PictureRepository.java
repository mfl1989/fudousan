package jp.dcnet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jp.dcnet.entity.BuildPic;
import jp.dcnet.entity.Picture;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Integer> {

	@Query(value = "select * from picture where room_id =:id", nativeQuery = true)
	List<Picture> getRoom(@Param("id")int roomId);



	List<Picture> findByRoomId(int roomId);



	
	
	
	
	}


