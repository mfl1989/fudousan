package jp.dcnet.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.dcnet.entity.UserInto;
@Repository
public interface UserRepository extends JpaRepository<UserInto, Integer> {

	
	
	UserInto findByEmail(String email);
}
