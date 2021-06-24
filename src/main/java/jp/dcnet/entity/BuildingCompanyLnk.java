package jp.dcnet.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Table(name = "building_company_lnk")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BuildingCompanyLnk {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int companyId;
	public int userId;
	public Timestamp createdDate;

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

}
