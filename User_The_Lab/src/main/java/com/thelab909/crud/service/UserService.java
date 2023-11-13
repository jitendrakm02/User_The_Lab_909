package com.thelab909.crud.service;

import java.util.List;

import com.thelab909.crud.model.User;

public interface UserService {
	
	
    public List<User> getUsers();
	
	public User getUserById(long id);
	
	public User saveUser(User user);
	
	public User updateUser(User user,Long id);
	
	public void deleteUserById(long id);
	

}
