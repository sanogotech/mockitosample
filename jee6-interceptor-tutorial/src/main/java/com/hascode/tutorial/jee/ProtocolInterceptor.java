package com.hascode.tutorial.jee;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class ProtocolInterceptor {
	private final Logger logger = Logger.getLogger("com.hascode.tutorial.jee");

	@AroundInvoke
	private Object logMethodExecution(final InvocationContext ic)
			throws Exception {
		logger.log(Level.INFO,
				"protocol interceptor invoked on target {0} and method {1}",
				new Object[] { ic.getTarget().toString(),
						ic.getMethod().getName() });
		try {
			return ic.proceed();
		} finally {
		}
	}
}
