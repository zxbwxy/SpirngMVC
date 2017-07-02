package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;

@Service
@Transactional
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public List<User> findAll(){
		List<User> users = new ArrayList<>();
		for (User user: userRepository.findAll()) {
			users.add(user);
			
		}
		return users;
	}
	
	public void save(User user){
		userRepository.save(user);
	}
	
	public void delete(int id){
		userRepository.delete(id);
	}
	

	
}
