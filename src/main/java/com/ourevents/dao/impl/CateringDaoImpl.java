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

import com.ourevents.dao.CateringDao;
import com.ourevents.model.Catering;
import com.ourevents.model.Catering;


@Repository
public class CateringDaoImpl extends JdbcDaoSupport implements CateringDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	 @Override
	public void insertCatering(Catering cat) {
		String sql = "INSERT INTO catering VALUES (?,?,?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				cat.getCatID(),cat.getCatName() ,cat.getCatContNo()
		});
	}
	
	public List<Catering> getAllCaterings(){
		String sql = "SELECT * FROM catering";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Catering> result = new ArrayList<Catering>();
		for(Map<String, Object> row:rows){
			Catering cat = new Catering();
			cat.setCatID((String)row.get("catID"));
			cat.setCatName((String)row.get("catName"));
			cat.setCatContNo((String)row.get("catContNo"));
//			System.out.println(act);
			result.add(cat);
		}
		
		return result;
	}
	@Override
	public List<String> getAllCateringNames() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM catering";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<String> result = new ArrayList<String>();
		for(Map<String, Object> row:rows){
			result.add((String)row.get("catName"));
		}
		
		return result;
	}
	@Override
	public String getCateringIdFromName(String n) {
		// TODO Auto-generated method stub
		String sql = "SELECT catID FROM catering WHERE catName = ?";

        return getJdbcTemplate().queryForObject(
                sql, new Object[]{n}, String.class);
	}
	@Override
	public Catering getCateringById(String n) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM catering where catID= ?";
		try {
			Catering cater = (Catering)getJdbcTemplate().queryForObject(sql, new Object[]{n}, 
					new RowMapper<Catering>(){
				@Override
				public Catering mapRow(ResultSet rs, int rwNumber) throws SQLException {
					Catering cat = new Catering();
					cat.setCatID((String)rs.getString("catID"));
					cat.setCatName((String)rs.getString("catName"));
					cat.setCatContNo((String)rs.getString("catContNo"));
					return cat;
				}
			});	
			return cater;
		}catch(Exception e) {
			return null;
	}
	}
	
}
