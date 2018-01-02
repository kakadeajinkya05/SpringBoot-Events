package com.SpringBootEvents.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.SpringBootEvents.domain.Counter;

@Service
public class CounterObserverJob {

	@Value("${data.count:1}")
	Integer count;
	
	public final ApplicationEventPublisher eventPublisher;

	public CounterObserverJob(ApplicationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}

	@Scheduled(fixedDelayString = "${data.delay}",initialDelay = 10000)
	public void publishCounterEvent() {
		Counter counter = new Counter(count++, new Date().toString());
		this.eventPublisher.publishEvent(counter);
	}
}