package com.weltec.flad.wrapper;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

import com.weltec.flad.entity.SensorData;

public class SensorDataWrapperTest {

	private int rowNumber = 0;
	
	@Test
	public void test() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSensorDataWrapperInstance() {
		SensorDataWrapper sdw = new SensorDataWrapper();
		assertNotNull(sdw);
	}
	
	@Test
	public void testSensorDataWrapperInsert() {
		SensorDataWrapper sdw = new SensorDataWrapper();
		assertNotNull(sdw);
		SensorData sd  = this.createInstance();
		assertNotNull(sd);
		try {
			assertTrue(sdw.insert(sd));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSensorDataWrapperSelect() {
		SensorDataWrapper sdw = new SensorDataWrapper();
		assertNotNull(sdw);
		try {
			SensorData ad = sdw.select(100);
			assertEqual(100, ad.getiD());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	

	private void assertEqual(int i, int getiD) {
		// TODO Auto-generated method stub
		
	}

	
	@Test
	public void testSensorDataWrapperUpdate() {
		
	}
	
		
	@Test
	public void testSensorDataWrapperSelectAll() {
		SensorDataWrapper sdw = new SensorDataWrapper();
		try {
			assertNotNull(sdw.selectAll());
			
			SensorData[] array = sdw.selectAll();
			assertNotNull(array);
			
			assertNotTrue(array.length>0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void assertNotTrue(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testSensorDataWrapperDelete() {
		SensorDataWrapper sdw = new SensorDataWrapper();
		assertNotNull(sdw);
		SensorData entity = this.createInstance();
		try {
			sdw.delete(entity);
			SensorData sd =  sdw.select(entity.getiD());
			assertNull(sd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public SensorData createInstance() {
		SensorData sd = new SensorData();
		sd.setSensorId("T");
		sd.setStationId("1");
		sd.setSensorReading("9999.993");
		sd.setReadingUnit("9");
		
		Date dNow = new Date( );
//	    SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
//	    System.out.println("Current Date: " + ft.format(dNow));
//	    String startDateString = ft.format(dNow);

        // Convert from String to Date
//        try {
//			Date startDate = ft. df.parse(startDateString);
		sd.setReadingDateTime(dNow);
			
//		} catch (ParseException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}


		return sd;
	}
}
