package br.com.restclientspring.service.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * It implements the security access protocol for application services.
 * 
 * @author giuliana.bezerra
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
				.authorizeRequests().antMatchers("/css/**", "/index").permitAll().antMatchers("/auth/**")
				.hasRole("USER");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(new HelloPasswordEncoder()).withUser("user").password("password")
				.roles("USER");
	}
}
