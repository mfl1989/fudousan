package jp.dcnet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jp.dcnet.entity.Room;
import jp.dcnet.object.FavoriteObject;
@Repository
public interface RoomRepository  extends JpaRepository<Room,Integer>{
	
	List<Room> findByRoomIdOrderByRoomIdAsc(int id);
	
	Room findByRoomId(int id);
	
	@Query(value = "select * from room where room_id =:id", nativeQuery = true)
	List<Room> getRoomId(@Param("id")int roomId);
	
	List<Room> findByBuildIdOrderByRoomIdAsc(int buildId);

	
	
}
