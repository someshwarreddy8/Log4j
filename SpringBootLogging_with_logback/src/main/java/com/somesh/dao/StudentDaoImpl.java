package com.somesh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.somesh.model.Student;
import com.somesh.service.Service;
import com.somesh.util.exceptions.AppException;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	private static final Logger log = LoggerFactory.getLogger(StudentDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemp;

	@Override
	public List<Student> getStudents() throws AppException {
           String methodName="getStudents";
			log.debug(String.format("method : %s end in DaoImpl.getStudents", methodName));
			List<Student> ListOfStudents = new ArrayList<>();
		try {
            log.info(String.format("Eshtablishing connection &  fetching data from db in  DaoImpl.getStudents method : %s", methodName));
			ListOfStudents = jdbcTemp.query("select id, name, mobile, country from students", rs -> {
				List<Student> students = new ArrayList<>();
				while (rs.next()) {
					Student s = new Student();
					s.setId(rs.getInt(1));
					s.setName(rs.getString(2));
					s.setMobile(rs.getString(3));
					s.setContry(rs.getString(4));
					students.add(s);
				}
				return students;
			});
			log.debug("data fetching completed successfully...!");
		} catch (DataAccessException e) {
			log.error(String.format("DataAccessException occured in StudentDaoImpl.getStudents while fetching list of students data : %s",e.getMessage()));
			throw new AppException(String.format("DataAccessException occured in StudentDaoImpl.getStudents while fetching list of students data : %s",e.getMessage()));
		} catch (NullPointerException e) {
			log.error(String.format("NullPointerException occured in StudentDaoImpl.getStudents while fetching list of students data : %s",e.getMessage()));
			throw new AppException(String.format("NullPointerException occured in StudentDaoImpl.getStudents while fetching list of students data : %s",e.getMessage()));
		} catch (ArrayIndexOutOfBoundsException e) {
			log.error(String.format("ArrayIndexOutOfBoundsException occured in StudentDaoImpl.getStudents while fetching list of students data : %s",e.getMessage()));
			throw new AppException(String.format("ArrayIndexOutOfBoundsException occured in StudentDaoImpl.getStudents while fetching list of students data : %s",e.getMessage()));
		} catch (Exception e) {
			log.error(String.format("Unknown Exception occured in StudentDaoImpl.getStudents while fetching list of students data : %s",e.getMessage()));
			throw new AppException(String.format("Unknown Exception occured in StudentDaoImpl.getStudents while fetching list of students data : %s", e.getMessage()));
		}
		finally {
			log.debug(String.format("method : %s end in DaoImpl.getStudents", methodName));
		}
		return ListOfStudents;
	}
}
