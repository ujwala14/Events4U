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

import com.ourevents.dao.DirectorDao;
import com.ourevents.model.Director;


@Repository
public class DirectorDaoImpl extends JdbcDaoSupport implements DirectorDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	 @Override
	public void insertDirector(Director dir) {
		String sql = "INSERT INTO director VALUES (?,?,?,?,?,?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				dir.getDirectorID(), dir.getDirectorName(),dir.getDob(),
				dir.getDirectorNationality(),dir.getGender(),dir.getWikiLink()
		});
	}
	
	public List<Director> getAllDirectors(){
		String sql = "SELECT * FROM director";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Director> result = new ArrayList<Director>();
		for(Map<String, Object> row:rows){
			Director dir = new Director();
			dir.setDirectorID((String)row.get("directorID"));
			dir.setDirectorName((String)row.get("directorName"));
			dir.setDob((String)row.get("dob"));
			dir.setDirectorNationality((String)row.get("directorNationality"));
			dir.setGender((String)row.get("gender"));
			dir.setWikiLink((String)row.get("wikiLink"));
//			System.out.println(act);
			result.add(dir);
		}
		
		return result;
	}
	@Override
	public List<String> getAllDirectorNames() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM director";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<String> result = new ArrayList<String>();
		for(Map<String, Object> row:rows){
			result.add((String)row.get("directorName"));
		}
		
		return result;
	}
	
}
