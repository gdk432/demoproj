package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	
	@Autowired
	UserService userService;
	
	@GetMapping("/searchand")
	public List<User> getUserByFirstNameAndLastName(@RequestParam String firstname,@RequestParam String lastname){
	
		return userService.getUserByfirstnameAndlastname(firstname,lastname);
	}
	
	@GetMapping("/searchor")
	public List<User> getUserByFirstNameOrLastName(@RequestParam String firstname,@RequestParam String lastname){
	
		return userService.getUserByfirstnameOrlastname(firstname,lastname);
	}
	
	@GetMapping("/searchcontains")
	public List<User> getUserByFirstNameContainsOrLastNameContains(@RequestParam String firstname,@RequestParam String lastname){
	
		return userService.getUserByfirstnameContainsOrlastnameContains(firstname,lastname);
	}
	
	@GetMapping("/searchcontainsorderasc")
	public List<User> getUserByfirstnameContainsOrlastnameContainsOrderByfirstnameAsc(@RequestParam String firstname,@RequestParam String lastname){
	
		return userService.getUserByfirstnameContainsOrlastnameContainsOrderByfirstnameAsc(firstname,lastname);
	}
	
	@GetMapping("/searchcontainsorderdsc")
	public List<User> getUserByFirstNameContainsOrLastNameContainsOrderByfirstnameDesc(@RequestParam String firstname,@RequestParam String lastname){
	
		return userService.getUserByFirstNameContainsOrLastNameContainsOrderByfirstnameDesc(firstname,lastname);
	}
	
	@GetMapping("/searcuserAnd")
	public List<User> searchUserAnd(@RequestParam String firstname,@RequestParam String lastname){
	
		return userService.searchUserAnd(firstname, lastname);
	}
	
	@GetMapping("/searcuserOr")
	public List<User> searchUserOr(@RequestParam String firstname,@RequestParam String lastname){
	
		return userService.searchUserOr(firstname, lastname);
	}
	
	@GetMapping("/searcusersql")
	public List<User> searchUsersql(@RequestParam String firstname,@RequestParam String lastname){
	
		return userService.searchUsersql(firstname, lastname);
	}
	
	@PostMapping("")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping("")
	public List<User> getAll(){
		return userService.getAll();
	}
	
	@GetMapping("/pages")
	public List<User> getAllwithPage(@RequestParam int pageNumber, @RequestParam int pageSize){
		return userService.getAllwithPage(pageNumber, pageSize);
	}
	
	@GetMapping("/pagesfirstname")
	public List<User> getAllwithPage(@RequestParam String firstname, @RequestParam int pageNumber, @RequestParam int pageSize){
		return userService.findByfirstname(firstname, pageNumber, pageSize);
	}
	
	
	@GetMapping("/{userid}")
	public User getById(@PathVariable int userid) {
		return userService.getById(userid);
	}
	
	@DeleteMapping("/{userid}")
	public String DeleteById(@PathVariable int userid) {
		 userService.deleteById(userid);
		 return "sucess";
	}
	
	
	
}
