<?php
function showEvents($mysqli){
    $sql = "SELECT * FROM wydarzenia";
    $result = $mysqli->query($sql) or die("Error");

    while($fetch = $result->fetch_assoc()){
        echo("<tr>");
        echo("<td>".$fetch['nr']."</td>");
        echo("<td>".$fetch['nazwa']."</td>");
        echo("<td>".$fetch['miejsce']."</td>");
        echo("<td>".$fetch['ilosc_graczy']."</td>");
        echo("<td>".$fetch['data']."</td>");
        echo("<tr>");
    }
}
?>