<?php

$servername = "localhost";
$username = "root";
$password = "";

$conn = mysqli_connect($servername, $username, $password, "flightadvice");

$sql = "SELECT * from averagesensordata where stationid='1' and sensorid='WG' order by ReadingHour desc limit 12;";
$result = $conn->query($sql);
$data = array();

if ($result->num_rows > 0) {

     // output data of each row
     while($row = $result->fetch_assoc()) {
   		$StationId = $row["StationId"];
	    $SensorId = $row["SensorId"];
     	if( $SensorId == "WG" && $StationId == "1") {
	         $ReadingDate = $row["ReadingDate"];
	         $ReadingHour = $row["ReadingHour"];

	         $avg = $row["Slot1Average"];
	         $tempArr = array('', $ReadingHour.'.00', $avg*1.6);
			 array_push($data, $tempArr);  // populates $data array

	         $avg = $row["Slot2Average"];
	         $tempArr = array('', $ReadingHour.'.05', $avg*1.6);
			 array_push($data, $tempArr);  // populates $data array

	         $avg = $row["Slot3Average"];
	         $tempArr = array('', $ReadingHour.'.10', $avg*1.6);
			 array_push($data, $tempArr);  // populates $data array

	         $avg = $row["Slot4Average"];
	         $tempArr = array('', $ReadingHour.'.15', $avg*1.6);
			 array_push($data, $tempArr);  // populates $data array

	         $avg = $row["Slot5Average"];
	         $tempArr = array('', $ReadingHour.'.20', $avg*1.6);
			 array_push($data, $tempArr);  // populates $data array

	         $avg = $row["Slot6Average"];
	         $tempArr = array('', $ReadingHour.'.25', $avg*1.6);
			 array_push($data, $tempArr);  // populates $data array

	         $avg = $row["Slot7Average"];
	         $tempArr = array('', $ReadingHour.'.30', $avg*1.6);
			 array_push($data, $tempArr);  // populates $data array

	         $avg = $row["Slot8Average"];
	         $tempArr = array('', $ReadingHour.'.35', $avg*1.6);
			 array_push($data, $tempArr);  // populates $data array

	         $avg = $row["Slot9Average"];
	         $tempArr = array('', $ReadingHour.'.40', $avg*1.6);
			 array_push($data, $tempArr);  // populates $data array

	         $avg = $row["Slot10Average"];
	         $tempArr = array('', $ReadingHour.'.45', $avg*1.6);
			 array_push($data, $tempArr);  // populates $data array

	         $avg = $row["Slot11Average"];
	         $tempArr = array('', $ReadingHour.'.50', $avg*1.6);
			 array_push($data, $tempArr);  // populates $data array

	         $avg = $row["Slot12Average"];
	         $tempArr = array('', $ReadingHour.'.55', $avg*1.6);
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
$plot->SetTitle('Average Wind Gust(Km/h) every hour:'.date("h:i:sa"));

# Make sure Y axis starts at 0:
$plot->SetPlotAreaWorld(NULL, 0, NULL, NULL);

$plot->DrawGraph();

?>



