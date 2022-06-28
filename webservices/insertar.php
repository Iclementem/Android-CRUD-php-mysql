<?php

include 'conexion.php';
$ID=$_POST['ID'];
$MAC=$_POST['MAC'];
$total=$_POST['total'];
$parcial=$_POST['parcial'];
$offset=$_POST['offset'];

$consulta="INSERT INTO vidrio VALUES('".$ID."', '".$MAC."','".$total."','".$parcial."','".$offset."')";
mysqli_query($conexion,$consulta) or die (mysqli_error());
mysqli_close($conexion);


?>