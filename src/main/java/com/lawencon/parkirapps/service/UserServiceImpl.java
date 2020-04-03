package com.lawencon.parkirapps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.parkirapps.dao.UserDao;
import com.lawencon.parkirapps.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("user_repo_hibernate") //user_repo_jpa
	UserDao userDao;

	@Override
	public User save(User user) throws Exception {
		return userDao.save(user);
	}

	@Override
	public User findByUserNameAndPassword(String userName, String password) throws Exception {
		return userDao.findByUserNameAndPassword(userName, password);
	}

}
