package com.krishna;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.krishna.dao.UserRepo;
import com.krishna.entities.User;

@SpringBootApplication
public class JpaExampleApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(JpaExampleApplication.class, args);

		UserRepo repo = context.getBean(UserRepo.class);

		// Create Object for User
		User user1 = new User();
		user1.setName("Krishna");
		user1.setCity("Mathura");
		user1.setStatus("Single");

		User user2 = new User();
		user2.setName("Ram");
		user2.setCity("Gurugram");
		user2.setStatus("Single");

		// Saving Single User
//		User result = repo.save(user1);
//		System.out.println(result);

		// List.of above java 9 static method
		// Saving Multiple Users
		List<User> list = List.of(user1, user2);

		// Save Multiple Objects
		Iterable<User> results = repo.saveAll(list);//
		results.forEach(user -> {
			System.out.println(user);
		});

		// Update the user for perticular id
//		Optional<User> optional = repo.findById(9);
//		User user = optional.get();
//		user.setName("Radha Krishna");
//		User updateUser = repo.save(user);
//		System.out.println(updateUser);

		// How to get data
		// FindById(id) - return optional containing data
		// Method 1
		Iterable<User> itr = repo.findAll();
		itr.forEach(userById -> {
			System.out.println(itr);
		});

		// Method 2
//		Iterator<User> it = itr.iterator();
//		while(it.hasNext()) {
//			User user = it.next();
//			System.out.println(user);
//		}
//
//		// Deleting the single user
//		repo.deleteById(9);
//		System.out.println("Deleted");
//
//		// Delete by collection
//		Iterable<User> allusers = repo.findAll();
//		allusers.forEach(users -> System.out.println(user));
//		repo.deleteAll(allusers);
//
//		// Custom Finder Methods
//		// Derived Query Methods
//		// Method 1
////		List<User> users = repo.findByName("Ram");	
//		List<User> users = repo.findByNameAndCity("Ram", "Gurugram");
//		users.forEach(e -> System.out.println(e));
//
//		// Method 2
////		List<User> allUsers = repo.getAllUser();
//		List<User> allUsers = repo.getUserByName("Ram", "Gurugram");
//		allUsers.forEach(e -> {
//			System.out.println(e);
//		});
//
//		// Method 3
//		repo.getUsers().forEach(e -> System.out.println(e));
	}

}
