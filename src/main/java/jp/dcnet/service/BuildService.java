package jp.dcnet.service;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jp.dcnet.entity.Build;
import jp.dcnet.entity.BuildPic;
import jp.dcnet.entity.Picture;
import jp.dcnet.entity.Room;
import jp.dcnet.object.BuildObject;
import jp.dcnet.object.BuildPicObject;
import jp.dcnet.object.BuildViewObject;
import jp.dcnet.object.RoomObject;
import jp.dcnet.repository.BuildPicRepository;
import jp.dcnet.repository.BuildRepository;
import jp.dcnet.repository.PictureRepository;
import jp.dcnet.repository.RoomRepository;

@Service
public class BuildService {

	@Autowired
	BuildRepository buildRepository;
	@Autowired
	BuildPicRepository buildPicRepository;
	@Autowired
	RoomRepository roomRepository;
	@Autowired
	PictureRepository pictureRepository;

	/**
	 * 物件新規登録処理
	 * 
	 * @param buildobject
	 */
	@Transactional
	public void buildService(BuildObject buildobject) {
		Build build = new Build();

		build.setCompanyId(buildobject.getCompanyId());
		build.setBuildName(buildobject.getBuildName());
		build.setAddress(buildobject.getAddress());
		build.setStation(buildobject.getStation());
		build.setParkinglot(buildobject.getParkinglot());
		build.setDateofconstruction(buildobject.getDateofconstruction());
		build.setMainlightingsurface(buildobject.getMainlightingsurface());
		build.setUpdatetime(new Timestamp(System.currentTimeMillis()));
		buildRepository.save(build);

	}

	/**
	 * 建物情報更新
	 * 
	 * @param buildobject
	 * @param buildid
	 */
	@Transactional
	public void buildUpdate(BuildObject buildobject, int buildid) {
		Build build = buildRepository.findById(buildid).get();

		build.setCompanyId(buildobject.getCompanyId());
		build.setBuildName(buildobject.getBuildName());
		build.setAddress(buildobject.getAddress());
		build.setStation(buildobject.getStation());
		build.setParkinglot(buildobject.getParkinglot());
		build.setDateofconstruction(buildobject.getDateofconstruction());
		build.setMainlightingsurface(buildobject.getMainlightingsurface());
		build.setUpdatetime(new Timestamp(System.currentTimeMillis()));
		buildRepository.save(build);

	}

	public List<BuildObject> findAllBuild(int companyId) {

		List<BuildObject> list = new ArrayList<BuildObject>();

		List<Build> entity = buildRepository.findByCompanyIdOrderByBuildIdAsc(companyId);

		for (Build build : entity) {
			BuildObject buildobj = new BuildObject();
			buildobj.setBuildId(build.getBuildId());
			buildobj.setCompanyId(build.getCompanyId());
			buildobj.setBuildName(build.getBuildName());
			buildobj.setAddress(build.getAddress());
			buildobj.setStation(build.getStation());
			buildobj.setParkinglot(build.getParkinglot());
			buildobj.setDateofconstruction(build.getDateofconstruction());
			buildobj.setMainlightingsurface(build.getMainlightingsurface());
			list.add(buildobj);
		}

		return list;

	}

	/**
	 * loopすると 写真保存
	 * 
	 * BuildPicture 保存
	 * 
	 * @param buildId
	 * @param list
	 */
	public void createPicture(int buildId, List<String> list) {

		for (int i = 0; i < list.size(); i++) {
			BuildPic Pic = new BuildPic();
			Pic.setBuildId(buildId);
			Pic.setBuildPicurl(list.get(i));
			;
			Pic.setCreatetime(new Timestamp(System.currentTimeMillis()));

			buildPicRepository.save(Pic);
		}
	}

	/**
	 * RoomPicture 保存
	 * 
	 * @param roomId
	 * @param list
	 */
	public void createRoomPicture(int roomId, List<String> list) {

		for (int i = 0; i < list.size(); i++) {
			Picture Pic = new Picture();
			Pic.setRoomId(roomId);
			Pic.setPictureurl(list.get(i));
			;
			Pic.setCreatetime(new Timestamp(System.currentTimeMillis()));

			pictureRepository.save(Pic);
		}
	}

	/**
	 * 写真アップロード save build pic
	 * 
	 * @param request
	 * @param file
	 * @param list
	 * @return
	 */
	public List<String> saveFile(MultipartFile file, List<String> list) {
		// 判断文件是否为空
		if (!file.isEmpty()) {
			try {
				// 保存的文件路径(如果用的是Tomcat服务器，文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\upload\\文件夹中
				// )

				String filePath = "C:\\Users\\mfl\\eclipse-workspace\\fudousan\\src\\main\\resources\\static\\images\\imgs\\"
						+ file.getOriginalFilename();
				list.add("../images/imgs/" + file.getOriginalFilename());
				File saveDir = new File(filePath);
				if (!saveDir.getParentFile().exists())
					saveDir.getParentFile().mkdirs();

				// 转存文件
				file.transferTo(saveDir);
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	/**
	 * save rooms picture
	 * 
	 * @param file
	 * @param list
	 * @return
	 */
	public List<String> saveRoomsFile(MultipartFile file, List<String> list) {
		// 判断文件是否为空
		if (!file.isEmpty()) {
			try {
				// 保存的文件路径(如果用的是Tomcat服务器，文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\upload\\文件夹中
				// )

				String filePath = "C:\\Users\\mfl\\eclipse-workspace\\fudousan\\src\\main\\resources\\static\\images\\rooms\\"
						+ file.getOriginalFilename();
				list.add("../images/rooms/" + file.getOriginalFilename());
				File saveDir = new File(filePath);
				if (!saveDir.getParentFile().exists())
					saveDir.getParentFile().mkdirs();

				// 转存文件
				file.transferTo(saveDir);
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	/**
	 * 建物情報取得
	 * 
	 * @param buildId
	 * @return
	 */
	public BuildObject findByBuildId(int buildId) {
		Build build = buildRepository.findById(buildId).get();

		BuildObject buildObject = new BuildObject();
		buildObject.setBuildId(build.getBuildId());
		buildObject.setCompanyId(build.getCompanyId());
		buildObject.setBuildName(build.getBuildName());
		buildObject.setAddress(build.getAddress());
		buildObject.setStation(build.getStation());
		buildObject.setParkinglot(build.getParkinglot());
		buildObject.setDateofconstruction(build.getDateofconstruction());
		buildObject.setMainlightingsurface(build.getMainlightingsurface());

		return buildObject;
	}

	/**
	 * delete by id
	 * 
	 * @param buildId
	 */
	public void delete(int buildId) {
		buildRepository.deleteById(buildId);
	}

	/**
	 * 複数の検索 build build picture room
	 * 
	 * @param buildId
	 * @return
	 */
	public BuildViewObject getBuildViewInfo(int buildId) {
		Build build = buildRepository.findById(buildId).get();
		// buildObject のＧＥＴＥＲ ｓｅｔｅｒ
		BuildViewObject buildObject = new BuildViewObject();
		buildObject.setBuildId(build.getBuildId());
		buildObject.setCompanyId(build.getCompanyId());
		buildObject.setBuildName(build.getBuildName());
		buildObject.setAddress(build.getAddress());
		buildObject.setStation(build.getStation());
		buildObject.setParkinglot(build.getParkinglot());
		buildObject.setDateofconstruction(build.getDateofconstruction());
		buildObject.setMainlightingsurface(build.getMainlightingsurface());
		// 配列に写真を入れる ループして buildObject保存する

		ArrayList<BuildPic> findByBuildPid = buildPicRepository.findByBuildPid(buildId);
		ArrayList<BuildPicObject> buildPics = new ArrayList<>();
		for (BuildPic pics : findByBuildPid) {
			BuildPicObject buildPic = new BuildPicObject();
			buildPic.setBuildId(pics.getBuildId());
			// buildPic.setBuildPicurl(pics.getBuildPicurl());
			buildPic.setCreatetime(new Timestamp(System.currentTimeMillis()));
		}

		buildObject.setPictures(buildPics);
		// 配列に部屋を入れる ループして buildObject保存する
		List<Room> findbByRoom = roomRepository.findByRoomIdOrderByRoomIdAsc(buildId);
		if (findbByRoom != null) {
			ArrayList<RoomObject> rooms = new ArrayList<>();
			for (Room Room : findbByRoom) {
				RoomObject roomObj = new RoomObject();

				roomObj.setRoomName(Room.getRoomName());
				roomObj.setRent(Room.getRent());
				roomObj.setManagementfee(Room.getManagementfee());
				roomObj.setSecuritydeposit(Room.getSecuritydeposit());
				roomObj.setKeymoney(Room.getKeymoney());
				roomObj.setFloorplan(Room.getFloorplan());
				roomObj.setArea(Room.getArea());
				roomObj.setDateofconstruction(Room.getDateofconstruction());
				roomObj.setEvent(Room.getEvent());
				roomObj.setFloor(Room.getFloor());
				roomObj.setAddress(Room.getAddress());
				roomObj.setStation(Room.getStation());
				roomObj.setUpdatetime(new Timestamp(System.currentTimeMillis()));
				rooms.add(roomObj);
			}
			buildObject.setRooms(rooms);
		} else {
			buildObject = null;
		}
		return buildObject;
	}

	/**
	 * find one
	 * 
	 * @param buildId
	 * @return
	 */
	public List<BuildPic> findOne(int buildId) {
		return buildPicRepository.getBuild(buildId);
	}

	/**
	 * 
	 * @param build
	 * @return
	 */
	public Build save(Build build) {
		return buildRepository.save(build);
	}

	/**
	 * 
	 * @return
	 */
	public List<BuildObject> FindAllBuildRoom() {
		List<Build> showB = buildRepository.findAll();

		List<BuildObject> showBObj = new ArrayList<BuildObject>();
		if (showB != null) {
			for (Build sb : showB) {
				BuildObject sbo = new BuildObject();

				sbo.setBuildId(sb.getBuildId());
				sbo.setCompanyId(sb.getCompanyId());
				sbo.setBuildName(sb.getBuildName());
				sbo.setAddress(sb.getAddress());
				sbo.setStation(sb.getStation());
				sbo.setParkinglot(sb.getParkinglot());
				sbo.setDateofconstruction(sb.getDateofconstruction());
				sbo.setMainlightingsurface(sb.getMainlightingsurface());
				sbo.setBuildPicurl(findAllBuildPic(sb.getBuildId()));
				sbo.setUpdatetime(new Timestamp(System.currentTimeMillis()));
				showBObj.add(sbo);
			}
		} else {
			showBObj = null;
		}
		return showBObj;
	}

	/**
	 * buildId 下 の 写真 ループする
	 * 
	 * @param buildId
	 * @return
	 */
	public List<BuildPicObject> findAllBuildPic(int buildId) {

		List<BuildPicObject> showBObj = new ArrayList<BuildPicObject>();
		List<BuildPic> showBPic = buildPicRepository.findByBuildId(buildId);
		for (BuildPic pic : showBPic) {
			BuildPicObject bpic = new BuildPicObject();
			bpic.setBuildPid(pic.buildPid);
			bpic.setBuildId(buildId);
			bpic.setCreatetime(new Timestamp(System.currentTimeMillis()));
			bpic.setBuildPicurl(pic.getBuildPicurl());
			showBObj.add(bpic);

		}
		return showBObj;
	}

	public void adminDeleteBuild(int buildId) {
		// TODO 自動生成されたメソッド・スタブ
		buildRepository.deleteById(buildId);
	}

	public void deleteByBuildId(int buildId) {
		// TODO 自動生成されたメソッド・スタブ
		List<BuildPic> findByBuildId = buildPicRepository.findByBuildId(buildId);
		buildPicRepository.deleteAll(findByBuildId);

	}
	

	/**
	 * find build By buildPid
	 * 
	 * @param buildPid
	 * @return
	 */
	public int findBidByRid(int buildPid) {

		int bid = buildPicRepository.findById(buildPid).get().getBuildId();
		return bid;
	}

	
	public void deleteById(int buildPid) {
		// TODO 自動生成されたメソッド・スタブ
		buildPicRepository.deleteById(buildPid);
	}

}