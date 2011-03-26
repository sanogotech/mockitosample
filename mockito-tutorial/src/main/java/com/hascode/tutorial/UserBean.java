package com.hascode.tutorial;

import java.util.Calendar;

public interface UserBean {
	public abstract String getName();

	public abstract String setName();

	public abstract Calendar getLastLogin();

	public abstract void setLastLogin(Calendar lastLogin);

	public abstract boolean isActive();

	public abstract void setActive(boolean active);
}
