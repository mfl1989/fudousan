package jp.dcnet.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Table(name = "build")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Build {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int buildId;
	public int companyId;
	private String buildName;
	private String address;
	private String station;
	private String parkinglot;
	private String dateofconstruction;
	private String mainlightingsurface;
	public Timestamp updatetime;
	

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
