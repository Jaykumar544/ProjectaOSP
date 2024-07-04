package com.biit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.biit.entities.User;
import com.biit.repositories.UserRepository;

import java.util.Optional;

@Component
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> optionalUser = userRepository.findByEmail(username);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			System.out.println(user.getName() + " is loaded.");
			System.out.println("roles: "+user.getRoles());
            return org.springframework.security.core.userdetails.User.builder()
					.username(user.getName()).password(user.getPassword()).accountExpired(false)
					.roles(user.getRoles().split(",")).build();
		}

		throw new UsernameNotFoundException("No user found for username " + username);
	}

}