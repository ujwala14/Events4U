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
import org.springframework.jdbc.core.JdbcTemplate;

import com.ourevents.dao.AvailableDao;
import com.ourevents.model.Available;
import com.ourevents.model.Available;


@Repository
public class AvailableDaoImpl extends JdbcDaoSupport implements AvailableDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	 @Override
	public void insertAvailable(Available a) {
		String sql = "INSERT INTO available VALUES (?,?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				a.getEventId(),a.getAvailSeats()
		});
	}
	
	public List<Available> getAllAvailables(){
		String sql = "SELECT * FROM available";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Available> result = new ArrayList<Available>();
		for(Map<String, Object> row:rows){
			Available a = new Available();
			a.setEventId((String)row.get("eventId"));
			a.setAvailSeats((int)row.get("availseats"));
//			System.out.println(a);
			result.add(a);
		}
		
		return result;
	}
	@Override
	public Available getAvailableById(String n) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM available where eventId= ?";
		try {
			Available avail = (Available)getJdbcTemplate().queryForObject(sql, new Object[]{n}, 
					new RowMapper<Available>(){
				@Override
				public Available mapRow(ResultSet rs, int rwNumber) throws SQLException {
					Available v = new Available();
					v.setEventId((String)rs.getString("eventId"));
					v.setAvailSeats((int)rs.getInt("availSeats"));
					return v;
				}
			});	
			return avail;
		}catch(Exception e) {
			return null;
		}
	}
	@Override
	public void reduceSeats(String eid, int seats) {
		// TODO Auto-generated method stub
		Available a = getAvailableById(eid);
		int avai = a.getAvailSeats();
		int rem = avai - seats;
		String sql = "Update available set availSeats = ? where eventId = ?";
		getJdbcTemplate().update(sql,rem,a.getEventId());
		
	}
	
}
