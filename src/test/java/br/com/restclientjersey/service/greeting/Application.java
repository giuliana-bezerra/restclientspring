package br.com.restclientjersey.service.greeting;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Main class that configures a service for tests.
 * 
 * @author giuliana.bezerra
 *
 */
@SpringBootApplication
public class Application {
	private static ConfigurableApplicationContext ctx;

	public static void main(String[] args) throws IOException {
		ctx = SpringApplication.run(Application.class, args);
	}

	public static void shutDown() {
		ctx.close();
	}
}