package com.lawencon.parkirapps.dao.impl.hibernate;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.parkirapps.dao.UserDao;
import com.lawencon.parkirapps.model.User;

@Repository("user_repo_hibernate")
public class UserDaoImpl extends BaseHibernate implements UserDao {

	@Override
	public User save(User user) throws Exception {
		em.persist(user);
		return user;
	}

	@Override
	public User findByUserNameAndPassword(String userName, String password) throws Exception {
		Query q = em.createQuery(" from User where userName = :userNameParam and password= :passwordParam");
		q.setParameter("userNameParam", userName);
		q.setParameter("passwordParam", password);

		User user = (User) q.getSingleResult();
		return user;
	}

}
