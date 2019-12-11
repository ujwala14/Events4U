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

import com.ourevents.dao.PerformerDao;
import com.ourevents.model.Performer;


@Repository
public class PerformerDaoImpl extends JdbcDaoSupport implements PerformerDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	 @Override
	public void insertPerformer(Performer per) {
		String sql = "INSERT INTO performer VALUES (?,?,?,?,?,?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				per.getPerformerID(), per.getPerformerName() ,per.getCategory(),
				per.getPhoneNo(),per.getSocialMedia(),per.getEmail()
		});
	}
	
	public List<Performer> getAllPerformers(){
		String sql = "SELECT * FROM performer";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Performer> result = new ArrayList<Performer>();
		for(Map<String, Object> row:rows){
			Performer per = new Performer();
			per.setPerformerID((String)row.get("performerID"));
			per.setPerformerName((String)row.get("performerName"));
			per.setCategory((String)row.get("category"));
			per.setPhoneNo((String)row.get("phoneNo"));
			per.setSocialMedia((String)row.get("socialMedia"));
			per.setEmail((String)row.get("email"));
//			System.out.println(act);
			result.add(per);
		}
		
		return result;
	}
	@Override
	public List<String> getAllPerformerNames() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM performer";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<String> result = new ArrayList<String>();
		for(Map<String, Object> row:rows){
			result.add((String)row.get("performerName"));
		}
		
		return result;
	}
	@Override
	public String getPerformerIdFromName(String n) {
		// TODO Auto-generated method stub
		String sql = "SELECT performerID FROM performer WHERE performerName = ?";

        return getJdbcTemplate().queryForObject(
                sql, new Object[]{n}, String.class);
	}
	
}
