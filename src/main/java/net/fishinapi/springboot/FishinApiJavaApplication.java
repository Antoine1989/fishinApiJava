package net.fishinapi.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.fishinapi.springboot.model.TypeCapture;

@SpringBootApplication
public class FishinApiJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FishinApiJavaApplication.class, args);
		
		String test=  TypeCapture.POISSON.toString();
		System.out.println(test);
	}


}
