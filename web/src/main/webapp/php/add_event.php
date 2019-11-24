<?php
require_once 'db.php';

$name = $_POST['name'];
$place = $_POST['place'];
$players = $_POST['players'];
$date = $_POST['date'];

$sql = "INSERT INTO wydarzenia (nazwa, miejsce, ilosc_graczy, data) VALUES ('$name', '$place', $players, '$date')";
$mysqli->query($sql) or die('Error');

?>