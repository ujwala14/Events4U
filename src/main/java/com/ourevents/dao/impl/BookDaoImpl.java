package com.ourevents.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.ourevents.dao.BookDao;
import com.ourevents.model.Book;

@Repository
public class BookDaoImpl extends JdbcDaoSupport implements BookDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	public void insertBook(Book v) {
		String sql = "INSERT INTO book VALUES (?,?,?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				v.getEventId(),v.getUserEmail(),v.getNoSeats()
		});
	}
	
	public List<Book> getAllBooks(){
		String sql = "SELECT * FROM book";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Book> result = new ArrayList<Book>();
		for(Map<String, Object> row:rows){
			Book v = new Book();
			v.setEventId((String)row.get("eventId"));
			v.setUserEmail((String)row.get("userEmail"));
			v.setNoSeats((int)row.get("noSeats"));
			
//			System.out.println(v);
			result.add(v);
		}
		
		return result;
	}
}
