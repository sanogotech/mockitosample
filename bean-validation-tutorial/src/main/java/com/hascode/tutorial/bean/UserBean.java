package com.hascode.tutorial.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.hascode.tutorial.constraint.CustomerNumber;

public class UserBean {
	@NotNull
	@Size(min = 2)
	private String	firstName;

	@NotNull
	@Size(min = 2)
	private String	lastName;

	@NotNull
	@Past
	private Date	birthday;

	@NotNull
	@CustomerNumber
	private String	customerNumber;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
}
