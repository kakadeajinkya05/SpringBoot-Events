package com.example.SpringBootEvents;

import org.junit.After;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.SpringBootEvents.service.CounterObserverJob;

public class CounterServiceTest {

	private AnnotationConfigApplicationContext ctx;


	@After
	public void tearDown() {
		if (ctx != null) {
			ctx.close();
		}
	}
	
	@Test
	public void withInitiallyDelayedFixedRateTask() throws InterruptedException {
		ctx = new AnnotationConfigApplicationContext(CounterObserverJob.class);
	}
	
}
