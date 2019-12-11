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
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.ourevents.dao.PhotographyDao;
import com.ourevents.model.Photography;


@Repository
public class PhotographyDaoImpl extends JdbcDaoSupport implements PhotographyDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	 @Override
	public void insertPhotography(Photography pho) {
		String sql = "INSERT INTO photography VALUES (?,?,?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				pho.getPhoID(),pho.getPhoName() ,pho.getPhoContNo()
		});
	}
	
	public List<Photography> getAllPhotographys(){
		String sql = "SELECT * FROM photography";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Photography> result = new ArrayList<Photography>();
		for(Map<String, Object> row:rows){
			Photography pho = new Photography();
			pho.setPhoID((String)row.get("phoID"));
			pho.setPhoName((String)row.get("phoName"));
			pho.setPhoContNo((String)row.get("phoContNo"));
//			System.out.println(act);
			result.add(pho);
		}
		
		return result;
	}
	@Override
	public List<String> getAllPhoNames() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM photography";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<String> result = new ArrayList<String>();
		for(Map<String, Object> row:rows){
			result.add((String)row.get("phoName"));
		}
		
		return result;
	}
	@Override
	public String getPhoIdFromName(String n) {
		// TODO Auto-generated method stub
		String sql = "SELECT phoID FROM photography WHERE phoName = ?";

        return getJdbcTemplate().queryForObject(
                sql, new Object[]{n}, String.class);
	}
	
}
