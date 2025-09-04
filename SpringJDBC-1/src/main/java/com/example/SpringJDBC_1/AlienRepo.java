package com.example.SpringJDBC_1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AlienRepo {
	
	// AlienRepo is created for database related logic
	
	// Step 1 --> create a reference of JdbcTemplate (this object helps us to run SQL queries)
	private JdbcTemplate template;
	
	// Step 2 --> create getter for JdbcTemplate (optional, used if we want to access it outside)
	public JdbcTemplate getTemplate() {
		return template;
	}

	// Step 3 --> add @Autowired so Spring can give us (inject) the JdbcTemplate automatically
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	// Step 4 --> write the save method to insert data into the database
	public void save(Alien alien) {
		
		// write the SQL insert query with placeholders (?)
		String sql = "insert into alien (id, name, tech) values (?, ?, ?)";
		
		// Step 4.1 --> use template.update() instead of executeUpdate() 
		// template.update will replace the ? with given values and run the query
		int rows = template.update(sql, alien.getId(), alien.getName(), alien.getTech());
		
		// Step 4.2 --> print how many rows got inserted
		System.out.println(rows + " row(s) inserted");
		
		// Step 5 --> for this insert to work, the table must exist in H2 database
		// Step 5.1 --> create a file schema.sql in resources folder
		// Step 5.2 --> inside schema.sql, write a script to create table alien(id, name, tech)
	}
	
	// Step 6 --> write a method to fetch all alien records from the database
	public List<Alien> findAll() {
		
		// Step 6.1 --> write the SQL select query
		String sql = "select * from alien";
		
		// Step 6.2 --> create a RowMapper object
		// RowMapper helps us to fetch one row at a time and convert it into an Alien object
		RowMapper<Alien> mapper = new RowMapper<Alien>() {
			@Override
			public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
				// Step 6.2.1 --> create new Alien object
				Alien a = new Alien();
				
				// Step 6.2.2 --> set values from ResultSet into Alien object
				a.setId(rs.getInt("id"));
				a.setName(rs.getString("name"));
				a.setTech(rs.getString("tech"));
				
				// Step 6.2.3 --> return the Alien object
				return a;
			}
		};
		
		// Step 6.3 --> use template.query() with SQL + mapper, it will return List<Alien>
		List<Alien> aliens =  template.query(sql, mapper);
		
		return aliens;
	}
}
