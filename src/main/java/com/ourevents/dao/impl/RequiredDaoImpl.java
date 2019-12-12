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

import com.ourevents.dao.RequiredDao;
import com.ourevents.model.Required;
import com.ourevents.model.Required;


@Repository
public class RequiredDaoImpl extends JdbcDaoSupport implements RequiredDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	 @Override
	public void insertRequired(Required req) {
		String sql = "INSERT INTO required VALUES (?,?,?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				req.getEvenID(),req.getEquipID() ,req.getQuantity_req()
		});
	}
	
	public List<Required> getAllRequireds(){
		String sql = "SELECT * FROM required";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Required> result = new ArrayList<Required>();
		for(Map<String, Object> row:rows){
			Required req = new Required();
			req.setEvenID((String)row.get("evenID"));
			req.setEquipID((String)row.get("equipID"));
			req.setQuantity_req((int)row.get("quantity_req"));
//			System.out.println(act);
			result.add(req);
		}
		
		return result;
	}
	@Override
	public List<Required> getReqByEvent(String mid) {
		// TODO Auto-generated method stub
		String sql = "SELECT equipName,quantity_req FROM required r,equipment e WHERE "
				+ "r.equipID = e.equipID AND evenID = '"+mid+"'";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Required> result = new ArrayList<Required>();
		for(Map<String, Object> row:rows){
			Required cas = new Required();
//			cas.setMovID((String)row.get("movID"));
			cas.setEquipID((String)row.get("equipName"));
			cas.setQuantity_req((int)row.get("quantity_req"));
//			System.out.println(cas);
			result.add(cas);
		}
		
		return result;
	}
	
}
