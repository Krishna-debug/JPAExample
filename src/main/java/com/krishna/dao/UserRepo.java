package com.krishna.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.krishna.entities.User;

public interface UserRepo extends CrudRepository<User, Integer> {

	public List<User> findByName(String name);

	public List<User> findByNameAndCity(String name, String City);

	// Executing JPQL
	@Query("select u from User u")
	public List<User> getAllUser();

	// ParaMeterized Query
	@Query("select u From User u WHERE u.name =:n")
	public List<User> getUserByName(@Param("n") String name);

	@Query("select u From User u WHERE u.name =:n and u.city =:c ")
	public List<User> getUserByName(@Param("n") String name, @Param("c") String city);

	// Executing Native Query
	@Query(value = "select * from user", nativeQuery = true)
	public List<User> getUsers();

}
