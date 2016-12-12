package com.weltec.flad.util;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.junit.Test;

public class DBConnectionTest {
	@Test
	public void test() {
		//fail("Not yet implemented");
	}
	@Test
	public void testGetDatabaseConnectionInstance() {
		DBConnection datBaseCon = DBConnection.getInstance();
		assertNotNull(datBaseCon);
	}
	@Test
	public void testGetDatabaseConnection() {
		DBConnection datBaseCon = DBConnection.getInstance();
		assertNotNull(datBaseCon);
		try {
			assertNotNull(datBaseCon.getDatabaseConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
