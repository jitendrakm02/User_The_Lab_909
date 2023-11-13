package com.thelab909.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//(exclude = {DataSourceAutoConfiguration.class })
public class UserTheLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserTheLabApplication.class, args);
	}

}
