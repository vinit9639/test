package com.vinitsharma.takenote.service;

import com.vinitsharma.takenote.entity.User;

public interface UserService {
	
	User saveUser(User user);
	
	boolean emailExistOrNot(String email);
	
	 public User getUserByEmail(String email);
	 
	 

}
