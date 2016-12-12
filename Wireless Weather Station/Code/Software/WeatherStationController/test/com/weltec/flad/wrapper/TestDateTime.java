package com.weltec.flad.wrapper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateTime {
	
	public static void main(String[] args) {
		Date dNow = new Date( );
	    SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss ");
	    System.out.println("Current Date: " + ft.format(dNow));
	
	    String startDateString = ft.format(dNow);

        // This object can interpret strings representing dates in the format MM/dd/yyyy
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 

        // Convert from String to Date
        try {
			Date startDate = df.parse(startDateString);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
}
