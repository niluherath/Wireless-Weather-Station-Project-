package com.weltec.flad.wrapper;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import com.weltec.flad.entity.Sensor;
import com.weltec.flad.entity.WeatherStation;
import com.weltec.flad.util.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;


/**
 * FlightAdvice
 * @author Nilu Herath
 * Date: 20/08/2016
 * Student ID number:2140367
 * Wellington Institute of Technology
 * 
 * SensorWrapper class reads data from the sensor table.
 */

public class SensorWrapper {
	
	private Connection conn;
	/**
	 * Default constructor gets database connection
	 * @throws SQLException
	 */
	public SensorWrapper() throws SQLException {
		DBConnection  db = DBConnection.getInstance();
		conn = db.getDatabaseConnection();
	}
	/**
	 * selects a row in the SevsorWrapper class
	 * @param entity
	 * @returns a Sensor  objects
	 * @throws SQLException
	 */
	public Sensor select(String SensorId) throws SQLException {
		//select * from sensor where sensorId = 'T';
		String sql = "select * from sensor where " + "sensorId = " + "'" + SensorId+ "'";
		System.out.println(sql);
		
		Statement st = (Statement) conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		Sensor sensor = null;
		while(rs.next()) {
			sensor = new Sensor();
			sensor.setSensorId(rs.getString("SensorId"));
			sensor.setSensorName(rs.getString("SensorName"));
			sensor.setProductUsed(rs.getString("ProductUsed"));
			break;
		}
		return sensor;
	}
	/**
	 * inserts a row into Sensor table
	 * @param entity
	 * @return 
	 * @throws SQLException
	 */
	public boolean insert(Sensor entity) throws SQLException {
		//INSERT INTO sensor (SensorId, SensorName, ProductUsed)
		//VALUES ('T', 'Temperature', '');
		String sql = "insert into sensor(SensorId, SensorName, ProductUsed)" + "values("+ "'" + entity.getSensorId() + "'"+"," + "'" +
		                  entity.getSensorName() + "'"+"," + "'" + entity.getProductUsed() + "'"+")";
		System.out.println(sql);
		Statement st = (Statement) conn.createStatement();
		int count = st.executeUpdate(sql);
		boolean inserted = false;
		if(count >0) {
			inserted = true;
		}
		return inserted;
	}
	
	/**
	 * updates a row in the Sensor table
	 * @param entity
	 * @throws SQLException
	 */
	public void update(Sensor entity) throws SQLException {
		 //UPDATE sensor SET SensorName ='Wind Gust' WHERE SensorId ='WS';
		String sql = "update sensor set SensorName =" + "'" + entity.getSensorName()+"'"+"where SensorId=" + "'" + entity.getSensorId()+"'";
		Statement st = (Statement) conn.createStatement();
		st.executeUpdate(sql);
	}
	
	/**
	 * deletes a row in the sensor table
	 * @param entity
	 * @throws SQLException
	 */
	public void delete(Sensor entity) throws SQLException {
		//delete from sensor where SensorId = 'T';
		String sql = "delete from sensor where SensorId=" +"'"+entity.getSensorId()+"'";
		Statement st = (Statement) conn.createStatement();
		st.executeUpdate(sql);
	}
	/**
	 * @throws SQLException 
	 * selects all the rows in the Sensor table
	 * @param
	 * @throws
	 */
	public Sensor[] selectAll() throws SQLException {
		//select * from sensor;
		String sql = "select * from sensor";
		Statement st = (Statement) conn.createStatement();
		ResultSet rst = ((java.sql.Statement) st).executeQuery(sql);
		Sensor[] array = null;
		array = new Sensor[10];
		ArrayList<Sensor> list = new ArrayList<Sensor>();
		Sensor sen;
		while(rst.next()) {
			sen = new Sensor();
			sen.setSensorId(rst.getString("SensorId"));
			sen.setSensorName(rst.getString("SensorName"));
			sen.setProductUsed(rst.getString("ProductUsed"));
			list.add(sen);
		}
		Sensor[] wsArray = list.toArray(new Sensor[list.size()]);
		return wsArray;
		
	}

}
