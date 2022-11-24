package kr.kwangan2.springbootsecurity.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import kr.kwangan2.springbootsecurity.service.impl.BoardUserDetailServiceImpl;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

//	@Autowired
//	private DataSource dateSource;
	
	@Autowired
	private BoardUserDetailServiceImpl boardUserDetailService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity security) throws Exception {
		security.authorizeHttpRequests().antMatchers("/").permitAll();
		security.authorizeHttpRequests().antMatchers("/member").authenticated();
		security.authorizeHttpRequests().antMatchers("/manager").hasRole("MANAGER");
		security.authorizeHttpRequests().antMatchers("/admin").hasRole("ADMIN");
		
		security.csrf().disable();
		
		security.formLogin().loginPage("/login").defaultSuccessUrl("/loginSuccess",true);
		
		security.exceptionHandling().accessDeniedPage("/accessDenied");
		
		security.logout().invalidateHttpSession(true).logoutSuccessUrl("/login");
		
		security.userDetailsService(boardUserDetailService);
	}
	
//	@Autowired
//	public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
//		String query1 = " select id username, concat('{noop}', password) password, 'y' enabled "
//				+ "from member where id=? ";
//		String query2 = " select id, role from member where id=? ";
//		
//		auth.jdbcAuthentication().dataSource(dateSource)
//		.usersByUsernameQuery(query1).authoritiesByUsernameQuery(query2);
//	}
	
}
