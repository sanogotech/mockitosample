package com.hascode.tutorial.jee;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "userServlet", urlPatterns = "/printUserInformation")
public class UserServlet extends HttpServlet {

	@EJB
	private UserEJB userEJB;

	@Override
	protected void doGet(final HttpServletRequest req,
			final HttpServletResponse res) throws ServletException, IOException {
		User user = new User();
		user.setName("Alfred E. Neumann");
		userEJB.createUser(user);
		userEJB.findBookByTitle("Charles Bukowski");
		res.getWriter().append("Watch your logs..");
	}

}
