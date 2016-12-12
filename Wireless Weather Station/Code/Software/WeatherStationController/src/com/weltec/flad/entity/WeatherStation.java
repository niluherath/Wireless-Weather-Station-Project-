package com.weltec.flad.entity;

/**
 * FlightAdvice
 * @author Nilu Herath
 * Date: 20/08/2016
 * Student ID number:2140367
 * Wellington Institute of Technology
 * 
 * WeatherStation class represents a weather station. This class represents a row in the WeatherStation table. Has attributes stationId, stationName, 
 * locationAddress and gPsCoordinate.
 */

public class WeatherStation {

	// Instance variables
	private String stationId;
	private String stationName;
	private String locationAddress;
	private String gPsCoordinate;
	
	/**
	 * Default constructor
	 */
	public WeatherStation() {
	}

	/**
	 * @return the stationId
	 */
	public String getStationId() {
		return stationId;
	}

	/**
	 * @param stationId the stationId to set
	 */
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	/**
	 * @return the stationName
	 */
	public String getStationName() {
		return stationName;
	}

	/**
	 * @param stationName the stationName to set
	 */
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	/**
	 * @return the locationAddress
	 */
	public String getLocationAddress() {
		return locationAddress;
	}

	/**
	 * @param locationAddress the locationAddress to set
	 */
	public void setLocationAddress(String locationAddress) {
		this.locationAddress = locationAddress;
	}

	/**
	 * @return the gPsCoordinate
	 */
	public String getgPsCoordinate() {
		return gPsCoordinate;
	}

	/**
	 * @param gPsCoordinate the gPsCoordinate to set
	 */
	public void setgPsCoordinate(String gPsCoordinate) {
		this.gPsCoordinate = gPsCoordinate;
	}
	
	
	
	
	
}
