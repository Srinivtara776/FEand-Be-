package com.DigitalAuthor.author;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages= {"com.DigitalAuthor.author"})
@EnableJpaRepositories("com.DigitalAuthor.author.repositories")
@EnableFeignClients
public class AuthorApplication implements CommandLineRunner  {

	
	public static void main(String[] args) {
		SpringApplication.run(AuthorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
}
