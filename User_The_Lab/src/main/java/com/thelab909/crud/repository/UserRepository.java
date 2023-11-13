package com.thelab909.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thelab909.crud.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	

}
