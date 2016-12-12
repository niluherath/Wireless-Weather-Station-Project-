package com.weltec.flad.entity;

import java.util.Date;

/**
 * FlightAdvice
 * @author Nilu Herath
 * Date: 20/08/2016
 * Student ID number:2140367
 * Wellington Institute of Technology
 * 
 * SensorData class represents a row in the sensor data table.Has attributes iD, stationId, sensorReading, readingUnit and readingDateTime..
 */

public class SensorData {
	
	private int iD;
	private String stationId;
	private String sensorId;
	private String sensorReading;
	private String readingUnit;
	private Date readingDateTime;
	/**
	 * @return the sensorId
	 */
	public String getSensorId() {
		return sensorId;
	}

	/**
	 * @param sensorId the sensorId to set
	 */
	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SensorData [iD=" + iD + ", stationId=" + stationId + ", sensorId=" + sensorId + ", sensorReading="
				+ sensorReading + ", readingUnit=" + readingUnit + ", readingDateTime=" + readingDateTime + "]";
	}

	/**
	 * Default constructor
	 */
	public SensorData() {
	}
	
	/**
	 * @return the iD
	 */
	public int getiD() {
		return iD;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setiD(int iD) {
		this.iD = iD;
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
	 * @return the sensorReading
	 */
	public String getSensorReading() {
		return sensorReading;
	}
	/**
	 * @param sensorReading the sensorReading to set
	 */
	public void setSensorReading(String sensorReading) {
		this.sensorReading = sensorReading;
	}
	/**
	 * @return the readingUnit
	 */
	public String getReadingUnit() {
		return readingUnit;
	}
	/**
	 * @param readingUnit the readingUnit to set
	 */
	public void setReadingUnit(String readingUnit) {
		this.readingUnit = readingUnit;
	}
	/**
	 * @return the readingDateTime
	 */
	public Date getReadingDateTime() {
		return readingDateTime;
	}
	/**
	 * @param readingDateTime the readingDateTime to set
	 */
	public void setReadingDateTime(Date readingDateTime) {
		this.readingDateTime = readingDateTime;
	}
}
