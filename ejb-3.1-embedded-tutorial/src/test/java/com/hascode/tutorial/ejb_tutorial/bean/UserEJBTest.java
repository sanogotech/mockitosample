package com.hascode.tutorial.ejb_tutorial.bean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserEJBTest {
	private static EJBContainer	ejbContainer;
	private static Context		ctx;

	@BeforeClass
	public static void setUp() {
		ejbContainer = EJBContainer.createEJBContainer();
		ctx = ejbContainer.getContext();
	}

	@AfterClass
	public static void tearDown() {
		ejbContainer.close();
	}

	@Test
	public void testFindAll() {
		try {
			UserEJB userEJB = (UserEJB) ctx.lookup("java:global/classes/UserEJB!com.hascode.tutorial.ejb_tutorial.bean.UserEJB");
			assertNotNull(userEJB);
			List<UserBean> users = userEJB.findAll();
			assertNotNull(users);
			assertEquals(2, users.size());
		} catch (NamingException e) {
			throw new AssertionError(e);
		}
	}
}
