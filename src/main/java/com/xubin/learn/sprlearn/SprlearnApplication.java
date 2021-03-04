package com.xubin.learn.sprlearn;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xubin.learn.sprlearn.dao")
@NacosPropertySource(dataId = "myConfig",autoRefreshed = true)
public class SprlearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprlearnApplication.class, args);
	}

}
