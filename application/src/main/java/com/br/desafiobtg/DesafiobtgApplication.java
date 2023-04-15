package com.br.desafiobtg;


import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication(scanBasePackages = "desafiobtg")
public class DesafiobtgApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafiobtgApplication.class, args);
	}

}
