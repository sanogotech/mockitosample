package com.hascode.tutorial.jee;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "productServlet", urlPatterns = "/printProductInformation")
public class ProductServlet extends HttpServlet {

	@EJB
	private ProductEJB productEJB;

	@Override
	protected void doGet(final HttpServletRequest req,
			final HttpServletResponse res) throws ServletException, IOException {
		Product product = new Product();
		product.setName("Extra strong coffee");
		productEJB.createProduct(product);
		productEJB.findProductByName("sugar");
		res.getWriter().append("Watch your logs..");
	}

}
