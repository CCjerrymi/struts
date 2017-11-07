package com.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import com.entity.Student;

public class StudentDao implements IStudentDao {
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int addStudent(Student student) {
		//定义sql语句
		String sql = "insert into student(stuName,stuNumber,age,stuClassNumber)values(?,?,?,?)";
		//存放sql语句
		Object[] obj = new Object[]{
				student.getStuName(),
				student.getStuNumber(),
				student.getAge(),
				student.getStuClassNumber()
		};
		//获取返回结果
		int flag = this.jdbcTemplate.update(sql,obj);
		
		return flag;
	}

	@Override
	public int updateStudent(Student student) {
		//我觉得可以直接把值拼接在语句中？为什么不呢？难道是防止sql注入攻击？
		String sql = "update student set stuName=?,stuNumber=?,age=?,stuClassNumber=?";
		Object[] params = new Object[]{
			student.getStuName(),
			student.getStuNumber(),
			student.getAge(),
			student.getStuClassNumber()
		};
		
		int flag = this.jdbcTemplate.update(sql,params);
		return flag;
	}

	@Override
	public int deleteStudentByStuNumber(String stuNumber) {
		String sql = "delete from student where stuNumber=?";
		int flag = this.jdbcTemplate.update(sql,stuNumber);
		return 0;
	}

	@Override
	public List<Student> getStudentsByclassNumber(int stuClassNumber) {
		String sql = "select * from student where stuClassNumber=?";
		RowMapper<Student> rowMapper = ParameterizedBeanPropertyRowMapper.newInstance(Student.class);
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Student getStudentByStuNumber(String stuNumber) {
		String sql = "select * from student where stuNumber=?";
		RowMapper<Student> rowMapper = ParameterizedBeanPropertyRowMapper.newInstance(Student.class);
		return this.jdbcTemplate.queryForObject(sql, rowMapper,stuNumber);
	}

}
