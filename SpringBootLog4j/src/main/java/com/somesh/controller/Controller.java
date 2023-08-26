package com.somesh.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.somesh.model.Student;
import com.somesh.service.Service;
import com.somesh.util.exceptions.AppException;

@RestController
public class Controller {
	
	private static final Logger log = Logger.getLogger(Controller.class);
	
	static {
		PropertyConfigurator.configure("src/main/java/com/somesh/Log4jProperties/Log4j.properties");
	}

	@Autowired
	private Service service;

	@RequestMapping(name = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getStudents() throws AppException {
		String methodName="getStudents";
		log.debug(String.format("method : %s start in Controller.getStudents", methodName));
		List<Student> students = null;
		try {
			log.debug("Entering into service method..!");
			students = service.getStudents();
		} catch (AppException e) {
			log.error(String.format("AppException occured in Controller.getStudents : %s", e.getMessage()));
			throw new AppException(String.format("AppException occured in Controller.getStudents : %s", e.getMessage()));
		} catch (NullPointerException e) {
			log.error(String.format("NullPointerException occured in Controller.getStudents : %s", e.getMessage()));
			throw new AppException(String.format("NullPointerException occured in Controller.getStudents : %s", e.getMessage()));
		} catch (Exception e) {
			log.fatal(String.format("Unknown Exception occured in Controller.getStudents : %s", e.getMessage()));
			throw new AppException(String.format("Unknown Exception occured in Controller.getStudents : %s", e.getMessage()));
		} finally {
			log.debug(String.format("method : %s end in Controller.getStudents", methodName));
		}
		log.info("returning httpResponse as json..!");
		return ResponseEntity.status(HttpStatus.OK).body(students);
	}
}
