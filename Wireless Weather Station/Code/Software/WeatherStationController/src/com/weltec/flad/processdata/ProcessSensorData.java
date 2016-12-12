package com.weltec.flad.processdata;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import com.weltec.flad.entity.AverageSensorData;
import com.weltec.flad.entity.SensorData;
import com.weltec.flad.wrapper.AverageSensorDataWrapper;
import com.weltec.flad.wrapper.SensorDataWrapper;

/**
 * ProcessData class processes data.
 * @author N
 *
 */
public class ProcessSensorData {
	
	private SensorDataWrapper sdw;
	
	private String completeData;
	private String stationId;
	private Date startDate;
	int total = 0;
	int count = 0;
	
	/**
	 * Default constructor
	 */
	public ProcessSensorData() {
		sdw = new SensorDataWrapper();
	}
	
	/**
	 * Processes the data, put the date string to the data string.
	 * @param data
	 * @return 
	 * @return 
	 * @throws ParseException 
	 */
	public 	int processData(String data) throws Exception {
		
		completeData  = data;
		int dataCount = 0;
		
		String[] data1 = completeData.split("#");
			
		for(int i = 0; i<data1.length;i++) {
			
			if(i == 0) {
				String sDate = data1[i];
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); //String converted to Date
			    startDate = df.parse(sDate);
			    
			} else if(i==1) {
				stationId = data1[i];
				
			} else {
				
				SensorData sd = new SensorData();
				
				String weatherData = data1[i];
				sd.setStationId(stationId);
				sd.setReadingDateTime(startDate);
				String[] weatherDataArray = weatherData.split(",");
				
				for(int m = 0; m<weatherDataArray.length;m++) {
					if(m==0) {
						sd.setSensorId(weatherDataArray[m]);
					} else if(m==1) {
						sd.setSensorReading(weatherDataArray[m]);
					} else if(m==2) {
						sd.setReadingUnit(weatherDataArray[m]);
					}
				}
				dataCount++;
				System.out.println("** "+sd.toString());	//3rd sys out			
				this.insertDataToTheTable(sd);
				
				//an instance of AvereageSensorDatawrapper
				AverageSensorDataWrapper asdw = new AverageSensorDataWrapper();
				asdw.insertDataToAverageSensorDataTable(sd);
			}
		}
		return dataCount;
	}
	
	private void insertDataToTheTable(SensorData entity) throws SQLException {
		try {
			sdw.insert(entity);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
