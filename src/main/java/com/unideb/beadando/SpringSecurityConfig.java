package com.unideb.beadando;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * SpringSecurityConfig for this project.
 * @author gagyi.norbert
 *
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * accesDeniedHandler is injected.
	 */
	@Autowired
	private AccessDeniedHandler accessDeniedHandler;
	
	/**
	 * this is an user-query which is located in application.properties.
	 */
	@Value("${spring.queries.users-query}")
	private String usersQuery;
	
	/**
	 * this is an queries role which is located in application.properties.
	 */
	@Value("${spring.queries.roles-query}")
	private String rolesQuery;

	/**
	 * this is injected datasource.
	 */
	@Autowired
	private DataSource dataSource;
	
	/**
	 * BCryptPasswordEncoder is injected.
	 */
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests().antMatchers("/**").permitAll()
				.antMatchers("/user**")
				.hasAnyRole("USER").anyRequest()
				.authenticated().and().formLogin().loginPage("/log-in").permitAll().and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/log-out"))
				.logoutSuccessUrl("/").and()
				.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
	}

	/**
	 * this function provide authentication for users.
	 * @param auth this is the AuthenticationManagerBuilder.
	 * @throws Exception is Exception.
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().usersByUsernameQuery(usersQuery).authoritiesByUsernameQuery(rolesQuery).dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder);	
	}
	
}
