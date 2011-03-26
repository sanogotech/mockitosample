package com.hascode.tutorial;

import static org.mockito.Mockito.mock;

import org.junit.Test;
public class SimpleMockExample {
	@Test public void testSomething() {
		UserRepository userRepository = mock(UserRepository.class);
	}
}
