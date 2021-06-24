package jp.dcnet.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Table(name = "build_pic")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BuildPic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int buildPid;
	private int buildId;
	private Timestamp createtime;
	public String buildPicurl;

	public String getBuildPicurl() {
		return buildPicurl;
	}

	public void setBuildPicurl(String buildPicurl) {
		this.buildPicurl = buildPicurl;
	}

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
