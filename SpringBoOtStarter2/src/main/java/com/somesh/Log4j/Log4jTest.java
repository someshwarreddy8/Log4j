package com.somesh.Log4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.format.DateTimeFormatter;

public class Log4jTest {

	//private static final Logger log = LoggerFactory.getLogger(Log4jTest.class);
	private static final Logger log =Logger.getLogger(Log4jTest.class);
	
//	private final Logger log1 =Logger.getLogger(Log4jTest.class);
	
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static void loggerTest() {
		String methodName = "loggerTest";
		long currentTime = System.currentTimeMillis();
		LocalDate now = LocalDate.now();
		//LocalDate datetime = LocalDate.parse(String.valueOf(currentTime), formatter);
		String Stringdate = now.format(formatter);
		
		
		  Layout layout = new SimpleLayout();
		  HTMLLayout htmlLayout = new HTMLLayout();
		  
		  Appender appender = new ConsoleAppender(layout);
		 
           log.addAppender(appender);
		log.info(String.format("method start at : %s ", Stringdate));
		
		log.info(LogMethods.methodInfo);
		log.debug(LogMethods.methodDebug);
		log.error(LogMethods.methodError);
		log.warn(LogMethods.methodWarn);
		
		log.info(String.format("method end at : %s", Stringdate));
		
		System.out.println();

	}

}
