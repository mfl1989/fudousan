package jp.dcnet.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jp.dcnet.entity.BuildPic;
@Repository
public interface BuildPicRepository extends JpaRepository<BuildPic, Integer>{
	
	
	@Query(value = "select * from build_pic where build_id =:id", nativeQuery = true)
	List<BuildPic> getBuild(@Param("id")int buildId);

	ArrayList<BuildPic> findByBuildPid(int id);
	List<BuildPic> findByBuildId(int buildId);


	
	
}
