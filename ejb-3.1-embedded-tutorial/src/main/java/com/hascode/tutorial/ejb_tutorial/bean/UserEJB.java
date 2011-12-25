package com.hascode.tutorial.ejb_tutorial.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class UserEJB {
	public List<UserBean> findAll() {
		List<UserBean> users = new ArrayList<UserBean>();
		UserBean user = new UserBean();
		user.setFirstName("Alfred");
		user.setLastName("Newman");
		user.setId(1l);

		UserBean anotherUser = new UserBean();
		anotherUser.setFirstName("Albert");
		anotherUser.setLastName("Einstein");
		anotherUser.setId(2l);

		users.add(user);
		users.add(anotherUser);
		return users;
	}
}
