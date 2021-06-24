package jp.dcnet.object;

import java.sql.Timestamp;
import java.util.List;

import jp.dcnet.entity.BuildPic;

public class BuildPlusPicObject {
	private int buildId;
	private int companyId;
	private String buildName;
	private String address;
	private String station;
	private String parkinglot;
	private String dateofconstruction;
	private String mainlightingsurface;
	public Timestamp updatetime;
	private List<BuildPic> buildPicList;

	public List<BuildPic> getBuildPicList() {
		return buildPicList;
	}

	public void setBuildPicList(List<BuildPic> buildPicList) {
		this.buildPicList = buildPicList;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getBuildId() {
		return buildId;
	}

	public void setBuildId(int buildId) {
		this.buildId = buildId;
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

}
