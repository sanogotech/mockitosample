package com.hascode.tutorial;

import java.util.List;

public interface UserRepository {
	public abstract List<UserBean> findAll();

	public abstract void save(final UserBean user);

	public abstract void remove(final UserBean user);
}
