package com.lawencon.parkirapps.service;

import com.lawencon.parkirapps.model.User;

public interface UserService {

	User save(User user) throws Exception;

	User findByUserNameAndPassword(String userName, String password) throws Exception;
}
