package com.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import com.entity.Student;
import com.entity.User;

public class UserDao implements IUserDao {
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public User getUserByName(String userName) {
		String sql = "select * from user where userName=?";
		RowMapper<User> rowMapper = ParameterizedBeanPropertyRowMapper.newInstance(User.class);
		return this.jdbcTemplate.queryForObject(sql, rowMapper,userName);
	}

}
