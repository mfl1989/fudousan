package jp.dcnet.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.dcnet.entity.Staff;
import jp.dcnet.object.StaffObject;
import jp.dcnet.repository.StaffRepository;

@Service
public class StaffInfoService {


	
	
	@Autowired
	StaffRepository staffRep;

	public List<Staff> findAll(int companyId) {

		List<Staff> staff =staffRep.findAllByCompanyId(companyId);
		
		return staff;
	}

	public Staff findOne(int staffId) {

		return staffRep.findById(staffId).get();

	}

	public Staff save(Staff staff) {
		return staffRep.save(staff);
	}

	public void delete(int staffId) {
		staffRep.deleteById(staffId);
	}

	/**
	 * 複数のentityを削除処理
	 * 
	 * @param staff
	 */
	public void delete(List<Staff> staff) {
		staffRep.deleteInBatch(staff);
	}

	@Transactional
	public void updateStaff(StaffObject staffObj ,int staffId  ) {
		Staff staff = staffRep.findById(staffId).get();
	//	StaffObject staffObj =new StaffObject();
		staff.setStaffName(staffObj.getStaffName());
		staff.setExperience(staffObj.getExperience());
		staff.setTel(staffObj.getTel());
		staff.setUpdatetime(new Timestamp(System.currentTimeMillis()));
		staffRep.save(staff);
		
	}
	@Transactional
	public void createStaff(StaffObject staffObj) {
		Staff staff = new Staff();

		staff.setCompanyId(staffObj.getCompanyId());
		staff.setStaffName(staffObj.getStaffName());
		staff.setExperience(staffObj.getExperience());
		staff.setTel(staffObj.getTel());
		staff.setUpdatetime(new Timestamp(System.currentTimeMillis()));
		staffRep.save(staff);

	}

	public StaffObject viewTheStaff(int staffId) {

		Staff staff = staffRep.findById(staffId).get() ;
		StaffObject staffObj = new StaffObject();
		staffObj.setStaffId(staff.getStaffId());
		staffObj.setCompanyId(staff.getCompanyId());
		staffObj.setStaffName(staff.getStaffName());
		staffObj.setExperience(staff.getExperience());
		staffObj.setTel(staff.getTel());
		return staffObj;
	}
/**
 * 
 * edit 操作
 * @param staffId
 * @return
 */
	public StaffObject editStaff(int staffId) {
		
		StaffObject  staffObj = new StaffObject();
		Staff staff = staffRep.findById(staffId).get() ;

		staffObj.setCompanyId(staff.getCompanyId());
		staffObj.setStaffName(staff.getStaffName());
		staffObj.setExperience(staff.getExperience());
		staffObj.setTel(staff.getTel());
		staffObj.setUpdatetime(new Timestamp(System.currentTimeMillis()));
		return staffObj;
	}

}
