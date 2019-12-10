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

import com.ourevents.dao.DirectDao;
import com.ourevents.model.Cast;
import com.ourevents.model.Direct;


@Repository
public class DirectDaoImpl extends JdbcDaoSupport implements DirectDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	 @Override
	public void insertDirect(Direct dir) {
		String sql = "INSERT INTO direct VALUES (?,?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				dir.getMovID(),dir.getDirectID()
		});
	}
	
	 public List<Direct> getAllDirects(){
			String sql = "SELECT * FROM direct";
			List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
			
			List<Direct> result = new ArrayList<Direct>();
			for(Map<String, Object> row:rows){
				Direct dir = new Direct();
				dir.setMovID((String)row.get("movID"));
				dir.setDirectID((String)row.get("directID"));
//				System.out.println(cas);
				result.add(dir);
			}
			
			return result;
		}
	@Override
	public List<Direct> getDirectByMovie(String mid) {
		// TODO Auto-generated method stub
		//String sql = "SELECT * FROM cast WHERE movID = '"+mid+"'";
		String sql = "SELECT directorName FROM direct,director WHERE "
				+ "directorID = directID AND movID = '"+mid+"'";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Direct> result = new ArrayList<Direct>();
		for(Map<String, Object> row:rows){
			Direct dir = new Direct();
//			cas.setMovID((String)row.get("movID"));
			dir.setDirectID((String)row.get("directorName"));
//			System.out.println(dir);
			result.add(dir);
		}
		
		return result;
	}
	
	@Override
	public String getDirectorIdFromName(String dn) {
		// TODO Auto-generated method stub
		String sql = "SELECT directorID FROM director WHERE directorName = ?";

        return getJdbcTemplate().queryForObject(
                sql, new Object[]{dn}, String.class);
	}
	
}
