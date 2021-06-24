package jp.dcnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.dcnet.entity.Company;
@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {

	
	Company findByCompanyId(int id);

	Company findByUserId(int userId);

	void deleteByUserId(int userId);
}
