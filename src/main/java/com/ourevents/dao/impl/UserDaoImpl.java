package com.ourevents.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;


import com.ourevents.dao.UserDao;
import com.ourevents.model.User;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	public void insertUser(User u) {
		String sql = "INSERT INTO user VALUES (?,?,?,SHA1(?),?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				u.getUserName(),u.getPhoneNo(),u.getEmail(),
				u.getPwd(),u.getAge()
		});
	}


	@Override
	public User getUserAfterLogin(String email, String pwd) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM user where email = ? and pwd = SHA1(?)";
		try {
			User movie = (User)getJdbcTemplate().queryForObject(sql, new Object[]{email,pwd}, 
					new RowMapper<User>(){
				@Override
				public User mapRow(ResultSet rs, int rwNumber) throws SQLException {
					User u = new User();
					u.setUserName((String)rs.getString("userName"));
					u.setPhoneNo((String)rs.getString("phoneNo"));
					u.setEmail((String)rs.getString("email"));
					u.setAge((int)rs.getInt("age"));

					System.out.println(u);
					return u;
				}
			});	
			return movie;
		}catch(Exception e) {
			return null;
		}
	}
}