package com.lawencon.parkirapps.dao;

import com.lawencon.parkirapps.model.User;

public interface UserDao {

	User save(User user) throws Exception;

	User findByUserNameAndPassword(String userName, String password) throws Exception;
}
