package jp.dcnet.object;

import java.sql.Timestamp;

public class BuildingCompanyLnkOBJ {

	public int companyId;
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
