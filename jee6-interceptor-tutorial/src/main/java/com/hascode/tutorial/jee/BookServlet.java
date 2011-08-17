package com.hascode.tutorial.jee;

import java.io.IOException;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="bookServlet", urlPatterns="/printBookInformation")
public class BookServlet extends HttpServlet {
	
	@EJB
	private BookEJB bookEJB;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Book book = new Book();
		book.setTitle("The joy of interceptors v.1");
		bookEJB.createBook(book);
		bookEJB.findBookByTitle("test");
		res.getWriter().append("Watch your logs..");
		
	}

}
