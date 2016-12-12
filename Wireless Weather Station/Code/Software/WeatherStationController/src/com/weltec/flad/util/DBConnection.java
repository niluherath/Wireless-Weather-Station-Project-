package com.weltec.flad.util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * FlightAdvice
 * @author Nilu Herath
 * Date: 20/08/2016
 * Student ID number:2140367
 * Wellington Institute of Technology
 * 
 * DBConnection class gets a connection to the database.
 */
public class DBConnection {
	
	private Connection myConn = null;
	private Statement myStmt = null;
	private ResultSet myRs = null;
	String JDBC_DRIVER = null;
	private static DBConnection instance = null;
	
	/**
	 * 
	 * @throws SQLException
	 */	
	private DBConnection() {
		try {  
			JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightadvice", "student" , "password");
			System.out.println("Database connection successful!\n");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Connection getDatabaseConnection() throws SQLException {
		return myConn;
	}
	
	public static DBConnection getInstance() {
		if (instance == null) {
	         instance = new DBConnection();
	    }
		return instance;
	}
	
	public static void main(String[]args) throws SQLException {
		DBConnection ob = DBConnection.getInstance();
	}
		
}
	
	