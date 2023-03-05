package com.application.auth;

import java.util.ArrayList;
import java.util.List;

public class Action {
	List<User> data;
	protected boolean saveUser(User user) {
		return false;
		
	}
	protected User getUserById(Integer id) {
		return null;
	}
	protected User getUserByUsernamePassword() {
		return null;
	}
	protected List<User> getAllusers(){
		return null;
	}
 protected boolean verify(String username ,String password) {
	 
	 return (username.equals("user") && password.equals("12345"))?true:false;
}
 static public String key() {
	 return "1234";
 }
}
