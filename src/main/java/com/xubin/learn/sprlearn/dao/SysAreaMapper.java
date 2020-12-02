package com.xubin.learn.sprlearn.dao;

import com.xubin.learn.sprlearn.entity.SysArea;
import com.xubin.learn.sprlearn.entity.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SysAreaMapper {

    @Select("select * from sys_area")
    List<SysArea> getAll();
}
