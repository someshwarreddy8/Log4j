package com.somesh;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@EnableAutoConfiguration
@ComponentScan
@SpringBootConfiguration
/* @SpringBootApplication */
public class SpringBootLog4jStarter {
	
	private static final Logger log = Logger.getLogger(SpringBootLog4jStarter.class);

	static {
		PropertyConfigurator.configure("src/main/java/com/somesh/Log4jProperties/Log4j.properties");
	}

	public static void main(String[] args) {  
		String methodName="main";
                     log.debug(String.format("method : %s starts in SpringBootLog4jStarter", methodName));
		             SpringApplication application = new SpringApplication(SpringBootLog4jStarter.class);
		             ConfigurableApplicationContext run = application.run(args);
		             log.debug(String.format("method : %s end in SpringBootLog4jStarter", methodName));
		
	}

}
