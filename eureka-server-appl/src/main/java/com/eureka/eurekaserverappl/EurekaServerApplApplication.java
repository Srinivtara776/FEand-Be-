package com.eureka.eurekaserverappl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplApplication.class, args);
	}

}
