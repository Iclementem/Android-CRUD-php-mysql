<?php
$hostname='localhost';
$database='maquina_test';
$username='root';
$password='root';

$conexion=new mysqli($hostname,$username,$password,$database);
if($conexion->connect_errno){
    echo "El sitio web está experimentado problemas";
}
?>