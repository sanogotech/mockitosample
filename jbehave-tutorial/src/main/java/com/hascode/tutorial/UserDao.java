package com.hascode.tutorial;

import java.util.HashSet;
import java.util.Set;

public class UserDao {
	private final Set<User>	users	= new HashSet<User>();

	public void save(final User user) {
		users.add(user);
	}

	public Set<User> findAll() {
		return users;
	}
}
