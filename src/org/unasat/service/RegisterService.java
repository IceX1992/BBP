package org.unasat.service;

import org.unasat.hibernate.dao.UserDao;
import org.unasat.model.User;

public class RegisterService {
	
	UserDao userDao;
	
	public RegisterService() {
	}
	
    public RegisterService(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	public boolean register(User user) {
		return userDao.save(user);
	}

}