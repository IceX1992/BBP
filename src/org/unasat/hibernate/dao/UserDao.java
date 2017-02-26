package org.unasat.hibernate.dao;

import java.util.List;

import org.unasat.model.User;

public interface UserDao {
	List<User> getListOfUsers();
	User getUserByUserId(String userId);
	boolean save(User user);
	boolean isUserExists(User user);
}
