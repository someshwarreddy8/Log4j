package com.somesh.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;

import com.somesh.controller.Controller;
import com.somesh.dao.StudentDao;
import com.somesh.model.Student;
import com.somesh.util.exceptions.AppException;

@org.springframework.stereotype.Service
public class Service {

	private static final Logger log = Logger.getLogger(Service.class);

	static {
		PropertyConfigurator.configure("src/main/java/com/somesh/Log4jProperties/Log4j.properties");
	}

	@Autowired
	private StudentDao dao;

	public List<Student> getStudents() throws AppException {
          String methodName = "getStudents";
  		log.debug(String.format("method : %s start in Service.getStudents", methodName));

		List<Student> students = null;
		try {
			log.debug("Entering into DaoImpl..!");
			students = dao.getStudents();
		} catch (AppException e) {
			throw new AppException(String.format("AppException occured in Service.getStudents : %s", e.getMessage()));
		} catch (Exception e) {
			throw new AppException(
					String.format("Unknown Exception occured in Service.getStudents : %s", e.getMessage()));
		} finally {
			log.debug(String.format("method : %s end in Service.getStudents", methodName));
		}

		return students;

	}

}
