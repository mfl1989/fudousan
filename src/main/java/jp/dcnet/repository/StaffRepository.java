package jp.dcnet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.dcnet.entity.Staff;
@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {

	List<Staff> findAllByCompanyId(int companyId);

	


}
