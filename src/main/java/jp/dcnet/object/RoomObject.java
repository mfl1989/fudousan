package jp.dcnet.object;

import java.sql.Timestamp;
import java.util.List;

public class RoomObject {
	
	public int roomId;
	public int buildId;
	
	public String roomName;
	public String rent;
	public String managementfee;
	public String securitydeposit;
	public String keymoney;
	public String floorplan;
	public String area;
	public String dateofconstruction;
	public String event;
	public String floor;
	public String address;
	public String station;
	public Timestamp updatetime;
	public List<PictureObject> pictureurl;
	public boolean Fav;
	
	
	
	public boolean isFav() {
		return Fav;
	}

	public void setFav(boolean fav) {
		Fav = fav;
	}

	public List<PictureObject> getPictureurl() {
		return pictureurl;
	}

	public void setPictureurl(List<PictureObject> pictureurl) {
		this.pictureurl = pictureurl;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public int getBuildId() {
		return buildId;
	}

	public void setBuildId(int buildId) {
		this.buildId = buildId;
	}

	public String getRent() {
		return rent;
	}

	public void setRent(String rent) {
		this.rent = rent;
	}

	public String getManagementfee() {
		return managementfee;
	}

	public void setManagementfee(String managementfee) {
		this.managementfee = managementfee;
	}

	public String getSecuritydeposit() {
		return securitydeposit;
	}

	public void setSecuritydeposit(String securitydeposit) {
		this.securitydeposit = securitydeposit;
	}

	public String getKeymoney() {
		return keymoney;
	}

	public void setKeymoney(String keymoney) {
		this.keymoney = keymoney;
	}

	public String getFloorplan() {
		return floorplan;
	}

	public void setFloorplan(String floorplan) {
		this.floorplan = floorplan;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDateofconstruction() {
		return dateofconstruction;
	}

	public void setDateofconstruction(String dateofconstruction) {
		this.dateofconstruction = dateofconstruction;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

}
