package com.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import com.entity.Grade;
import com.entity.Student;

public class GradeDao implements IGradeDao {
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Grade> getAllGeade() {
		String sql = "select * from grade";
		RowMapper<Grade> rowMapper = ParameterizedBeanPropertyRowMapper.newInstance(Grade.class);
		return this.jdbcTemplate.query(sql, rowMapper);
	}

}
