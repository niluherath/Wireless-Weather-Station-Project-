package com.weltec.flad.wrapper;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.weltec.flad.entity.WeatherStation;

public class WeatherStationWrapperTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
	}

	@Test
	public void testWrapperInstance() {
		try {
			WeatherStationWrapper wrapper = new WeatherStationWrapper();
			assertNotNull(wrapper);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception Caught....");
		}
	}

	@Test
	public void testWrapperInsert() {
		try {
			WeatherStationWrapper wrapper = new WeatherStationWrapper();
			assertNotNull(wrapper);
			
			WeatherStation ws = this.createNewInstncae(); 
			assertNotNull(ws);
			
			assertTrue(wrapper.insert(ws));

			WeatherStation ws1 = wrapper.select("15");
			assertEquals("15", ws1.getStationId());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Exception caught.......");
		}
	}

	@Test
	public void testWrapperSelect() {
		try {
			WeatherStationWrapper wrapper = new WeatherStationWrapper();
			assertNotNull(wrapper);
			
			WeatherStation ws = wrapper.select("15");
			assertNotNull(ws);
			
			assertEquals("15", ws.getStationId());
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception Caught....");
		}
	}
	
	@Test
	public void testWrapperUpdate() {
		WeatherStationWrapper wrapper;
		try {
			wrapper = new WeatherStationWrapper();
			assertNotNull(wrapper);
			
			WeatherStation ws = wrapper.select("15");
			assertNotNull(ws);
			
			ws.setStationName("wireless six");
			ws.setLocationAddress("Napier");
			assertTrue(wrapper.update(ws));
			
			ws = wrapper.select("15");
			
			assertEquals("15", ws.getStationId());
			assertEquals("wireless six", ws.getStationName());
			assertEquals("Napier", ws.getLocationAddress());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Exception caught");
		}
	}
	
	public void testSelectAll() {
		WeatherStationWrapper wrapper;
		try {
			wrapper = new WeatherStationWrapper();
			assertNotNull(wrapper);
			
			WeatherStation[] array = wrapper.selectAll();
			assertNotNull(array);
			assertTrue(array.length > 0);
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testWrapperDelete() {
		WeatherStationWrapper wrapper;
		try {
			wrapper = new WeatherStationWrapper();
			assertNotNull(wrapper);
			
			WeatherStation ws = wrapper.select("15");
			assertTrue(wrapper.delete(ws));//delete
					
			assertNull(wrapper.select("15"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private WeatherStation createNewInstncae() {
		WeatherStation ws = new WeatherStation();
		ws.setStationId("15");
		ws.setStationName("wireless");
		ws.setLocationAddress("Porirua");
		ws.setgPsCoordinate("45.365527,8.613281");
		return ws;
	}

}
