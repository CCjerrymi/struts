package com.dao;

import java.util.List;

import com.entity.Student;

public interface IStudentDao {
	//添加学生
	public int addStudent(Student student);
	//更新学生
	public int updateStudent(Student student);
	//删除用户
	public int deleteStudentByStuNumber(String stuNumber);
	//根据班级查询学生
	public List<Student> getStudentsByclassNumber(int stuClassNumber);
	//根据学号查找学生
	public Student getStudentByStuNumber(String stuNumber);
}
