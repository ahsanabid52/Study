package com.mytaxi.dataaccessobject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mytaxi.domainobject.UserDO;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserDO, Long> {
	 UserDO findByEmail(String email);
}