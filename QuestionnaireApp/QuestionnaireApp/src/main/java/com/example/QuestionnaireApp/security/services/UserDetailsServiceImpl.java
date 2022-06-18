package com.example.QuestionnaireApp.security.services;

import com.example.QuestionnaireApp.model.User;
import com.example.QuestionnaireApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userOptional = userRepository.findUserByUsername(username);
		if(userOptional.isEmpty()) throw new UsernameNotFoundException(
				String.format("User not found with username - %s", username)
		);
		return UserDetailsImpl.build(userOptional.get());
	}
}
