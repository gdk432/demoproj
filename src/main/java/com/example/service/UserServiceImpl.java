package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		
		return userRepository.save(user);
	}

	
	@Override
	public List<User> getAll(){
		return userRepository.findAll();
	}
	
	
	
	@Override
	public List<User> getAllwithPage(int pageNumber, int pageSize){
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		
		return userRepository.findAll(pageable).getContent();
	}
	
	
	
	
	@Override
	public List<User> findByfirstname(String firstname, int pageNumber, int pageSize){
		Pageable pageable = PageRequest.of(pageNumber, pageSize,Sort.by(Direction.ASC, "firstname"));
		return userRepository.findByfirstnameContains(firstname,pageable);
		
	}
	
	@Override
	public User getById(int userid) {
		Optional<User> user =  userRepository.findById(userid);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}


	@Override
	public User deleteById(int userid) {
		userRepository.deleteById(userid);
		return null;
	}


	
	@Override
	public List<User> getUserByfirstnameAndlastname(String firstname, String lastname) {
		return userRepository.findByfirstnameAndLastname(firstname, lastname);
		
	}


	@Override
	public List<User> getUserByfirstnameOrlastname(String firstname, String lastname) {
		return userRepository.findByfirstnameOrLastname(firstname, lastname);
	}


	@Override
	public List<User> getUserByfirstnameContainsOrlastnameContains(String firstname, String lastname) {
		
		return userRepository.findByfirstnameContainsOrLastnameContains(firstname, lastname);
	}


	@Override
	public List<User> getUserByfirstnameContainsOrlastnameContainsOrderByfirstnameAsc(String firstname,
			String lastname) {
		
		return userRepository.findByfirstnameContainsOrLastnameContainsOrderByFirstnameAsc(firstname, lastname);
	}


	@Override
	public List<User> getUserByFirstNameContainsOrLastNameContainsOrderByfirstnameDesc(String firstname,
			String lastname) {
		
		return userRepository.findByfirstnameContainsOrLastnameContainsOrderByFirstnameDesc(firstname, lastname);
	}
	
	
	
	@Override
	public List<User> searchUserAnd(String firstname,String lastname) {
		
		return userRepository.searchUserAnd(firstname, lastname);
	}

	@Override
	public List<User> searchUserOr(String firstname,String lastname) {
		
		return userRepository.searchUserOr(firstname, lastname);
	}

	
	
	@Override
	public List<User> searchUsersql(String firstname,String lastname) {
		
		return userRepository.searchUsersql(firstname, lastname);
	}
	
}
