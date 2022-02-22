package tum.seba.mobilityservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

@Configuration
public class SebaMobilityServicesApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	protected void configure(HttpSecurity http) throws Exception {
		http
	    	.authorizeRequests()
			.anyRequest().authenticated().and()   
			.httpBasic().and()
			.sessionManagement()
		    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Bean
	public Argon2PasswordEncoder argon2PasswordEncoder() {
	    return new Argon2PasswordEncoder();
	}
	
}
