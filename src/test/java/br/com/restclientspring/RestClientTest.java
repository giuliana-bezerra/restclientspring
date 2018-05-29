package br.com.restclientspring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.restclientspring.Request;
import br.com.restclientspring.RestClient;
import br.com.restclientspring.service.greeting.Application;
import br.com.restclientspring.service.greeting.Greeting;

/**
 * Test class responsible for setting up a service and test the client to it.
 * 
 * @author giuliana.bezerra
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Request.class, RestClient.class })
public class RestClientTest {
	@Autowired
	private Request request;

	@Autowired
	private RestClient<Greeting> restClient;

	@BeforeClass
	public static void beforeClass() throws IOException {
		Application.main(new String[] {});
	}

	@AfterClass
	public static void afterClass() {
		Application.shutDown();
	}

	@Before
	public void setUp() {
		request.setServerURL("http://localhost:8080/");
		request.setResourcePath("greeting");
	}

	@Test
	public void testGetCallStatusWithoutParametersReturning200() {
		try {
			ResponseEntity<Greeting> response = restClient.getCall(request, new Greeting());
			assertEquals(200, response.getStatusCode().value());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testGetCallStatusWithoutParametersReturningObject() {
		try {
			ResponseEntity<Greeting> response = restClient.getCall(request, new Greeting());
			assertEquals(200, response.getStatusCode().value());
			assertEquals("Hello, World!", response.getBody().getContent());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testBasicAuthentication() {
		try {
			ResponseEntity<Greeting> response = restClient.getCall(request, new Greeting());
			assertEquals(200, response.getStatusCode().value());
			assertEquals("Hello, World!", response.getBody().getContent());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testPostCallStatus200() {
		try {
			ResponseEntity<Greeting> response = restClient.postCall(request, new Greeting(-1, "It works!"));
			assertEquals(200, response.getStatusCode().value());
			assertEquals("It works!", response.getBody().getContent());
			response = restClient.getCall(request, new Greeting());
			assertEquals(200, response.getStatusCode().value());
			assertEquals("It works!", response.getBody().getContent());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}