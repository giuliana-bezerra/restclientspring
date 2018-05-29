package br.com.restclientspring;

import java.io.IOException;
import java.util.Base64;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.client.RestTemplate;

/**
 * It implements a rest client for accessing a service resource using Spring.
 * 
 * @author giuliana.bezerra
 */
@SuppressWarnings("unchecked")
public class RestClient<T> {

	public ResponseEntity<T> getCall(Request request, T resource) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<T> entity = new HttpEntity<>(createHeaders());
		return (ResponseEntity<T>) restTemplate.exchange(request.getURL(), HttpMethod.GET, entity, resource.getClass());
	}

	public ResponseEntity<T> postCall(Request request, T resource) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<T> entity = new HttpEntity<>(resource, csrfHeaders());
		return (ResponseEntity<T>) restTemplate.exchange(request.getURL(), HttpMethod.POST, entity,
				resource.getClass());
	}

	public HttpHeaders createHeaders() throws IOException {
		HttpHeaders httpHeaders = new HttpHeaders();
		String auth = ConfigurationIO.getInstance().getUser() + ":" + ConfigurationIO.getInstance().getPassword();
		byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes());
		String authHeader = "Basic " + new String(encodedAuth);
		httpHeaders.set("Authorization", authHeader);
		return httpHeaders;
	}

	public HttpHeaders csrfHeaders() throws IOException {
		CsrfToken csrfToken = CookieCsrfTokenRepository.withHttpOnlyFalse().generateToken(null);
		HttpHeaders headers = createHeaders();
		headers.add(csrfToken.getHeaderName(), csrfToken.getToken());
		headers.add("Cookie", "XSRF-TOKEN=" + csrfToken.getToken());
		return headers;
	}
}