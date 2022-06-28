<?php

include 'conexion.php';
$ID=$_POST['ID'];
$MAC=$_POST['MAC'];
$total=$_POST['total'];
$parcial=$_POST['parcial'];
$offset=$_POST['offset'];

$consulta="UPDATE vidrio SET ID= '".$id"', MAC= '".$MAC."', total='".$total."', parcial='".$parcial."', offset='".$offset."' WHERE ID='".$ID."'";
mysqli_query($conexion,$consulta) or die (mysqli_error());
mysqli_close($conexion);

?>