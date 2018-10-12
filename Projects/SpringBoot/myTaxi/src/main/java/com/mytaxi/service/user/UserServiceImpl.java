package com.mytaxi.service.user;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mytaxi.dataaccessobject.RoleRepository;
import com.mytaxi.dataaccessobject.UserRepository;
import com.mytaxi.domainobject.RoleDO;
import com.mytaxi.domainobject.UserDO;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDO findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(UserDO user) {
	    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		RoleDO userRole = roleRepository.findByRole("ADMIN");
		user.setRoles(new HashSet<RoleDO>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

	@Override
	public List<UserDO> getAllUsers() {
		return userRepository.findAll();
	}
}