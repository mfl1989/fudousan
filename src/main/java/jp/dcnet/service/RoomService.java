package jp.dcnet.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.dcnet.entity.BuildPic;
import jp.dcnet.entity.Favorite;
import jp.dcnet.entity.Picture;
import jp.dcnet.entity.Room;
import jp.dcnet.object.BuildPicObject;
import jp.dcnet.object.PictureObject;
import jp.dcnet.object.RoomObject;
import jp.dcnet.repository.FavoriteRepository;
import jp.dcnet.repository.PictureRepository;
import jp.dcnet.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	FavoriteRepository favoriteRepository;

	@Autowired
	PictureRepository pictureRepository;

	@Transactional
	public void addRoomInfo(RoomObject roomObject) {
		Room room = new Room();

		room.setBuildId(roomObject.buildId);
		room.setRoomName(roomObject.getRoomName());
		room.setRent(roomObject.getRent());
		room.setManagementfee(roomObject.getManagementfee());
		room.setSecuritydeposit(roomObject.getSecuritydeposit());
		room.setKeymoney(roomObject.getKeymoney());
		room.setFloorplan(roomObject.getFloorplan());
		room.setArea(roomObject.getArea());

		room.setDateofconstruction(roomObject.getDateofconstruction());
		room.setEvent(roomObject.getEvent());
		room.setFloor(roomObject.getFloor());
		room.setAddress(roomObject.getAddress());
		room.setStation(roomObject.getStation());
		room.setUpdatetime(new Timestamp(System.currentTimeMillis()));
		roomRepository.save(room);
	}

	/**
	 * find rooms
	 * 
	 * @return
	 */
	public List<RoomObject> findAllRoomById(int buildId) {

		List<Room> entity = roomRepository.findByBuildIdOrderByRoomIdAsc(buildId);

		List<RoomObject> roomObj = new ArrayList<RoomObject>();

		for (Room r : entity) {
			RoomObject obj = new RoomObject();

			obj.setBuildId(r.buildId);
			obj.setRoomId(r.roomId);
			obj.setRoomName(r.getRoomName());
			obj.setRent(r.getRent());
			obj.setManagementfee(r.getManagementfee());
			obj.setSecuritydeposit(r.getSecuritydeposit());
			obj.setKeymoney(r.getKeymoney());
			obj.setFloorplan(r.getFloorplan());
			obj.setArea(r.getArea());
			obj.setDateofconstruction(r.getDateofconstruction());
			obj.setEvent(r.getEvent());
			obj.setFloor(r.getFloor());
			obj.setAddress(r.getAddress());
			obj.setStation(r.getStation());
			obj.setUpdatetime(r.getUpdatetime());
			obj.setPictureurl(ShowRoomPics(r.roomId));
			obj.setFav(getFav(r.roomId));
			roomObj.add(obj);
		}

		return roomObj;
	}

	public boolean getFav(int roomId) {

		boolean fav = false;

		Favorite favEntity = favoriteRepository.findByRoomId(roomId);

		if (favEntity != null) {

			fav = true;
		}

		return fav;
	}

	/**
	 * find all
	 * 
	 * @return
	 */
	public List<RoomObject> findAllxx() {

		List<RoomObject> roomList = new ArrayList<>();

		List<Room> room = roomRepository.findAll();
		for (Room entity : room) {
			RoomObject obj = new RoomObject();
			obj.setRoomId(entity.roomId);
			obj.setBuildId(entity.buildId);
			obj.setRoomName(entity.getRoomName());
			obj.setRent(entity.getRent());
			obj.setManagementfee(entity.getManagementfee());
			obj.setSecuritydeposit(entity.getSecuritydeposit());
			obj.setKeymoney(entity.getKeymoney());
			obj.setFloorplan(entity.getFloorplan());
			obj.setArea(entity.getArea());
			obj.setDateofconstruction(entity.getDateofconstruction());
			obj.setEvent(entity.getEvent());
			obj.setFloor(entity.getFloor());
			obj.setAddress(entity.getAddress());
			obj.setStation(entity.getStation());
			obj.setUpdatetime(entity.getUpdatetime());
			obj.setPictureurl(ShowRoomPics(entity.roomId));
			obj.setFav(getFav(entity.roomId));
			roomList.add(obj);
		}

		return roomList;

	}

	/**
	 * find one room情報取得
	 * 
	 * @param roomId
	 * @return
	 */
	public RoomObject roomInfoEdit(int roomId) {

		Room entity = roomRepository.findByRoomId(roomId);

		RoomObject obj = new RoomObject();
		obj.setRoomId(roomId);
		obj.setBuildId(entity.getBuildId());
		obj.setRoomName(entity.getRoomName());
		obj.setRent(entity.getRent());
		obj.setManagementfee(entity.getManagementfee());
		obj.setSecuritydeposit(entity.getSecuritydeposit());
		obj.setKeymoney(entity.getKeymoney());
		obj.setFloorplan(entity.getFloorplan());
		obj.setArea(entity.getArea());
		obj.setDateofconstruction(entity.getDateofconstruction());
		obj.setEvent(entity.getEvent());
		obj.setFloor(entity.getFloor());
		obj.setAddress(entity.getAddress());
		obj.setStation(entity.getStation());
		obj.setUpdatetime(new Timestamp(System.currentTimeMillis()));

		return obj;
	}

	public void roomEdit(RoomObject roomObject, int roomId) {

		Room entity = roomRepository.findByRoomId(roomId);

		entity.setBuildId(roomObject.buildId);
		entity.setRoomName(roomObject.getRoomName());
		entity.setRent(roomObject.getRent());
		entity.setManagementfee(roomObject.getManagementfee());
		entity.setSecuritydeposit(roomObject.getSecuritydeposit());
		entity.setKeymoney(roomObject.getKeymoney());
		entity.setFloorplan(roomObject.getFloorplan());
		entity.setArea(roomObject.getArea());

		entity.setDateofconstruction(roomObject.getDateofconstruction());
		entity.setEvent(roomObject.getEvent());
		entity.setFloor(roomObject.getFloor());
		entity.setAddress(roomObject.getAddress());
		entity.setStation(roomObject.getStation());
		entity.setUpdatetime(new Timestamp(System.currentTimeMillis()));
		roomRepository.save(entity);

	}

	/**
	 * creat.upload
	 * 
	 * @param room
	 * @return
	 */
	public Room save(Room room) {
		return roomRepository.save(room);
	}

	/**
	 * delete by id
	 * 
	 * @param roomId
	 */
	public void delete(int roomId) {
		roomRepository.deleteById(roomId);
	}

	/**
	 * 
	 * @param roomId
	 * @return
	 */
	public int getBuildId(int roomId) {
		// TODO 自動生成されたメソッド・スタブ
		int buildId = roomRepository.findById(roomId).get().buildId;
		return buildId;
	}

	/**
	 * 一つroomに写真保存するように
	 * 
	 * @param roomId
	 * @return
	 */
	public List<Picture> findOne(int roomId) {
		// TODO 自動生成されたメソッド・スタブ
		return pictureRepository.getRoom(roomId);
	}

	/**
	 * build id
	 * 
	 * @param buildId
	 * @return
	 */
	public int getRoomId(int buildId) {
		// TODO 自動生成されたメソッド・スタブ
		int roomId = roomRepository.findById(buildId).get().roomId;
		return roomId;
	}

	public List<RoomObject> ShowRooms() {
		// TODO 自動生成されたメソッド・スタブ

		List<RoomObject> roomObj = new ArrayList<RoomObject>();
		List<Room> rooms = new ArrayList<Room>();

		for (Room room : rooms) {
			RoomObject robj = new RoomObject();
			robj.setRoomName(room.getRoomName());
			robj.setRent(room.getRent());
			robj.setManagementfee(room.getManagementfee());
			robj.setSecuritydeposit(room.getSecuritydeposit());
			robj.setKeymoney(room.getKeymoney());
			robj.setFloorplan(room.getFloorplan());
			robj.setArea(room.getArea());
			robj.setDateofconstruction(room.getDateofconstruction());
			robj.setEvent(room.getEvent());
			robj.setFloor(room.getFloor());
			robj.setAddress(room.getAddress());
			robj.setStation(room.getStation());
			robj.setUpdatetime(new Timestamp(System.currentTimeMillis()));
			robj.setPictureurl(ShowRoomPics(room.roomId));
			roomObj.add(robj);

		}
		return roomObj;
	}

	public List<PictureObject> ShowRoomPics(int roomId) {

		List<Picture> pictures = pictureRepository.findByRoomId(roomId);
		List<PictureObject> picObj = new ArrayList<PictureObject>();
		for (Picture picture : pictures) {

			PictureObject pictureObj = new PictureObject();
			pictureObj.setPictureurl(picture.getPictureurl());
			pictureObj.setCreatetime(new Timestamp(System.currentTimeMillis()));
			picObj.add(pictureObj);

		}
		return picObj;

	}

	public int findBidByRid(int roomId) {
		
		int bid= (int)roomRepository.findById(roomId).get().buildId;// TODO 自動生成されたメソッド・スタブ
		return bid;
	}

	/**
	 * 
	 * 写真の編集
	 * 
	 * @param roomId
	 * @return
	 */
		public List<PictureObject> findPicByRoomId(int roomId) {

			List<PictureObject> showPObj = new ArrayList<PictureObject>();
			List<Picture> showRPic = pictureRepository.findByRoomId(roomId);
			for (Picture pic : showRPic) {
				PictureObject bpic = new PictureObject();
				bpic.setPicId(pic.picId);
				bpic.setRoomId(roomId);
				bpic.setCreatetime(new Timestamp(System.currentTimeMillis()));
				bpic.setPictureurl(pic.getPictureurl());
				showPObj.add(bpic);

			}
			return showPObj;
		}

	public void deleteByRoomId(int roomId) {
		// TODO 自動生成されたメソッド・スタブ
		List<Picture> findByRoomId = pictureRepository.findByRoomId(roomId);
		pictureRepository.deleteAll(findByRoomId);
	}

	public int findRidByPid(int picId) {
		// TODO 自動生成されたメソッド・スタブ
		
		int Rid = pictureRepository.findById(picId).get().getRoomId();
		return Rid;
	}

	public void deleteById(int picId) {
		// TODO 自動生成されたメソッド・スタブ
		pictureRepository.deleteById(picId);
	}
	
		
}
