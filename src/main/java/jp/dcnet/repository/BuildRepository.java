package jp.dcnet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jp.dcnet.entity.Build;
import jp.dcnet.entity.Picture;

@Repository
public interface BuildRepository extends JpaRepository<Build, Integer> {

	List<Build> findByCompanyIdOrderByBuildIdAsc(int companyId);
	
	@Query(value = "select * from room_pic where build_id =:id", nativeQuery = true)
	List<Picture> getRoom(@Param("id")int roomId);
	
	
	
}
