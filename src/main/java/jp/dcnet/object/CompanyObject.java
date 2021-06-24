package jp.dcnet.object;

import java.sql.Timestamp;

public class CompanyObject {

	private int companyId;
	private int userId;
	private String companyname;
	private String companyaddress;
	private int companytel;
	private String companymanager;
	private String licensenumber;
	public Timestamp updatetime;
	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getCompanyaddress() {
		return companyaddress;
	}

	public void setCompanyaddress(String companyaddress) {
		this.companyaddress = companyaddress;
	}

	

	public int getCompanytel() {
		return companytel;
	}

	public void setCompanytel(int companytel) {
		this.companytel = companytel;
	}

	public String getCompanymanager() {
		return companymanager;
	}

	public void setCompanymanager(String companymanager) {
		this.companymanager = companymanager;
	}

	public String getLicensenumber() {
		return licensenumber;
	}

	public void setLicensenumber(String licensenumber) {
		this.licensenumber = licensenumber;
	}

}
