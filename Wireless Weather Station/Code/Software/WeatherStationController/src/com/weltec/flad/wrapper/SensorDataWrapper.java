package com.weltec.flad.wrapper;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import com.mysql.jdbc.Statement;
import com.weltec.flad.entity.SensorData;
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
 * Sensor data wrapper class reads and inputs to the sensorData table.
 */
/**
 * 
 * @author Nilu Herath
 * Constructor, gets a database connection
 *
 */

public class SensorDataWrapper {
	private Connection conn;
	/**
	 * Default constructor. Gets a database connection.
	 */
	public SensorDataWrapper() {
		DBConnection  db = DBConnection.getInstance();
		try {
			conn = db.getDatabaseConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * selects a row from the SensorData table
	 * @param entity
	 * @throws SQLException
	 */
	public SensorData select(int iD) throws SQLException {
		//select * from sensordata where id = 1;
		String sql = "select * from sensordata where id ="+ iD;
		Statement stm = (Statement) conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		SensorData sd = null;
		while(rs.next()) {
			sd = new SensorData();
			sd.setiD(rs.getInt("id"));
			sd.setStationId(rs.getString("StationId"));
			sd.setSensorReading(rs.getString("SensorReading"));
			sd.setReadingUnit(rs.getString("ReadingUnit"));
			Date dateAndTime = rs.getDate("ReadingDateTime");
			DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
			sd.setReadingDateTime((java.sql.Date) dateAndTime);
			
			break;

		}
		return sd;
	}

	public SensorData[] select(String sensorId, Date startDate, Date endDate) throws SQLException {
		return null;
	}
	
	public SensorData[] select(String sensorId) throws SQLException {
		return null;
	}
	
	public SensorData[] select(String sensorReading, String readingUnit) throws SQLException {
		return null;
	}

	
	/**
	 * selects all the rows from the sensordata table
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	public SensorData[] selectAll() throws SQLException, ParseException {
		//select * from sensordata;
		String sql = "select * from sensordata";
		Statement stm = (Statement) conn.createStatement();
		ResultSet stam = ((java.sql.Statement) stm).executeQuery(sql);
		ArrayList<SensorData> list = new ArrayList<SensorData>();
		while(stam.next()) {
			SensorData sd = new SensorData();
			String id = stam.getString("id");
			int i = Integer.parseInt(id);
			sd.setiD(i);
			sd.setStationId(stam.getString("StationId"));
			sd.setSensorReading(stam.getString("SensorReading"));
			sd.setReadingUnit(stam.getString("ReadingUnit"));
			sd.setReadingDateTime(stam.getDate("ReadingDateTime"));
			list.add(sd);
			
		}
		SensorData[] sdArray = list.toArray(new SensorData[list.size()]);
		
		return sdArray;
	}
	
	/**
	 * inserts a tow to the sensordata table
	 * @param entity
	 * @throws SQLException
	 */
	public boolean insert(SensorData entity) throws SQLException {
		//INSERT INTO sensordata (StationId, SensorId, SensorReading, ReadingUnit)
		//VALUES ('2','T', '23', 'C');
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 

		entity.getReadingDateTime();
		
		String dateString = df.format(entity.getReadingDateTime());
		
		System.out.println(dateString);
		
		String sql = "insert into sensordata (StationId, SensorId, SensorReading, ReadingUnit, ReadingDateTime)" +"values" + "('" + entity.getStationId()+"'"+"," +"'" + entity.getSensorId()+"'"
		+"," + "'" +entity.getSensorReading()+"'"+","+ "'"+ entity.getReadingUnit()+ "'"+ "," +"'"+ dateString+"'"+")";
		Statement stm = (Statement) conn.createStatement();
		System.out.println(sql);
		
		int count = stm.executeUpdate(sql);
		boolean inserted = false;
		if(count >0) {
			inserted = true;
		}
		return inserted;
	}
	
	/**
	 * updates a row in the sensordata table
	 */
	public void update(SensorData entity) throws SQLException {
		//UPDATE sensordata SET ReadingUnit ='F' WHERE id = 1;
		String sql = "update sensordata set ReadingUnit = 'F' where id =" + entity.getiD();
		Statement stm = (Statement) conn.createStatement();
		stm.executeUpdate(sql);	
	}
	
	/**
	 * deletes a row in the sensordata table
	 * @param entity
	 * @throws SQLException
	 */
	public void delete(SensorData entity) throws SQLException {
		//delete from sensordata where id = 2;
		String sql = "delete from sensordata where id ="+ entity.getiD();
		Statement stm = (Statement) conn.createStatement();
		stm.executeUpdate(sql);	
	}
	/**
	 * select all wind speed data from sensordata table
	 * @throws SQLException 
	 */
	public void selectAllWindspeedDataFromSensorData() throws SQLException {
		Statement st = (Statement) conn.createStatement();
		String sql;
		sql = "select * from sensordata where SensorId = 'WS'";
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			String sensorReading = rs.getString("SensorReading");
			Date dateTime = rs.getDate("ReadingDateTime");
			long timeStamp =  dateTime.getTime();
			String daTime = dateTime.toString();
			System.out.println("Wind Sensor Reading:" + sensorReading + "   Date Time:" + daTime + timeStamp );
		}
	}
	
	public static void main(String args[]) {
		SensorDataWrapper sdw = new SensorDataWrapper();
		try {
			sdw.selectAllWindspeedDataFromSensorData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
