package com.adictos.tutorial.architecture.context;

import com.adictos.tutorial.architecture.context.holder.ContextHolder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

class ServiceLocatorTest {

	@Test
	void locate_whenInvoked_shouldCallApplicationContext() {
		ContextHolder holder = Mockito.mock(ContextHolder.class);
		ServiceLocator.setContextHolder(holder);
		ServiceLocator.locate(Object.class);
		verify(holder).locate(Object.class);
	}
}
