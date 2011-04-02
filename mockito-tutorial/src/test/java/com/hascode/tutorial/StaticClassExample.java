package com.hascode.tutorial;

import static org.mockito.Mockito.when;
import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class) @PrepareForTest(Math.class) public class StaticClassExample {

	@Test public void testMockStatic() {
		PowerMockito.mockStatic(Math.class);
		when(Math.max(1, 5)).thenReturn(1); // this is soo wrong ;)
		Assert.assertEquals(1, Math.max(1, 5));
	}
}
