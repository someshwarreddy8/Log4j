package com.somesh.dao;

import java.util.List;

import com.somesh.model.Student;
import com.somesh.util.exceptions.AppException;

public interface StudentDao {

	List<Student> getStudents() throws AppException;

}
