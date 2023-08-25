package com.somesh.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.somesh.Exceptions.AppException;
import com.somesh.Log4j.Log4jTest;
import com.somesh.model.Student;
import com.somesh.service.TestService;

@RestController
public class TestController2 {

	private static final Logger log = Logger.getLogger(TestController2.class);

	static {
		PropertyConfigurator.configure("src/main/java/com/somesh/Log4j/Properties/Log4j.Properties");
	}

	@GetMapping("/getStudentss")
	public ResponseEntity<List<Student>> getStudents() throws AppException {
		String methodName = "getStudents";
		log.debug(String.format("Controller method %s start", methodName));

		List<Student> students = null;

		try {

			students = TestService.getStudents();

		} catch (AppException e) {
			log.error(String.format("exception in getStudents while getting students data in Controller class : %s",
					e.getMessage()));
		} catch (Exception e) {
			log.fatal("unknown exception in controller while getting students data.");
			throw new AppException(
					String.format("unknown exception occured while getting students data", e.getMessage()));
		} finally {
			log.debug(String.format("method %s end in controller.", methodName));
		}
		log.info("printing Response to ResponseEntity.");
		log.warn(String.format("students : %S", students));
		return ResponseEntity.status(HttpStatus.OK).body(students);

	}

}
