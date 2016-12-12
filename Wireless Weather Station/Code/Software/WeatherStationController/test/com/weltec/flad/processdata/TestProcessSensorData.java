package com.weltec.flad.processdata;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;

import org.junit.Test;

import com.weltec.flad.entity.SensorData;

public class TestProcessSensorData {

	@Test
	public void test() {
		//fail("Not yet implemented");
	}
	
	@Test
	public void testProcessSensorData() {
		
		String data = "2016-08-27 7:30:30#1#H,44.96,%#T,18.77,C#P,98414.00,Pa#TP,64.74,F#L,0.57,V#V,4.51,V"; 
		
		ProcessSensorData psd = new ProcessSensorData();
		assertNotNull(psd);
				
		try {
			int count =  psd.processData(data);
			assertTrue(count>0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

