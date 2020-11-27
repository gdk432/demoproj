package com.example.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public List<User> findByfirstnameContains(@Param("firstname") String firstname, Pageable pageRequest);
	
	public List<User> findByfirstnameAndLastname(@Param("firstname") String firstname, @Param("lastname") String lastname);
	public List<User> findByfirstnameOrLastname(@Param("firstname") String firstname, @Param("lastname") String lastname);
	public List<User> findByfirstnameContainsOrLastnameContains(@Param("firstname") String firstname, @Param("lastname") String lastname);
	public List<User> findByfirstnameContainsOrLastnameContainsOrderByFirstnameAsc(@Param("firstname") String firstname, @Param("lastname") String lastname);
	public List<User> findByfirstnameContainsOrLastnameContainsOrderByFirstnameDesc(@Param("firstname") String firstname, @Param("lastname") String lastname);
	
	@Query("From User u where u.firstname =:firstname and u.lastname =:lastname")
	public List<User> searchUserAnd(String firstname, String lastname);
	
	@Query("From User u where u.firstname =:firstname or u.lastname =:lastname")
	public List<User> searchUserOr(String firstname, String lastname);
	
	@Query(value ="select u.* from user u where u.firstname=:firstname and u.lastname=:lastname",nativeQuery = true)
	public List<User> searchUsersql(String firstname, String lastname);
}
