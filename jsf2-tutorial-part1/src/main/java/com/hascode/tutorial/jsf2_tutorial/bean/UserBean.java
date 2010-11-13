package com.hascode.tutorial.jsf2_tutorial.bean;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
@SessionScoped
public class UserBean {
	protected String nickname;
	protected String email;
	protected Date birthday;

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname
	 *            the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * stupid simple email validation
	 * 
	 * @param context
	 * @param validated
	 * @param value
	 */
	public void validateEmail(FacesContext context, UIComponent validated,
			Object value) {
		// simple stupid validation
		String mail = (String) value;
		if (!mail.matches(".+\\@.+\\..+")) {
			FacesMessage msg = new FacesMessage("This is not an e-mail!");
			throw new ValidatorException(msg);
		}
	}
}