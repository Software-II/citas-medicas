<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--
Confirmar Pago de Cita Medica V.1
-->
<!DOCTYPE html>
<html>
<head>
	<title>gui</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/fonts.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/confirmarPago.js"></script>
</head>
<body>
<!-- [ingresar el id del paciente] -->
<div id="idpac" style="display:none;">3</div>
<!-- [ingresar el saldo del paciente] -->
<div id="saldo" style="display:none;">2000</div>
<section>

<div class="cen"></div>
<div class="min"></div>
<p class="bienvenido">Bienvenido al Centro de Salud San Sebastian</p>
<p class="indicacion">[Nombre del Cliente]</p>

<div class="contenedor">
	<section class="tabla" id="citas-pendientes">
		
		
	</section>
	<div class="botonMedio"><div class="texto-boton-medio">Regresar</div></div>
	<div class="botonMedio" onclick="goDNI();"><div class="texto-boton-medio">Salir</div></div>
</div>
</section>
<footer>Estudiantes USMP - Curso Ingenier&iacute;a de Software II</footer>

</body>
</html>