package com.hascode.tutorial.rest.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import com.hascode.tutorial.rest.bean.CustomerBean;

public class RestClientTest {
	@Test
	public void testGetCustomer() {
		RestClient client = new RestClient();
		CustomerBean customer = client.getCustomer();
		assertNotNull(customer);
		assertTrue(123l == customer.getId());
		assertEquals("I R testuser", customer.getName());
		assertEquals("test@hascode.com", customer.getEmail());
		assertEquals("http://www.hascode.com", customer.getWebsite());
	}

	@Test
	public void testGetAllCustomers() {
		RestClient client = new RestClient();
		Collection<CustomerBean> customers = client.getAllCustomers();
		assertNotNull(customers);
		assertEquals(3, customers.size());
	}
}
