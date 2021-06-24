package jp.dcnet.object;

import java.sql.Timestamp;
import java.util.ArrayList;

public class BuildViewObject {

	private int buildId;
	private int companyId;
	private String buildName;
	private String address;
	private String station;
	private String parkinglot;
	private String dateofconstruction;
	private String mainlightingsurface;
	private Timestamp updatetime;
	private ArrayList<BuildPicObject> pictures;
	private ArrayList<RoomObject> rooms;

	public int getBuildId() {
		return buildId;
	}

	public void setBuildId(int buildId) {
		this.buildId = buildId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
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

	public String getParkinglot() {
		return parkinglot;
	}

	public void setParkinglot(String parkinglot) {
		this.parkinglot = parkinglot;
	}

	public String getDateofconstruction() {
		return dateofconstruction;
	}

	public void setDateofconstruction(String dateofconstruction) {
		this.dateofconstruction = dateofconstruction;
	}

	public String getMainlightingsurface() {
		return mainlightingsurface;
	}

	public void setMainlightingsurface(String mainlightingsurface) {
		this.mainlightingsurface = mainlightingsurface;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public ArrayList<BuildPicObject> getPictures() {
		return pictures;
	}

	public void setPictures(ArrayList<BuildPicObject> pictures) {
		this.pictures = pictures;
	}

	public ArrayList<RoomObject> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<RoomObject> rooms) {
		this.rooms = rooms;
	}

}
