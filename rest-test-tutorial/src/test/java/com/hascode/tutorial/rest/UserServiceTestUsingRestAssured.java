package com.hascode.tutorial.rest;

import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

import org.junit.Test;

public class UserServiceTestUsingRestAssured {
	@Test
	public void testUserFetchesSuccess() {
		expect().body("id", equalTo("12")).body("firstName", equalTo("Tim"))
				.body("lastName", equalTo("Tester"))
				.body("birthday", equalTo("1970-01-16T07:56:49.871+01:00"))
				.when().get("/rest-test-tutorial/user/id/12");
	}

	@Test
	public void testUserNotFound() {
		expect().body(nullValue()).when()
				.get("/rest-test-tutorial/user/id/666");
	}
}
