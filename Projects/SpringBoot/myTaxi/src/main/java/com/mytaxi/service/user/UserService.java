package com.mytaxi.service.user;

import java.util.List;

import com.mytaxi.domainobject.UserDO;

public interface UserService {
	public UserDO findUserByEmail(String email);

	public void saveUser(UserDO user);

	public List<UserDO> getAllUsers();
}
