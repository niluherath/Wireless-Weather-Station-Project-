package com.weltec.flad.wrapper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.weltec.flad.entity.AverageSensorData;

public class TestTime {

	public static void main(String[]rags) throws ParseException {
		
		
		
	    // myDate is the java.util.Date in yyyy-mm-dd format
	    // Converting it into String using formatter
	   //String strDate = sm.format(myDate);
	    //Converting the String back to java.util.Date
	   // Date dt = sm.parse(strDate);
		
		Date date = new Date();
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-mm-dd");
	    String d = sm.format(date);
		
		String dateTime  = d.toString();
		System.out.println(dateTime);
		String[] dattimeArray = dateTime.split("-");
		
		//AverageSensorData asd = new AverageSensorData();
		//asd.setReadingDate(date);//set the date in the average sensor data table
		
		String time = dattimeArray[1];
		String[] timeArray = time.split(":");
		String hhour = timeArray[0];
		System.out.println(hhour);
		//asd.setReadingHour(Integer.valueOf(hhour));//set the hour in the average sensor data table
		String minute = timeArray[1];
		Float min = Float.parseFloat(minute);//converting String into minutes
		System.out.println(min);
		

	}

}
