package com.jordiribellas.udemy.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	// JPA/Hibernate > Database
	// UserDaoService > Static List
	
	private static List<User> users = new ArrayList<>();
	private static int userCount = 0;
	
	static {
		users.add(new User(userCount++,"Jordi", LocalDate.now().minusYears(22)));
		users.add(new User(userCount++,"Claudia", LocalDate.now().minusYears(13)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User getUsersById(int id){
		return users.get(id);
	}
	
	public User saveUser(User user) {
		user.setId(userCount++);
		users.add(user);
		return user;
	}
}
