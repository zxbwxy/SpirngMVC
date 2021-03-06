package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/","home").access("hasRole('ROLE_ADMIN')").anyRequest().permitAll()
		.and().formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password")
		.and().logout().logoutSuccessUrl("/login?logout")
		.and().exceptionHandling().accessDeniedPage("/403")
		.and().csrf();
	}
	
	@Autowired
	public void configurateAutehtication(AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication().dataSource(this.dataSource).usersByUsernameQuery(
				"select username, password, enabled from users where username=?")
		.authoritiesByUsernameQuery(
				"select username, role from users where username=?");

		
	}

}
