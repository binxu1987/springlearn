package com.xubin.learn.sprlearn.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.xubin.learn.sprlearn.entity.Users;

@Component
public interface UsersMapper {
	
    @Select("select * from users where username=#{username}")
	Users findByUserName(@Param("username")String username);
}
