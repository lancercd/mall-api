package com.mall.all;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.mall"})
@MapperScan("com.mall.db.dao")
public class AllApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllApplication.class, args);
	}

}
