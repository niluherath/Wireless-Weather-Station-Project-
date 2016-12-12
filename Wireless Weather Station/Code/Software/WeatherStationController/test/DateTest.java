import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateTest {

	@Test
	public void testUtilDate() {
		
		Date myDate = new Date();  // genererid date replresentation
		
		System.out.println("Util Date: "+myDate);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		String dateString = df.format(myDate);
		System.out.println("DateString: "+dateString);
		
		SimpleDateFormat df2 = new SimpleDateFormat("hh:mm:ss");
		String dateString2 = df2.format(myDate);
		System.out.println("DateString2: "+dateString2);
		
		SimpleDateFormat df3 = new SimpleDateFormat("dd");
		String dateString3 = df3.format(myDate);
		System.out.println("DateString3: "+dateString3);

		
	}

}
