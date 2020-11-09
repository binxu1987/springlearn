package com.xubin.learn.sprlearn.service;

import java.util.Date;

import com.xubin.learn.sprlearn.dao.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Service;

import com.xubin.learn.sprlearn.dao.MyPersistentRememberMeTokenMapper;

@Service
public class MyPersistentTokenReposityService   implements  PersistentTokenRepository {
	
	@Autowired
	private  MyPersistentRememberMeTokenMapper  myPersistentRememberMeTokenMapper;


	 
	

	@Override
	public void createNewToken(PersistentRememberMeToken token) {
		 
		myPersistentRememberMeTokenMapper.createNewToken(token);
		
	}

	@Override
	public void updateToken(String series, String tokenValue, Date lastUsed) {
		
		myPersistentRememberMeTokenMapper.updateToken(series,  tokenValue,  lastUsed);
	}

	@Override
	public PersistentRememberMeToken getTokenForSeries(String seriesId) {
		
		return myPersistentRememberMeTokenMapper.getTokenForSeries(seriesId);
	}

	@Override
	public void removeUserTokens(String username) {
		
		myPersistentRememberMeTokenMapper.removeUserTokens(username);
	}

}
