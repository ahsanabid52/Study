package com.mytaxi.dataaccessobject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mytaxi.domainobject.RoleDO;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<RoleDO, Integer>{
	RoleDO findByRole(String role);
}