package com.xubin.learn.sprlearn.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationProvider  extends AbstractUserDetailsAuthenticationProvider{
    
	@Autowired   
	private UserDetailsService  userDetailsService;
	
	@Autowired  
	private PasswordEncoder  passwordEncoder;
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		 if(authentication.getCredentials()==null) {
			 throw new BadCredentialsException("密码不能为空");
		 }else  {
			 String password=authentication.getCredentials().toString();
			 String newPassWord=passwordEncoder.encode(password);
			 
			 if(!passwordEncoder.matches(authentication.getCredentials().toString(), userDetails.getPassword())) {
				 throw new BadCredentialsException("密码错误"+newPassWord); 
			 }
			 
			
		 }
		 
		
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		return userDetailsService.loadUserByUsername(username);
	}

}
