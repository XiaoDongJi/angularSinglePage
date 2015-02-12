package com.mvc.service;

import java.util.List;

import com.mvc.model.User;

public interface UserService {
	
	public void saveUser(User user);
	public void updateUser(User user);
	public User getUser(String id);
	public void deleteUser(String id);
	public List<User> getAllUser();
	public void createCollection();
	public void dropCollection();
}
