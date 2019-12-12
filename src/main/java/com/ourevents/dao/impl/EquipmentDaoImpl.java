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

import com.ourevents.dao.EquipmentDao;
import com.ourevents.model.Equipment;


@Repository
public class EquipmentDaoImpl extends JdbcDaoSupport implements EquipmentDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	 @Override
	public void insertEquipment(Equipment equ) {
		String sql = "INSERT INTO equipment VALUES (?,?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				equ.getEquipID(),equ.getEquipName()
		});
	}
	
	public List<Equipment> getAllEquipments(){
		String sql = "SELECT * FROM equipment";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Equipment> result = new ArrayList<Equipment>();
		for(Map<String, Object> row:rows){
			Equipment equ = new Equipment();
			equ.setEquipID((String)row.get("equipID"));
			equ.setEquipName((String)row.get("equipName"));
//			System.out.println(act);
			result.add(equ);
		}
		
		return result;
	}
	
	@Override
	public List<String> getAllEquipmentNames() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM equipment";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<String> result = new ArrayList<String>();
		for(Map<String, Object> row:rows){
			result.add((String)row.get("equipName"));
		}
		
		return result;
	}
	@Override
	public String getEquipmentIdFromName(String n) {
		// TODO Auto-generated method stub
		String sql = "SELECT equipID FROM equipment WHERE equipName = ?";

        return getJdbcTemplate().queryForObject(
                sql, new Object[]{n}, String.class);
	}
	
	
}
