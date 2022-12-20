package net.fishinapi.springboot.service;

import java.util.ArrayList;
import java.util.List;

import net.fishinapi.springboot.model.User;

public class UserService {
	static List<User> users;
	
	static {
		users= new ArrayList<User>();
		users.add(new User("Bob","pwBob"));
		users.add(new User("Marcel","pwMarcel"));
		users.add(new User("Antoine","pwAntoine"));
	}
	
	public List<User> getAllUsers(){
		return users;
	}
}
