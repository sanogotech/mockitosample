package com.hascode.tutorial.rest.service;

import java.util.Collection;

import com.hascode.tutorial.rest.bean.CustomerBean;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

public class RestClient {
	public CustomerBean getCustomer() {
		Client client = new Client();

		WebResource webResource = client.resource("http://localhost/customer.xml");
		return webResource.get(CustomerBean.class);
	}

	public Collection<CustomerBean> getAllCustomers() {
		GenericType<Collection<CustomerBean>> customerType = new GenericType<Collection<CustomerBean>>() {
		};

		Client client = new Client();

		WebResource webResource = client.resource("http://localhost/customers.xml");
		return webResource.get(customerType);
	}
}
