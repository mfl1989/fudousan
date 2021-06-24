package jp.dcnet.object;

public class MSGObject {

	
	
	public int mesageId;
	public int companyId;
	public int userId;
	public String adminMesage;

	public String mesage;

	public int getMesageId() {
		return mesageId;
	}

	public void setMesageId(int mesageId) {
		this.mesageId = mesageId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAdminMesage() {
		return adminMesage;
	}

	public void setAdminMesage(String adminMesage) {
		this.adminMesage = adminMesage;
	}

	public String getMesage() {
		return mesage;
	}

	public void setMesage(String mesage) {
		this.mesage = mesage;
	}

}
