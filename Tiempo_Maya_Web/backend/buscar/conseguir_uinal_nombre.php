<?php
$fecha1 = new DateTime("1990-04-03");
$fecha2 = new DateTime($_POST['fecha']);
$fecha_actual = strtotime(date("d-m-Y H:i:00", $fecha1->getTimestamp()));
$fecha_entrada = strtotime($_POST['fecha']);
$diff = $fecha1->diff($fecha2);
$dias = $diff->days;
$reversa = false;
if ($fecha_actual > $fecha_entrada) {
    $reversa = true;
}

if ($reversa) {
    $dias = $dias % 365;
    if ($dias < 360) {
        $mes = 18-floor($dias / 18);
        $dia = 20-$dias % 20;
    } else {
        $mes = 0;
        $dia = 365-$dias;
    }
} else {
    if ($dias >= 365) {
        $dias = $dias % 365;
    }
    if ($dias > 5) {
        $dias = $dias - 5;
        $mes = floor($dias / 18);
        $dia = $dias % 20;
    } else {
        $mes = 0;
        $dia = $dias % 20;
    }
}

?>
