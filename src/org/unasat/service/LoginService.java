package org.unasat.service;

import java.util.List;

import org.unasat.hibernate.dao.UserDao;
import org.unasat.model.User;

public class LoginService {

	UserDao userDao;
	
	public LoginService() {
	}

	
    public LoginService(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	public boolean authenticateUser(String userId, String password) {
        User user = userDao.getUserByUserId(userId);          
        if(user!=null && user.getUserId().equals(userId) && user.getPassword().equals(password)){
            return true;
        }else{ 
            return false;
        }
    }

   
	public User getUserByUserId(String userId) {
		return userDao.getUserByUserId(userId);
	}
	public List<User> getListOfUsers() {
		return userDao.getListOfUsers();
	}
}
