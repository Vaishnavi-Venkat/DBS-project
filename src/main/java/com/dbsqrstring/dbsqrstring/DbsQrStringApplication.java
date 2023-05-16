package com.dbsqrstring.dbsqrstring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@ComponentScan
@SpringBootApplication
@EnableScheduling
public class DbsQrStringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbsQrStringApplication.class, args);
	}



}
