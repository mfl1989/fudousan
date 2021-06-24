package jp.dcnet.object;

import java.sql.Timestamp;
import java.util.ArrayList;

public class BuildPicObject {
	private int buildId;
	private Timestamp createtime;
	public int buildPid;
	public String buildPicurl;

	

	

	public String getBuildPicurl() {
		return buildPicurl;
	}

	public void setBuildPicurl(String buildPicurl) {
		this.buildPicurl = buildPicurl;
	}

	/*
	 * public String getBuildPicurl() { return buildPicurl; }
	 * 
	 * public void setBuildPicurl(String buildPicurl) { this.buildPicurl =
	 * buildPicurl; }
	 */
	public int getBuildPid() {
		return buildPid;
	}

	public void setBuildPid(int buildPid) {
		this.buildPid = buildPid;
	}
	public int getBuildId() {
		return buildId;
	}

	public void setBuildId(int buildId) {
		this.buildId = buildId;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
}
