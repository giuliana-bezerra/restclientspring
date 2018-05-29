package br.com.restclientspring.service.greeting;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Service which returns an object of type {@link Greeting}.
 * 
 * @author giuliana.bezerra
 *
 */
@RestController
@RequestMapping(value = "/greeting")
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private Greeting greeting;

	@GetMapping
	public Greeting get(@RequestParam(value = "name", defaultValue = "World") String name) {
		if (greeting == null)
			return new Greeting(counter.incrementAndGet(), String.format(template, name));
		return greeting;
	}

	@PostMapping
	public Greeting add(@RequestBody Greeting greeting) {
		this.greeting = greeting;
		return greeting;
	}
}
