package com.lawencon.parkirapps.dao.impl.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.parkirapps.dao.UserDao;
import com.lawencon.parkirapps.model.User;

@Repository("user_repo_jpa")
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepo userRepo;

	@Override
	public User save(User user) throws Exception {
		return userRepo.save(user);
	}

	@Override
	public User findByUserNameAndPassword(String userName, String password) throws Exception {
		return userRepo.findByUserNameAndPassword(userName, password);

	}

}
