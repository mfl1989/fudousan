package jp.dcnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.dcnet.entity.BuildingCompanyLnk;
@Repository
public interface BuildingCompanyLnkRepository extends JpaRepository< BuildingCompanyLnk, Integer> {

}
