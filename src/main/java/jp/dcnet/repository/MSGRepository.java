package jp.dcnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.dcnet.entity.MSG;
@Repository
public interface MSGRepository extends   JpaRepository<MSG, Integer> {

	
	
	
}
