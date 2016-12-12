<?php

$servername = "localhost";
$username = "root";
$password = "";

$conn = mysqli_connect($servername, $username, $password, "flightadvice");

$sql = "SELECT * from averagesensordata where stationid='1' and sensorid='T' order by id  desc limit 1;";
$result = $conn->query($sql);
$data = array();

if ($result->num_rows > 0) {

     // output data of each row
     while($row = $result->fetch_assoc()) {
   		$StationId = $row["StationId"];
	    $SensorId = $row["SensorId"];
     	if( $SensorId == "T" && $StationId == "1") {
	         $ReadingDate = $row["ReadingDate"];
	         $ReadingHour = $row["ReadingHour"];

	         $avg = $row["Slot1Average"];
	         $aavg = ($avg-32)/1.8;
	         $tempArr = array('', $ReadingHour.'.00', $aavg);
			 array_push($data, $tempArr);  // populates $data array

	         $avg = $row["Slot2Average"];
	         $aavg = ($avg-32)/1.8;
	         $tempArr = array('', $ReadingHour.'.05', $aavg);
			 array_push($data, $tempArr);  // populates $data array

	         $avg = $row["Slot3Average"];
	         $aavg = ($avg-32)/1.8;
	         $tempArr = array('', $ReadingHour.'.10', $aavg);
			 array_push($data, $tempArr);  // populates $data array

	         $avg = $row["Slot4Average"];
	         $aavg = ($avg-32)/1.8;
	         $tempArr = array('', $ReadingHour.'.15', $aavg);
			 array_push($data, $tempArr);  // populates $data array

	         $avg = $row["Slot5Average"];
	         $aavg = ($avg-32)/1.8;
	         $tempArr = array('', $ReadingHour.'.20', $aavg);
			 array_push($data, $tempArr);  // populates $data array

	         $avg = $row["Slot6Average"];
	         $aavg = ($avg-32)/1.8;
	         $tempArr = array('', $ReadingHour.'.25', $aavg);
			 array_push($data, $tempArr);  // populates $data array

	         $avg = $row["Slot7Average"];
	         $aavg = ($avg-32)/1.8;
	         $tempArr = array('', $ReadingHour.'.30', $aavg);
			 array_push($data, $tempArr);  // populates $data array

	         $avg = $row["Slot8Average"];
	         $aavg = ($avg-32)/1.8;
	         $tempArr = array('', $ReadingHour.'.35', $avg);
			 array_push($data, $tempArr);  // populates $data array

	         $avg = $row["Slot9Average"];
	         $tempArr = array('', $ReadingHour.'.40', $avg);
			 array_push($data, $tempArr);  // populates $data array

	         $avg = $row["Slot10Average"];
	         $aavg = ($avg-32)/1.8;
	         $tempArr = array('', $ReadingHour.'.45', $aavg);
			 array_push($data, $tempArr);  // populates $data array

	         $avg = $row["Slot11Average"];
	         $aavg = ($avg-32)/1.8;
	         $tempArr = array('', $ReadingHour.'.50', $aavg);
			 array_push($data, $tempArr);  // populates $data array

	         $avg = $row["Slot12Average"];
	         $aavg = ($avg-32)/1.8;
	         $tempArr = array('', $ReadingHour.'.55', $aavg);
			 array_push($data, $tempArr);  // populates $data array
     	}
     }


} else {
     echo "0 results";
}

$conn->close();

# PHPlot Example: Simple line graph
require_once '/phplot-6.2.0/phplot.php';

$plot = new PHPlot(1300, 300);
$plot->SetImageBorderType('plain');

$plot->SetPlotType('thinbarline');
$plot->SetDataType('data-data');
$plot->SetDataValues($data);

# Main plot title:
$plot->SetTitle('Average Temperature in (C) every hour:'.date("h:i:sa"));

# Make sure Y axis starts at 0:
$plot->SetPlotAreaWorld(NULL, 0, NULL, NULL);

$plot->DrawGraph();

?>



