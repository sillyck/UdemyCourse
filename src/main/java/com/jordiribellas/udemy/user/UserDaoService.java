package com.jordiribellas.udemy.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
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
		users.add(new User(userCount++,"Claudia", LocalDate.now().minusYears(14)));
		users.add(new User(userCount++,"Hector", LocalDate.now().minusYears(22)));
		users.add(new User(userCount++,"Eloy", LocalDate.now().minusYears(22)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User getUsersById(int id){
	    for(User user : users){
	        if(user.getId() == id){
	            return user;
	        }
	    }
	    return null;
	}
	
	public User saveUser(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}
	
	public User deleteUserById(int id) {
	    Iterator<User> iterator = users.iterator();
	    while(iterator.hasNext()) {
	        User user = iterator.next();
	        if(user.getId() == id) {
	            iterator.remove();
	            return user;
	        }
	    }
	    return null;
	}
}
