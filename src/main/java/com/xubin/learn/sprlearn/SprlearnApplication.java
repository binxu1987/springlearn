package com.xubin.learn.sprlearn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@MapperScan("com.xubin.learn.sprlearn.dao")
public class SprlearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprlearnApplication.class, args);
	}

}
