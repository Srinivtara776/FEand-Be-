package com.digitalbooks.books;

//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication

@ComponentScan(basePackages= {"com.digitalbooks.books"})
@EnableJpaRepositories("com.digitalbooks.books.repositories")
//public class BooksApplication implements CommandLineRunner {
	

public class BooksApplication extends SpringBootServletInitializer{

public static void main(String[] args) {
    SpringApplication.run(BooksApplication.class, args);
}

@Override
protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(BooksApplication.class);
}

	
//	public static void main(String[] args) {
//		SpringApplication.run(BooksApplication.class, args);
//		
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}



}
