package com.example.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.example.entity.User;

public interface UserService {

	public User saveUser(User user);

	public List<User> getAll();

	public User getById(int userid);

	public User deleteById(int userid);

	public List<User> getUserByfirstnameAndlastname(String firstname, String lastname);
	
	public List<User> getUserByfirstnameOrlastname(String firstname, String lastname);

	public List<User> getUserByfirstnameContainsOrlastnameContains(String firstname, String lastname);

	public List<User> getUserByfirstnameContainsOrlastnameContainsOrderByfirstnameAsc(String firstname,
			String lastname);

	public List<User> getUserByFirstNameContainsOrLastNameContainsOrderByfirstnameDesc(String firstname,
			String lastname);

	public List<User> searchUserAnd(String firstname, String lastname);

	public List<User> searchUserOr(String firstname, String lastname);

	public List<User> searchUsersql(String firstname, String lastname);

	public List<User> getAllwithPage(int pageNumber, int pageSize);


	public List<User> findByfirstname(String firstname, int pageNumber, int pageSize);
	
}
