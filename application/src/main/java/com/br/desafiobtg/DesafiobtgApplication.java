package com.br.desafiobtg;


import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableRabbit
@SpringBootApplication
@ComponentScan("com.br.desafiobtg")
public class DesafiobtgApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafiobtgApplication.class, args);
	}

}
