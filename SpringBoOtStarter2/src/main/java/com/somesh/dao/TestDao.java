package com.somesh.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
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
import com.somesh.model.Student;

public class TestDao {

	private static final Logger log = Logger.getLogger(TestDao.class);
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
		log.debug(String.format("method %S start in dao.", methodName));

		List<Student> students = null;

		try {
			/*
			 * students = Arrays.asList(new Student(1, "abc", 8897100141L), new Student(2,
			 * "xyz", 12345678910L), new Student(3, "mno", 3256987456L));
			 */throw new RuntimeException("run time exception occured.");
		} /*
			 * catch (AppException e) {
			 * log.error("sql exception occured in getStudents, while getting data"); throw
			 * new AppException("sql exception occured in getStudents, while getting data");
			 * }
			 */ catch (Exception e) {
			log.fatal(String.format("unknown exception occured in getStudents in TestDao : %s", e.getMessage()));
			e.printStackTrace();
		} finally {
			log.debug(String.format("Method %s end in dao.", methodName));
		}
		log.info("returning students data from dao.");
		return students;
	}

}
