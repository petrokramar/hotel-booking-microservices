package com.hotelbooking.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String[] AUTH_WHITELIST = {
			"/login",
			// -- swagger ui
			"/v2/api-docs",
//			"/swagger-resources",
			"/swagger-resources/**",
//			"/configuration/ui",
//			"/configuration/security",
			"/swagger-ui.html",
			"/webjars/**",
			"/registration",
			"/activate/**"
			// other public endpoints of your API may be appended to this array
	};

	@Autowired
	private CorsFilter corsFilter;

	public WebSecurityConfig() {
		super(true);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(AUTH_WHITELIST);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests().antMatchers("/authserver/h2-console/").permitAll()
				.and().antMatcher("/authserver/**")
				.authorizeRequests().anyRequest().authenticated()
				.and().addFilterBefore(corsFilter, ChannelProcessingFilter.class);
		http.headers().frameOptions().disable();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}