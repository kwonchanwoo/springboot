package com.example.controller;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.controller.SpringbootApplication;

@SpringBootApplication


@MapperScan(basePackages = {"com.example.service","com.example.dao"})
public class SpringbootApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
