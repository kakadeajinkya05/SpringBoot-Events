package com.SpringBootEvents.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.SpringBootEvents.domain.Counter;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class SSEController {

	private final CopyOnWriteArrayList<SseEmitter> emitters = new CopyOnWriteArrayList<>();

	@GetMapping("/api/count")
	public SseEmitter Counter() {

		SseEmitter emitter = new SseEmitter();
		this.emitters.add(emitter);

		emitter.onCompletion(() -> this.emitters.remove(emitter));
		emitter.onTimeout(() -> this.emitters.remove(emitter));

		return emitter;
	}

	@EventListener
	public void counterEventListner(Counter counter) {

		List<SseEmitter> deadEmitters = new ArrayList<>();
		this.emitters.forEach(emitter -> {
			try {
				emitter.send(counter);
			} catch (Exception e) {
				log.debug(e.getMessage());
				deadEmitters.add(emitter);
			}
		});

		this.emitters.removeAll(deadEmitters);
	}
}