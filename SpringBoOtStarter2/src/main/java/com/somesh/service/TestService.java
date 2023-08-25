package com.somesh.service;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import com.somesh.Exceptions.AppException;
import com.somesh.dao.TestDao;
import com.somesh.model.Student;

public class TestService {

	private static Logger log = Logger.getLogger(TestService.class);
	static {
		// Layout layout = new SimpleLayout();
		HTMLLayout htmllayout = new HTMLLayout();
		FileAppender appender = null;
		try {
			appender = new FileAppender(htmllayout, "log250823.html", true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Appender appender = new ConsoleAppender(layout);
		log.addAppender(appender);
		log.setLevel(Level.DEBUG); // only above info methods gets printed on console. debug<info<warn<error<fatal.
	}

	public static List<Student> getStudents() throws AppException {
		String methodName = "getStudents";
		log.debug(String.format("method %s start in service", methodName));
		List<Student> students = null;

		try {
			students = TestDao.getStudents();
		} catch (AppException ae) {
			log.error("exception occured in getStudents while getting students data");
			throw new AppException("exception occured in getStudents while getting students data");
		} catch (Exception e) {
			log.fatal("unknown exception in getStudents in service.");
			e.printStackTrace();
		} finally {
			log.debug(String.format("method %s end in service ", methodName));
		}
		log.info("returning students data form service.");
		return students;
	}

}
