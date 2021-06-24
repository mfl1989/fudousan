package jp.dcnet.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mesage")
public class MSG {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
