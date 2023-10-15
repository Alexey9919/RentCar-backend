package ru.zagrebin.RentalCar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.management.modelmbean.ModelMBean;

@SpringBootApplication
public class RentalCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalCarApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
