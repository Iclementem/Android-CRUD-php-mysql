<?php

include 'conexion.php';
$ID=$_GET['ID'];

$consulta = "SELECT * FROM vidrio WHERE ID = '$ID'";
$resultado = $conexion -> query($consulta);

while ($fila=$resultado -> fetch_array()) {
    $ID[] = array_map('utf8_encode', $fila);
}
echo json_encode(value)
$resultado -> close();


?>