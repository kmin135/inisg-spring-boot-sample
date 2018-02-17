package inisg.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http.csrf().disable()
			.authorizeRequests().anyRequest().permitAll();*/
		
		http.csrf().disable()
			.authorizeRequests()
				.antMatchers("/api/**").hasAnyRole("APIUSER")
				.anyRequest().permitAll()
			.and()
			.formLogin()
				.permitAll()
			.and()
			.logout()
				.logoutUrl("/logout")
				.permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("hsu.kwon").password("inisg2018").roles("APIUSER");
	}
	
}
