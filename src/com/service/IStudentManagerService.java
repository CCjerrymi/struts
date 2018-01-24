package com.service;

import java.util.List;

import com.entity.Student;

public interface IStudentManagerService {
		public boolean updateStudent(Student student);
		public boolean addStudent(Student student);
		public boolean deleteStudent(Student student);
		public Student getStudentByCondition(String condition);
		public Student getStudentByStuNumber(String stuNumber);
		public List<Student> getStudentsByclassNumber(String stuClassNumber);
}
