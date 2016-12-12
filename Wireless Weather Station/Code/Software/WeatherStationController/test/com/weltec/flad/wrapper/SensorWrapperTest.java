package com.weltec.flad.wrapper;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.weltec.flad.entity.Sensor;

public class SensorWrapperTest {
	@Test
	public void testSensorWrapperInstance() {
		try {
			SensorWrapper sw = new SensorWrapper();
			assertNotNull(sw);
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testSensorWrapperInsert() {
		SensorWrapper sw;
		try {
			sw = new SensorWrapper();
			assertNotNull(sw);
			Sensor entity = this.createInstance();
			assertNotNull(entity);
			assertTrue(sw.insert(entity));
			
			Sensor sensor1 = sw.select(entity.getSensorId());
			assertEquals(entity.getSensorId(), sensor1.getSensorId());
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSensorWrapperSelect() {
		try {
			SensorWrapper sw = new SensorWrapper();
			assertNotNull(sw);
			
			Sensor entity = this.createInstance();
			assertNotNull(entity);
			
			Sensor sensor2 = sw.select(entity.getSensorId());
			
			assertEquals(entity.getSensorId(), sensor2.getSensorId());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//	@Test
	//public void testSensorUpdate() {
	//	SensorWrapper sw;
		//try {
		//	sw = new SensorWrapper();
		//	assertNotNull(sw);
		//	Sensor entity = this.createInstance();
		//	assertNotNull(entity);
		//	entity.setSensorName("Temeprature F");
		//	sw.update(entity);
			
		//	Sensor sensor4 = sw.select(entity.getSensorId());
			
			//assertEquals(entity.getSensorName(), sensor4.getSensorName());
	//	} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		
	//}
	
	public void testSelectAll() {
		SensorWrapper sw;
		try {
			sw = new SensorWrapper();
			Sensor[] sArray = sw.selectAll();
			assertNotNull(sArray);
			
			assertTrue(sArray.length>0);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testDeleteTest() {
		SensorWrapper sw;
		try {
			sw = new SensorWrapper();
			assertNotNull(sw);
			Sensor entity = this.createInstance();
			assertNotNull(entity);
			sw.delete(entity);
			
			assertNull(sw.select(entity.getSensorId()));
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private Sensor createInstance() {
		Sensor sensor = new Sensor();
		sensor.setSensorId("Z");
		sensor.setSensorName("Dummy Sensor");
		sensor.setProductUsed("Sparkfun");
		
		return sensor;
		
	}
	
	
}
