<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<title>UNIVERSIDAD PERUANA DE CIENCIAS APLICADAS</title>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">UPCMovies</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="paneladmin.jsp">Home</a></li>
				<li><a href="listc">Categorias</a></li>
				<li><a href="listp">Peliculas</a></li>

			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<h3>MANTENIMIENTO DE CATEGORIAS</h3>
		</div>
		<div class="row">
			<div class="tabbable">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#" data-toggle="tab">Categorias</a></li>
				</ul>
			</div>
		</div>
		<div class="row">
			<p style="text-align: right;">
				<a href="newc" class="btn btn-success">Agregar</a>

			</p>
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>NOMBRE</th>
						<th>ACCIONES</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="c" items="${requestScope.liscategorias}">
					   <tr>
					     <td>${c.id}</td>
					     <td>${c.nombre}</td>
					    <td width=350><a class="btn" href="readc?id=${c.id}">Detalle</a>
								&nbsp; <a class="btn btn-success" href="editc?id=${c.id}">Editar</a>
								&nbsp; <a class="btn btn-danger" href="removec?id=${c.id}">Eliminar</a>
					   </tr>					
					</c:forEach>

				</tbody>
			</table>
		</div>

		<div class="row">
			<c:if test="${!empty requestScope.mensaje}">
				<div>${requestScope.mensaje }</div>
			</c:if>
		</div>
	</div>
	<!-- /container -->
</body>
</html>