package com.weltec.flad.wrapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mysql.jdbc.Statement;
import com.weltec.flad.entity.AverageSensorData;
import com.weltec.flad.entity.SensorData;
import com.weltec.flad.util.DBConnection;

public class AverageSensorDataWrapper {
	
	private Connection conn;
	
	/**
	 * Constructor, gets a database connection
	 * @throws SQLException 
	 */
	public AverageSensorDataWrapper() throws SQLException {
		DBConnection db= DBConnection.getInstance();
		conn = db.getDatabaseConnection();
	}
	
	/**
	 * select method selects a row in the averagesensordata table.
	 * @throws SQLException 
	 */
	private AverageSensorData select(String stationId, String sensorId, String readingDate, int hour) throws SQLException {
		
		String sql = "select * from averagesensordata where SensorId = "+"'"+sensorId+"'"+" and StationId = "+"'"+stationId+"'"+"and ReadingDate = "+"'"+readingDate+"'"+
		"and ReadingHour = "+ hour;
		
		Statement st =  (Statement) conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		AverageSensorData asd = null;
		
		while( rs.next()){
			asd = new AverageSensorData();
			
			asd.setStationId(rs.getString("StationId"));
			asd.setSensorId(rs.getString("SensorId"));
			asd.setReadingDate(rs.getDate("ReadingDate"));
			asd.setReadingHour(rs.getInt("ReadingHour"));

			asd.setSlot1Count(rs.getInt("Slot1Count"));
			asd.setSlot2Count(rs.getInt("Slot2Count"));
			asd.setSlot3Count(rs.getInt("Slot3Count"));
			asd.setSlot4Count(rs.getInt("Slot4Count"));
			asd.setSlot5Count(rs.getInt("Slot5Count"));
			asd.setSlot6Count(rs.getInt("Slot6Count"));
			asd.setSlot7Count(rs.getInt("Slot7Count"));
			asd.setSlot8Count(rs.getInt("Slot8Count"));
			asd.setSlot9Count(rs.getInt("Slot9Count"));
			asd.setSlot10Count(rs.getInt("Slot10Count"));
			asd.setSlot11Count(rs.getInt("Slot11Count"));
			asd.setSlot12Count(rs.getInt("Slot12Count"));
			
			asd.setSlot1Total(rs.getString("Slot1Total"));
			asd.setSlot2Total(rs.getString("Slot2Total"));
			asd.setSlot3Total(rs.getString("Slot3Total"));
			asd.setSlot4Total(rs.getString("Slot4Total"));
			asd.setSlot5Total(rs.getString("Slot5Total"));
			asd.setSlot6Total(rs.getString("Slot6Total"));
			asd.setSlot7Total(rs.getString("Slot7Total"));
			asd.setSlot8Total(rs.getString("Slot8Total"));
			asd.setSlot9Total(rs.getString("Slot9Total"));
			asd.setSlot10Total(rs.getString("Slot10Total"));
			asd.setSlot11Total(rs.getString("Slot11Total"));
			asd.setSlot12Total(rs.getString("Slot12Total"));

			asd.setSlot1Average(rs.getString("Slot1Average"));
			asd.setSlot2Average(rs.getString("Slot2Average"));
			asd.setSlot3Average(rs.getString("Slot3Average"));
			asd.setSlot4Average(rs.getString("Slot4Average"));
			asd.setSlot5Average(rs.getString("Slot5Average"));
			asd.setSlot6Average(rs.getString("Slot6Average"));
			asd.setSlot7Average(rs.getString("Slot7Average"));
			asd.setSlot8Average(rs.getString("Slot8Average"));
			asd.setSlot9Average(rs.getString("Slot9Average"));
			asd.setSlot10Average(rs.getString("Slot10Average"));
			asd.setSlot11Average(rs.getString("Slot11Average"));
			asd.setSlot12Average(rs.getString("Slot12Average"));
			
		}
		return asd;
	}

	private boolean update(AverageSensorData asd) throws SQLException {
		Statement st = (Statement) conn.createStatement();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateWithoutTimeString = sdf.format(asd.getReadingDate());
		
		String sql1 = "update averagesensordata set "
				+ "Slot1Count="+asd.getSlot1Count()+",Slot1Total='"+asd.getSlot1Total()+"',Slot1Average='"+asd.getSlot1Average()+"',"
				+ "Slot2Count="+asd.getSlot2Count()+",Slot2Total='"+asd.getSlot2Total()+"',Slot2Average='"+asd.getSlot2Average()+"',"
				+ "Slot3Count="+asd.getSlot3Count()+",Slot3Total='"+asd.getSlot3Total()+"',Slot3Average='"+asd.getSlot3Average()+"',"
				+ "Slot4Count="+asd.getSlot4Count()+",Slot4Total='"+asd.getSlot4Total()+"',Slot4Average='"+asd.getSlot4Average()+"',"
				+ "Slot5Count="+asd.getSlot5Count()+",Slot5Total='"+asd.getSlot5Total()+"',Slot5Average='"+asd.getSlot5Average()+"',"
				+ "Slot6Count="+asd.getSlot6Count()+",Slot6Total='"+asd.getSlot6Total()+"',Slot6Average='"+asd.getSlot6Average()+"',"
				+ "Slot7Count="+asd.getSlot7Count()+",Slot7Total='"+asd.getSlot7Total()+"',Slot7Average='"+asd.getSlot7Average()+"',"
				+ "Slot8Count="+asd.getSlot8Count()+",Slot8Total='"+asd.getSlot8Total()+"',Slot8Average='"+asd.getSlot8Average()+"',"
				+ "Slot9Count="+asd.getSlot9Count()+",Slot9Total='"+asd.getSlot9Total()+"',Slot9Average='"+asd.getSlot9Average()+"',"
				+ "Slot10Count="+asd.getSlot10Count()+",Slot10Total='"+asd.getSlot10Total()+"',Slot10Average='"+asd.getSlot10Average()+"',"
				+ "Slot11Count="+asd.getSlot11Count()+",Slot11Total='"+asd.getSlot11Total()+"',Slot11Average='"+asd.getSlot11Average()+"',"
				+ "Slot12Count="+asd.getSlot12Count()+",Slot12Total='"+asd.getSlot12Total()+"',Slot12Average='"+asd.getSlot12Average()+"'"
				+" where StationId='"+asd.getStationId()+"' and SensorId='"+asd.getSensorId()+"' and ReadingDate='"+dateWithoutTimeString+"' and ReadingHour ="+asd.getReadingHour();
		System.out.println("##############"+sql1);
		int update = st.executeUpdate(sql1);
		
		return (update>0);
	}
	
	/**
	 * Inserts data into averagesensordata table.
	 * @param entity
	 * @throws ParseException
	 * @throws SQLException 
	 */
	public void insertDataToAverageSensorDataTable(SensorData entity) throws ParseException, SQLException {

		// WS, WG, T to be average
		if ( !(entity.getSensorId().equals("T") 
				|| entity.getSensorId().equals("WS") 
				|| entity.getSensorId().equals("WG")
				|| entity.getSensorId().equals("H")
				)) {
			return;
		}
		
		Date datTime = entity.getReadingDateTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//date
		String dateWithoutTimeString = sdf.format(datTime);
		System.out.println("dateWithoutTimeString: "+dateWithoutTimeString);
		
		SimpleDateFormat sdfHour = new SimpleDateFormat("hh");//hour
		String hour = sdfHour.format(datTime);
		int iHour = Integer.parseInt(hour);
		
		SimpleDateFormat sdfMin = new SimpleDateFormat("mm");
		String fMinmin = sdfMin.format(datTime);
		int min = Integer.parseInt(fMinmin);
		System.out.println(fMinmin+" "+min);
		
		Statement st = (Statement) conn.createStatement();
		//if null insert the data
		
		AverageSensorData asd = this.select(entity.getStationId(), entity.getSensorId(), dateWithoutTimeString, iHour);
		if (asd == null) {
			String sql = "insert into averagesensordata(StationId, SensorId, ReadingDate, ReadingHour)"
					+" values("+ "'"+entity.getStationId()+"'"+","+"'"+entity.getSensorId() +"'"+","
					+"'"+dateWithoutTimeString+"'"+","+iHour+")";
			System.out.println("av insert..........."+sql);
			st.executeUpdate(sql);	
			asd = this.select(entity.getStationId(), entity.getSensorId(), dateWithoutTimeString, iHour);
		}
		
		int count;
		float total;
		float avg;
				
		if(min >=0 && min <5) {
			count = asd.getSlot1Count() + 1;// add to the count
			total = Float.parseFloat(asd.getSlot1Total()) + Float.parseFloat(entity.getSensorReading());//add to the total
			avg = total/count;//find average
			
			asd.setSlot1Count(count);//set the count each time
			asd.setSlot1Total(Float.toString(total));//set the total each time
			asd.setSlot1Average(Float.toString(avg));//set the average each time
			
			this.update(asd);//then update the average sensor data table
		} else if(min >=5 && min <10) {
			count = asd.getSlot2Count() + 1;
			total = Float.parseFloat(asd.getSlot2Total()) + Float.parseFloat(entity.getSensorReading());
			avg = total/count;
			
			asd.setSlot2Count(count);
			asd.setSlot2Total(Float.toString(total));
			asd.setSlot2Average(Float.toString(avg));
			
			this.update(asd);
		} else if(min >=10 && min <15) {
			count = asd.getSlot3Count() + 1;
			total = Float.parseFloat(asd.getSlot3Total()) + Float.parseFloat(entity.getSensorReading());
			avg = total/count;
			
			asd.setSlot3Count(count);
			asd.setSlot3Total(Float.toString(total));
			asd.setSlot3Average(Float.toString(avg));
			
			this.update(asd);
		} else if(min >=15 && min <20) {
			count = asd.getSlot4Count() + 1;
			total = Float.parseFloat(asd.getSlot4Total()) + Float.parseFloat(entity.getSensorReading());
			avg = total/count;
			
			asd.setSlot4Count(count);
			asd.setSlot4Total(Float.toString(total));
			asd.setSlot4Average(Float.toString(avg));
			
			this.update(asd);
		} else if(min >=20 && min <25) {
			count = asd.getSlot5Count() + 1;
			total = Float.parseFloat(asd.getSlot5Total()) + Float.parseFloat(entity.getSensorReading());
			avg = total/count;
			
			asd.setSlot5Count(count);
			asd.setSlot5Total(Float.toString(total));
			asd.setSlot5Average(Float.toString(avg));
			
			this.update(asd);
		} else if(min >=25 && min <30) {
			count = asd.getSlot6Count() + 1;
			total = Float.parseFloat(asd.getSlot6Total()) + Float.parseFloat(entity.getSensorReading());
			avg = total/count;
			
			asd.setSlot6Count(count);
			asd.setSlot6Total(Float.toString(total));
			asd.setSlot6Average(Float.toString(avg));
			
			this.update(asd);
		} else if(min >=30 && min <35) {
			count = asd.getSlot7Count() + 1;
			total = Float.parseFloat(asd.getSlot7Total()) + Float.parseFloat(entity.getSensorReading());
			avg = total/count;
			
			asd.setSlot7Count(count);
			asd.setSlot7Total(Float.toString(total));
			asd.setSlot7Average(Float.toString(avg));
			
			this.update(asd);
		} else if(min >=35 && min <40) {
			count = asd.getSlot8Count() + 1;
			total = Float.parseFloat(asd.getSlot8Total()) + Float.parseFloat(entity.getSensorReading());
			avg = total/count;
			
			asd.setSlot8Count(count);
			asd.setSlot8Total(Float.toString(total));
			asd.setSlot8Average(Float.toString(avg));
			
			this.update(asd);
		} else if(min >=40 && min <45) {
			count = asd.getSlot9Count() + 1;
			total = Float.parseFloat(asd.getSlot9Total()) + Float.parseFloat(entity.getSensorReading());
			avg = total/count;
			
			asd.setSlot9Count(count);
			asd.setSlot9Total(Float.toString(total));
			asd.setSlot9Average(Float.toString(avg));
			
			this.update(asd);
		} else if(min >=45 && min <50) {
			count = asd.getSlot10Count() + 1;
			total = Float.parseFloat(asd.getSlot10Total()) + Float.parseFloat(entity.getSensorReading());
			avg = total/count;
			
			asd.setSlot10Count(count);
			asd.setSlot10Total(Float.toString(total));
			asd.setSlot10Average(Float.toString(avg));
			
			this.update(asd);
		} else if(min >=50 && min <55) {
			count = asd.getSlot11Count() + 1;
			total = Float.parseFloat(asd.getSlot11Total()) + Float.parseFloat(entity.getSensorReading());
			avg = total/count;
			
			asd.setSlot11Count(count);
			asd.setSlot11Total(Float.toString(total));
			asd.setSlot11Average(Float.toString(avg));
			
			this.update(asd);
		} else if(min >=55 && min <60) {
			count = asd.getSlot12Count() + 1;
			total = Float.parseFloat(asd.getSlot12Total()) + Float.parseFloat(entity.getSensorReading());
			avg = total/count;
			
			asd.setSlot12Count(count);
			asd.setSlot12Total(Float.toString(total));
			asd.setSlot12Average(Float.toString(avg));
			
			this.update(asd);
		}

	}
	
	
	
	public static void main(String[] args) throws Exception {
		AverageSensorDataWrapper avw = new AverageSensorDataWrapper();
		
		SensorData sdT = new SensorData();
		sdT.setStationId("1");
		sdT.setSensorId("T");
		sdT.setReadingDateTime(new Date());
		sdT.setReadingUnit("C");
		sdT.setSensorReading("12.5");
		
		for (int i=0; i<10; i++) {
			avw.insertDataToAverageSensorDataTable(sdT);
		}
		
		SensorData sdWS = new SensorData();
		sdWS.setStationId("1");
		sdWS.setSensorId("WS");
		sdWS.setReadingDateTime(new Date());
		sdWS.setReadingUnit("Kmh");
		sdWS.setSensorReading("20.5");
		
		for (int i=0; i<10; i++) {
			avw.insertDataToAverageSensorDataTable(sdWS);
		}
		
		SensorData sdWG = new SensorData();
		sdWG.setStationId("1");
		sdWG.setSensorId("WG");
		sdWG.setReadingDateTime(new Date());
		sdWG.setReadingUnit("Kmh");
		sdWG.setSensorReading("23.5");
		
		for (int i=0; i<10; i++) {
			avw.insertDataToAverageSensorDataTable(sdWG);
		}
	
	}
	
}
