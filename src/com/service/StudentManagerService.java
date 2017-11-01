package com.service;

import com.entity.Student;

public interface StudentManagerService {
		public boolean updateStudent(Student student);
		public boolean addStudent(Student student);
		public boolean deleteStudent(Student student);
		public Student getStudentByCondition(String condition);
		public Student getStudentByStuNumber(String stuNumber);
}
