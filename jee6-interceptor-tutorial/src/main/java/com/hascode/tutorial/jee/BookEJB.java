package com.hascode.tutorial.jee;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

@Stateless
public class BookEJB {
	private final Logger logger = Logger.getLogger("com.hascode.tutorial.jee");

	public void createBook(final Book book) {
		logger.log(Level.INFO, "creating a new book with title {0} in BookEJB",
				book.getTitle());
		// persist
	}

	public Set<Book> findBookByTitle(final String title) {
		logger.log(Level.INFO,
				"searching book with given title {0} in BookEJB", title);
		// find
		return new HashSet<Book>();
	}

	@AroundInvoke
	private Object logMethodExecution(final InvocationContext ic)
			throws Exception {
		logger.log(Level.INFO,
				"interceptor invoked on target {0} and method {1}",
				new Object[] { ic.getTarget().toString(),
						ic.getMethod().getName() });
		try {
			return ic.proceed();
		} finally {
		}
	}
}
