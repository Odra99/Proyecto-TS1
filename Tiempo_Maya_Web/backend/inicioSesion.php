<?php
// Obtengo los datos cargados en el formulario de login.
$email = $_POST['email'];
$password = $_POST['password'];
$connection = include '../conexion/conexion.php';
// Consulta segura para evitar inyecciones SQL.
$password_decoded = hash("sha256", $password);
$user = $connection->query("SELECT * FROM tiempomaya.usuario WHERE correo='" . $email . "';");
if ($user->num_rows == 1) {

  while ($row = mysqli_fetch_assoc($user)) {
    if ($password_decoded == $row['password']) {
      session_start();
      $_SESSION['usuario'] = $row['usuario'];
      $_SESSION['correo']=$row['correo'];
      $admin = $connection->query("SELECT correo FROM tiempomaya.admin as a INNER JOIN tiempomaya.usuario as u WHERE a.correo==u.correo;");
        if($user->num_rows ==1){
          $_SESSION['admin']=$row['correo'];
        }
      $mensaje = "?mensaje='Inicio de Sesion exitoso'";
    }else{
      $mensaje="?mensaje=Contraseña incorrecta";
    }
  }
} else {
  $mensaje = "?mensaje='No se encontro el correo'";
}
$connection->close();
$url = '../index.php' . $mensaje;
header('location: ' . $url);
?>