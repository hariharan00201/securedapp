package com.sma.app;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;




@SpringBootApplication
//@ComponentScan({"com.sma.app.controller","com.sma.app.service","com.sma.app.entity"})
public class SecuredmsgwebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuredmsgwebappApplication.class, args);
	}

}
