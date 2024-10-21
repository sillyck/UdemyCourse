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
	
	static {
		users.add(new User(1,"Jordi", LocalDate.now().minusYears(22)));
		users.add(new User(2,"Claudia", LocalDate.now().minusYears(13)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	//public User save(User user) {
	//public User findeOne (int id){
}
