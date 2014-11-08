<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--
Generar Citas Medicas V.3
-->
<!DOCTYPE html>
<html>
<head>
	<title>gui</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/fonts.css">
<!-- 	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> -->
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/GenerarCM.js"></script>
</head>
<body>
	<section>
		<div class="cen"></div>
		<div class="min"></div>
		<!--<p class="bienvenido">Centro de Salud San Sebastian</p>-->
		<p class="indicacion">Centro de Salud San Sebastian</p>
		<div class="contenedor">
			<div class="row">
				<div class="item1">Nro Historria M&eacute;dica:<strong>0001</strong></div>
				<div class="item2">Saldo: <strong>S/.50.00</strong></div>
			</div>
			<div class="row">
				<div class="item1">Servicio: <strong id="servicio"></strong></div>
				<div class="item2"><div onclick="openBuscarServicio()"class="botonMenu">Buscar Servicio</div></div>
			</div>
			<div class="row">
				<div class="item">Costo consulta <strong>S/.</strong><strong id="costo-servicio"></strong></div>
			</div>
			<div class="row">
				<div class="item1">M&eacute;dico: <strong id="medico"></strong></div>
				<div class="item2"><div onclick="openBuscarMedico()" class="botonMenu" >Buscar M&eacute;dico</div></div>
			</div>
			<div class="row">
				<div class="item1">Fecha: <strong id="fecha-cita"></strong></div>
				<div class="item2">Hora: <strong id="hora-cita"></strong></div>
			</div>
			<div class="row">
				<div class="item2"><div onclick="generarCitaMedica()" class="botonMenu">Generar Cita Medica</div></div>
				<div class="item2"><div onclick="salir()" class="botonMenu">Salir</div></div>
				<!--<div class="item3"><div onclick="openBuscarMedico()" class="botonMenu">Buscar M&eacute;dico</div></div>-->
			</div>
		</div>
	</section>

	<section id="ventana-buscar-servicio">
		<p class="bienvenido">Centro de Salud San Sebastian</p>
		<div class="contenedor">
			<div class="row">
				<div class="item1">Escriba el Servicio a buscar</div>
				<div class="item2"><div onclick="closeBuscarServicio()" class="botonMenu">Salir</div></div>
			</div>
			<div class="row">
				<div class="item1"><input type="text" id="servicio-a-buscar"></div>
				<div class="item2"><div onclick="buscarServicio()" class="botonMenu">Buscar</div></div>
			</div>
			<div class="row" id="lista-servicios">
				<!-- <div class="item"><div onclick="getServicio(data)" class="botonMenu">data</div></div>-->
			</div>
		</div>
	</section>
	<section id="ventana-buscar-medico">
		<p class="bienvenido">Centro de Salud San Sebastian</p>
		<div class="contenedor">
			<div class="row" >
				<div class="item1">Servicio: <strong id="servicio-seleccionado"></strong></div>
				<div class="item2"><div onclick="closeBuscarMedico()" class="botonMenu">Salir</div></div>
			</div>
			<div class="row">
				<div class="item1"><input type="text" id="medico-a-buscar"></div>
				<div class="item2"><div onclick="buscarMedico()" class="botonMenu">Buscar M&eacute;dico</div></div>
			</div>
			
			<div class="row" id="lista-medicos" style="max-height: 145%;">
				
			</div>
		</div>
	</section>

	<footer>Estudiantes USMP - Curso Ingenier&iacute;a de Software II</footer>
</body>
</html>