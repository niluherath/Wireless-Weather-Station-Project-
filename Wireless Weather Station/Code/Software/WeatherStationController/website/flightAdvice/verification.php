<?php

	$servername = "localhost:3306";
	$ussername = "root";
	$password = "";
	$db = mysqli_connect($servername,$ussername,$password,"flightadvice");

	$uusername = $_POST['username'];
	$password = $_POST['password'];

	$myusername = mysqli_real_escape_string($db,$uusername);
	$mypassword = mysqli_real_escape_string($db,$password);


	 $sql = "SELECT * FROM admin WHERE username = '$myusername' and passcode = '$mypassword'";
	 $result = mysqli_query($db,$sql);

	 $row = mysqli_fetch_array($result);

	 if($row['username'] == $myusername && $row['passcode'] == $mypassword) {
	      echo "login successfull";
	      readfile("flightAdvice.html");

	 }else {
	      echo "login failed, mismatch of username or password";
	 }

?>


