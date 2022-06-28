<?php

include 'conexion.php';
$ID=$_POST['ID'];

$consulta="DELETE FROM vidrio WHERE ID='".$ID."'";
mysqli_query($conexion,$consulta) or die (mysqli_error());
mysqli_close($conexion);

?>