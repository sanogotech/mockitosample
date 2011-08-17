package com.hascode.tutorial.jee;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Stateless
public class UserEJB {
	private final Logger logger = Logger.getLogger("com.hascode.tutorial.jee");

	@Interceptors(ProtocolInterceptor.class)
	public void createUser(final User user) {
		logger.log(Level.INFO, "creating a new user with name {0} in UserEJB",
				user.getName());
		// persist
	}

	public Set<User> findBookByTitle(final String name) {
		logger.log(Level.INFO, "searching user with given name {0} in UserEJB",
				name);
		// find
		return new HashSet<User>();
	}
}
