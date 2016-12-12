<?php

$servername = "localhost";
$username = "root";
$password = "";

$conn = mysqli_connect($servername, $username, $password, "flightadvice");

$sql = "SELECT * from averagesensordata where sensorid='WS' order by ReadingDate desc limit 2;";
$result = $conn->query($sql);

if ($result->num_rows > 0) {

	$rowCount = 1;

     // output data of each row
     while($row = $result->fetch_assoc()) {
   		$StationId = $row["StationId"];
	    $SensorId = $row["SensorId"];
     	if( $SensorId == "WS" && $StationId == "1" && $rowCount==1) {
	         $ReadingDate = $row["ReadingDate"];
	         $ReadingHour = $row["ReadingHour"];
	         $Slot1Average = $row["Slot1Average"];
	         $Slot2Average = $row["Slot2Average"];
	         $Slot3Average = $row["Slot3Average"];
	         $Slot4Average = $row["Slot4Average"];
	         $Slot5Average = $row["Slot5Average"];
	         $Slot6Average = $row["Slot6Average"];
	         $Slot7Average = $row["Slot7Average"];
	         $Slot8Average = $row["Slot8Average"];
	         $Slot9Average = $row["Slot9Average"];
	         $Slot10Average = $row["Slot10Average"];
	         $Slot11Average = $row["Slot11Average"];
	         $Slot12Average = $row["Slot12Average"];
     	}
     	if( $SensorId == "WS" && $StationId == "1" && $rowCount==2) {
	         $ReadingDate2 = $row["ReadingDate"];
	         $ReadingHour2 = $row["ReadingHour"];
	         $Slot1Average2 = $row["Slot1Average"];
	         $Slot2Average2 = $row["Slot2Average"];
	         $Slot3Average2 = $row["Slot3Average"];
	         $Slot4Average2 = $row["Slot4Average"];
	         $Slot5Average2 = $row["Slot5Average"];
	         $Slot6Average2 = $row["Slot6Average"];
	         $Slot7Average2 = $row["Slot7Average"];
	         $Slot8Average2 = $row["Slot8Average"];
	         $Slot9Average2 = $row["Slot9Average"];
	         $Slot10Average2 = $row["Slot10Average"];
	         $Slot11Average2 = $row["Slot11Average"];
	         $Slot12Average2 = $row["Slot12Average"];
     	}
		$rowCount++;
     }


} else {
     echo "0 results";
}

$conn->close();

# PHPlot Example: Simple line graph
require_once '/phplot-6.2.0/phplot.php';

$data = array(

  	// previous hour
//		array('', $ReadingHour2.'.00', $Slot1Average2),
//		array('', $ReadingHour2.'.05', $Slot2Average2),
//  	array('', $ReadingHour2.'.10', $Slot3Average2),
//  	array('', $ReadingHour2.'.15', $Slot4Average2),
//  	array('', $ReadingHour2.'.20', $Slot5Average2),
//  	array('', $ReadingHour2.'.25', $Slot6Average2),
//  	array('', $ReadingHour2.'.30', $Slot7Average2),
//  	array('', $ReadingHour2.'.35', $Slot8Average2),
//  	array('', $ReadingHour2.'.40', $Slot9Average2),
//  	array('', $ReadingHour2.'.45', $Slot10Average2),
//  	array('', $ReadingHour2.'.50', $Slot11Average2),
//  	array('', $ReadingHour2.'.55', $Slot12Average2),

	// current hour
	array('', $ReadingHour.'.00', $Slot1Average),
	array('', $ReadingHour.'.05', $Slot2Average),
  	array('', $ReadingHour.'.10', $Slot3Average),
  	array('', $ReadingHour.'.15', $Slot4Average),
  	array('', $ReadingHour.'.20', $Slot5Average),
  	array('', $ReadingHour.'.25', $Slot6Average),
  	array('', $ReadingHour.'.30', $Slot7Average),
  	array('', $ReadingHour.'.35', $Slot8Average),
  	array('', $ReadingHour.'.40', $Slot9Average),
  	array('', $ReadingHour.'.45', $Slot10Average),
  	array('', $ReadingHour.'.50', $Slot11Average),
  	array('', $ReadingHour.'.55', $Slot12Average),

);

$plot = new PHPlot(1300, 300);
$plot->SetImageBorderType('plain');

$plot->SetPlotType('thinbarline');
$plot->SetDataType('data-data');
$plot->SetDataValues($data);

# Main plot title:
$plot->SetTitle('Average Wind Speed Readings every hour:'.date("h:i:sa"));

# Make sure Y axis starts at 0:
$plot->SetPlotAreaWorld(NULL, 0, NULL, NULL);

$plot->DrawGraph();

?>



