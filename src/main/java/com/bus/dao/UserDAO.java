package com.bus.dao;

import com.bus.actions.User;

public interface UserDAO {
	
	public User fetchUser(String user_id);
	
	public User saveUser(User user);
}
