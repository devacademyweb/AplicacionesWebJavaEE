<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
<title>UNIVERSIDAD PERUANA DE CIENCIAS APLICADAS</title>
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
			<h3>NUEVA CATEGORIA</h3>
		</div>
		<div class="row">
			<div class="tabbable">
				<ul class="nav nav-tabs">
					<li class="active"><a href="panelc.html" data-toggle="tab">Categorias</a></li>
				</ul>
			</div>
		</div>
		<div class="row">
			<h3>Agregar Categoria</h3>
		</div>
		<div class="row">
			<form class="form-horizontal" action="insertc" method="post">

				<div class="control-group">
					<label class="control-label">NOMBRE</label>
					<div class="controls">
						<input type="text" name="nombre" id="nombre"
							placeholder="Ingresar nombre" value="">
					</div>
				</div>

				<div class="form-actions">
					<button type="submit" class="btn btn-success">Agregar</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="btn" href="listc">Cancelar</a>
				</div>
			</form>
		</div>
	</div>

</body>
</html>