<?php
$DB_HOST='localhost';
$DB_USER='root';
$DB_PASSWORD='root';
$DB_NAME='form';

$mysqli = new mysqli($DB_HOST, $DB_USER, $DB_PASSWORD, $DB_NAME) or die('Nie można połączyć się z serwerem!');

$mysqli->set_charset("utf8");
$mysqli->query("SET lc_time_names = 'pl_PL'") or die();
?>

<!--
    create table wydarzenia (nr int AUTO_INCREMENT PRIMARY KEY,
                            nazwa varchar(100),
                            ilosc_graczy int,
                            miejsce varchar(100),
                            data char(10))
-->