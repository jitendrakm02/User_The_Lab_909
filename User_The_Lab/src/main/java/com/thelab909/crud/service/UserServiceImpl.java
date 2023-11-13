package com.thelab909.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thelab909.crud.model.User;
import com.thelab909.crud.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repo;

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public User getUserById(long id) {
		Optional<User > optional = repo.findById(id);
		User user=null;
		if(optional.isPresent()) {
			user=optional.get();
		}
		else {
            throw new RuntimeException(" User not found for id :: " + id);

		}
		return user;
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return repo.save(user);
		}

	@Override
	public User updateUser(User user,Long id) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
