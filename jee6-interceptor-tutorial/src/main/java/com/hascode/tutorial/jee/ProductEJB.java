package com.hascode.tutorial.jee;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;

@Stateless
@Interceptors({ Interceptor1.class, Interceptor3.class })
public class ProductEJB {
	private final Logger logger = Logger.getLogger("com.hascode.tutorial.jee");

	@Interceptors({ Interceptor2.class, Interceptor4.class })
	public void createProduct(final Product product) {
		logger.log(Level.INFO,
				"creating a new product with name {0} in ProductEJB",
				product.getName());
		// persist
	}

	@ExcludeClassInterceptors
	@Interceptors(Interceptor2.class)
	public Set<Product> findProductByName(final String name) {
		logger.log(Level.INFO,
				"searching product with given name {0} in ProductEJB", name);
		// find
		return new HashSet<Product>();
	}
}
