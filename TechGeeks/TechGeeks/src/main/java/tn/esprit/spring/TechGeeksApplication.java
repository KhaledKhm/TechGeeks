package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableScheduling
@EnableSwagger2
@EnableAspectJAutoProxy
@SpringBootApplication
public class TechGeeksApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TechGeeksApplication.class, args);
		
	    
	}
	
}
