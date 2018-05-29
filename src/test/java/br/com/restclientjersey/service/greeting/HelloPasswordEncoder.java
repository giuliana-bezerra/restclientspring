package br.com.restclientjersey.service.greeting;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Encoder default for credentials in header's requests.
 * 
 * @author giuliana.bezerra
 *
 */
public class HelloPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return rawPassword.toString().equals(encodedPassword);
	}

}
