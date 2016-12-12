package com.weltec.flad.wrapper;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
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
 * WeatherStationWrapper class reads data from the weatherstation table.
 */
public class WeatherStationWrapper {
	
	private Connection conn;
	
	/**
	 * Default constructor.Gets a data base connection.
	 * @throws SQLException 
	 */
	public WeatherStationWrapper() throws SQLException {
		DBConnection  db = DBConnection.getInstance();
		conn = db.getDatabaseConnection();
	}
	
	/**
	 * selects a row in the weatherstation table in the database.
	 * @param weatherStationId to be selected.
	 * @return weatherstation instance.
	 * @throws SQLException 
	 */
	public WeatherStation select(String weatherStationId) throws SQLException {
		String sql = "select * from weatherstation where StationId = '" + weatherStationId + "'";
		Statement selectStatement = (Statement) conn.createStatement();
		ResultSet rs = selectStatement.executeQuery(sql);
		WeatherStation sw = null;
		while(rs.next()) {
			sw = new WeatherStation();
			sw.setStationId(rs.getString("StationId"));
			sw.setStationName(rs.getString("StationName"));
			sw.setLocationAddress(rs.getString("LocationAddress"));
			sw.setgPsCoordinate(rs.getString("GPSCordinate"));
			break;
		}		
		return sw;
	}
	
	/**
	 * inserts a row into the weatherstation table in the database.
	 * @param entity weatherstation entity to be inserted.
	 * @return 
	 * @throws SQLException
	 */
	public boolean insert(WeatherStation entity) throws SQLException {
		String stationId = entity.getStationId();
		String stationName = entity.getStationName();
		String locationaddress = entity.getLocationAddress();
		String gpsCoordinate = entity.getgPsCoordinate();
		
		String sql = "INSERT INTO weatherstation (StationId, StationName, LocationAddress, GPSCordinate) VALUES ("+ "'" + stationId+"'"+ ","+
		"'"+ stationName +"'"+ "," + "'" + locationaddress +"'" + "," +"''"+ ")";
		
		boolean inserted = false;
		
		Statement selectStatement = (Statement) conn.createStatement();
		int rowCount = selectStatement.executeUpdate(sql);
		if(rowCount >0)
		{
			inserted = true;
			
		}
		return inserted;
		
		
	}
	
	/**
	 * 
	 * @param entity
	 * @return 
	 * @throws SQLException
	 */
	public boolean update(WeatherStation entity) throws SQLException {
		String stationId = entity.getStationId();
		String stationName = entity.getStationName();
		String locationaddress = entity.getLocationAddress();
		String gpsCoordinate = entity.getgPsCoordinate();
				
		//String sql = "UPDATE weatherstation SET LocationAddress ='Petone' WHERE StationId ='1'"; 
		String sql = "UPDATE weatherstation SET StationName =" + "'" + stationName + "'"+ "," + "LocationAddress =" + "'" + locationaddress+"'"+ "," +
					"GPSCordinate =" + "'" + gpsCoordinate + "'" + " WHERE StationId =" +"'" +stationId + "'"; 
		
		System.out.println(sql);
		
		Statement selectStatement = (Statement) conn.createStatement();
		int rowCount = selectStatement.executeUpdate(sql);
		boolean updated = false;
		
		if(rowCount > 0) {
			updated = true;
		}
		return updated;
		
	}
	
	/**
	 * deletes a row from the weatherstation table.
	 * @param entity
	 * @return 
	 * @throws SQLException
	 */
	public boolean delete(WeatherStation entity) throws SQLException {	
		
		String sql = "DELETE FROM weatherstation WHERE StationId = "
		+ "'" + entity.getStationId() +"'";
		System.out.println(sql);
		Statement selectStatement = (Statement) conn.createStatement();
		int rowCount = selectStatement.executeUpdate(sql);
		boolean deleted = false;
		
		if(rowCount > 0) {
			deleted = true;
		}
		return deleted;
		
		
	}
	
	public WeatherStation[] selectAll() throws SQLException {
		
		String sql = "select * from weatherstation";
		Statement selectStatement = (Statement) conn.createStatement();
		ResultSet rs = selectStatement.executeQuery(sql);
		WeatherStation[] array;
		ArrayList<WeatherStation> list = new ArrayList<WeatherStation>();

		while(rs.next()) {
			 
			WeatherStation sw = new WeatherStation();
			sw.setStationId(rs.getString("StationId"));
			sw.setStationName(rs.getString("StationName"));
			sw.setLocationAddress(rs.getString("LocationAddress"));
			sw.setgPsCoordinate(rs.getString("GPSCordinate"));
			list.add(sw);
		}
	
		WeatherStation[] wsArray = list.toArray(new WeatherStation[list.size()]);
		return wsArray;
	}
	
	
	
	/**
	 * reads all the rows from the weatherstation table.
	 * @throws SQLException 
	 */
	public void read() throws SQLException {
		String sql = "select * from weatherstation";
		Statement st = (Statement) conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		WeatherStation sw = null;
		while(rs.next()) {
			sw = new WeatherStation();
			sw.setStationId(rs.getString("StationId"));
			sw.setStationName(rs.getString("StationName"));
			sw.setLocationAddress(rs.getString("LocationAddress"));
			sw.setgPsCoordinate(rs.getString("GPSCordinate"));
			System.out.println("StationId: " + sw.getStationId() + "Station name" + sw.getStationName() + "Location Adress" + sw.getLocationAddress() + 
					"GPSCordination" + sw.getgPsCoordinate());
		}
	 
	}
	
	public static void main(String[]args) {
		WeatherStationWrapper wwr;
		try {
			wwr = new WeatherStationWrapper();
			
			WeatherStation ws = new WeatherStation();
			ws.setStationId("7");
			ws.setStationName("wireless four");
			ws.setLocationAddress("Johnsonville");
			ws.setgPsCoordinate("");
			
			wwr.update(ws);
			
			wwr.delete(ws);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
