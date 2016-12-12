<?php
$servername = "localhost";
$username = "root";
$password = "";

$conn = mysqli_connect($servername, $username, $password, "flightadvice");

$sql = "SELECT * from sensordata where stationid = '1' and sensorid = 'WD' order by id desc limit 100";
$result = $conn->query($sql);
$data = array();

if ($result->num_rows > 0) {

     // output data of each row
     while($row = $result->fetch_assoc()) {

         $SensorReading = $row["SensorReading"];
         $ReadingDateTime = $row["ReadingDateTime"];

		 //split the datetime
         $hour = substr($ReadingDateTime,11,2);
         $min = substr($ReadingDateTime,14,2)*100;
         $sec = substr($ReadingDateTime,17,2);
         $fraction = $min+$sec;

		 $tempArr = array('', $hour.'.'.$fraction, $SensorReading);
         array_push($data, $tempArr);  // populates $data array
     }

} else {
     echo "0 results";
}
$conn->close();

# PHPlot Example: Simple line graph
require_once '/phplot-6.2.0/phplot.php';

$plot = new PHPlot(800, 300);
$plot->SetImageBorderType('plain');

$plot->SetPlotType('thinbarline'); // thinbarline
$plot->SetDataType('data-data');
$plot->SetDataValues($data);

# Main plot title:
$plot->SetTitle('Individual Wind Direction Readings...:'.date("h:i:sa"));

# Make sure Y axis starts at 0:
$plot->SetPlotAreaWorld(NULL, 0, NULL, NULL);

$plot->DrawGraph();

?>



