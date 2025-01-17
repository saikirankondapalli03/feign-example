package com.travellerapp.business;

import java.util.List;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travellerapp.domain.User;
import com.travellerapp.repositories.UserRepository;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> listAllUsers() {
		List<User> users=   userRepository.findAll();
		return users;
	}
	
	@Override
	public User getUserById(String id) {
	   return userRepository.findUserBy_id(new ObjectId(id));
	}

	
	@Override
	public User getUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}
	


	
	@Override
	public User createUser(User user) {
		User savedUser=userRepository.save(user);//execute insert scripts in db
		return savedUser;
	}
	
	
	@Override
	public User updateUser(ObjectId id, User user) {
		user.setId(id);
		return userRepository.save(user);
	}
	
	@Override
	public void deleteUser(ObjectId id) {
		userRepository.delete(userRepository.findUserBy_id(id));
	}
	
	
	@Override
	public List<User> createUsers(List<User> users) {
		return userRepository.saveAll(users);
	}
	

}
