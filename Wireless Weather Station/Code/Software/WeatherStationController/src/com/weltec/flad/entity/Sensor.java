package com.weltec.flad.entity;
/**
 * FlightAdvice
 * @author Nilu Herath
 * Date: 20/08/2016
 * Student ID number:2140367
 * Wellington Institute of Technology
 * 
 * Sensor class represents a sensor.Each sensor has attributes sensorId, sensorName and productUsed.
 */

public class Sensor {
	
	private String sensorId;
	private String sensorName;
	private String productUsed;
	
	/**
	 * Default constructor
	 */
	public Sensor() {
	}
	
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
	/**
	 * @return the sensorName
	 */
	public String getSensorName() {
		return sensorName;
	}
	/**
	 * @param sensorName the sensorName to set
	 */
	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}
	/**
	 * @return the productUsed
	 */
	public String getProductUsed() {
		return productUsed;
	}
	/**
	 * @param productUsed the productUsed to set
	 */
	public void setProductUsed(String productUsed) {
		this.productUsed = productUsed;
	}
}
