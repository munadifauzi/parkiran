package com.lawencon.parkirapps.dao.impl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.parkirapps.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

	User findByUserNameAndPassword(String userName, String password) throws Exception;
}
