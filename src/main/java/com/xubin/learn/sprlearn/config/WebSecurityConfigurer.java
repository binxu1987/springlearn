package com.xubin.learn.sprlearn.config;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.xubin.learn.sprlearn.dao.MyAuthenticationProvider;
import com.xubin.learn.sprlearn.service.MyUserDetailsService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private MyUserDetailsService  myUserDetailsService;
	
	@Autowired
	private MyAuthenticationProvider  myAuthenticationProvider;
	
	@Autowired
	private PersistentTokenRepository  myPersistentTokenRepository;
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
		                                     .antMatchers("/user/**").hasRole("USER").anyRequest().authenticated()
		                                     .and().formLogin().loginPage("/sprlearnLogin.html")
				.loginProcessingUrl("/login").successHandler(new AuthenticationSuccessHandler() {
					
					@Override
					public void onAuthenticationSuccess(HttpServletRequest arg0, HttpServletResponse arg1, Authentication arg2)
							throws IOException, ServletException {
						System.out.println("success"+arg2);
						
						
					}
				}).failureHandler(new AuthenticationFailureHandler() {
					
					@Override
					public void onAuthenticationFailure(HttpServletRequest arg0, HttpServletResponse arg1, AuthenticationException arg2)
							throws IOException, ServletException {
						System.out.println("fails"+arg2+"=====");
						
					}
				}).permitAll().and().rememberMe().userDetailsService(myUserDetailsService).key("xubin").tokenRepository(myPersistentTokenRepository)
				.and().csrf().disable().logout().logoutUrl("/logout").logoutSuccessUrl("/sprlearnLogin.html").invalidateHttpSession(true)
				.and().sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(true);
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(myAuthenticationProvider);
	    
	    
//		super.configure(auth);
	}
	
  
  public  @Bean HttpSessionEventPublisher HttpSessionEventPublisher() {
	   System.out.println("是否注入");
	  return new HttpSessionEventPublisher();
  }
  
  public @Bean PasswordEncoder  passwordEncoder() {
	  System.out.println("密码加密是否注入");
	  return new BCryptPasswordEncoder(12);
  }
  //CORS配置源
  @Bean  CorsConfigurationSource  corsConfigurationSource() {
	  CorsConfiguration configuration=new CorsConfiguration();
	  configuration.setAllowedOrigins(Arrays.asList("http://www.baidu.com"));
	  configuration.setAllowedMethods(Arrays.asList("GET","POST"));
	  configuration.setAllowCredentials(true);
	  UrlBasedCorsConfigurationSource  source=new UrlBasedCorsConfigurationSource();
	  source.registerCorsConfiguration("/**", configuration);
	  return source;
  }
  

}
