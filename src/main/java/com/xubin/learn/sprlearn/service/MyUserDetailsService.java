package com.xubin.learn.sprlearn.service;

import java.util.ArrayList;
import java.util.List;

import com.xubin.learn.sprlearn.dao.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xubin.learn.sprlearn.dao.UsersMapper;
import com.xubin.learn.sprlearn.entity.Users;
@Service
public class MyUserDetailsService  implements  UserDetailsService{

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private UsersMapper  usersMapper;
	
	@Cacheable(cacheNames="xubin")
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user=this.getUserByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("用户名不存在");
		}
		user.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles()));
		
		return user;
	}
	
	private List<GrantedAuthority> generateAuthorities(String roles){
		 List<GrantedAuthority>  	 authorities=new ArrayList<GrantedAuthority>();
		  if(roles!=null&&!"".equals(roles)) {
			  String[] roleArr=roles.split(";");
			  for(String role:roleArr) {
				  authorities.add(new SimpleGrantedAuthority(role));
			  }
		  }
		  return authorities;
	}
	private Users getUserByUsername(String username) {
		return  usersMapper.findByUserName(username);
	}

}
