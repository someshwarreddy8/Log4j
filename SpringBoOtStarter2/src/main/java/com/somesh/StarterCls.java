package com.somesh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class StarterCls {

	public static void main(String[] args) {

		SpringApplication application = new SpringApplication(StarterCls.class);
		ConfigurableApplicationContext applicationContext = application.run(args);
	}

}
