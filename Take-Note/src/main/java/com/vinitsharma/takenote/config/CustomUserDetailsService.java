package com.vinitsharma.takenote.config;

import com.vinitsharma.takenote.entity.User;
import com.vinitsharma.takenote.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = this.userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found!");
		}else {
			return new CustomUser(user);//custom user class constructor.
		}
		
		
	}

}
