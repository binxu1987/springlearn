package com.xubin.learn.sprlearn.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.stereotype.Component;


@Component
public interface MyPersistentRememberMeTokenMapper {
	
     @Insert("insert into remember_token_info (username, series, token, last_used) values(#{token.username},#{token.series},#{token.tokenValue},#{token.date})")
    void createNewToken(@Param("token")PersistentRememberMeToken token);
     
     @Update("update remember_token_info set token = #{tokenValue}, last_used = #{lastUsed} where series = #{series}")
	void updateToken(@Param("series")String series, @Param("tokenValue")String tokenValue, @Param("lastUsed")Date lastUsed);
     
     @Select("select username,series,token,last_used from remember_token_info where series = #{seriesId}")
	PersistentRememberMeToken getTokenForSeries(@Param("seriesId")String seriesId);
     
     @Delete("delete from remember_token_info where username =  #{username}")
	void removeUserTokens(@Param("username")String username);
}
