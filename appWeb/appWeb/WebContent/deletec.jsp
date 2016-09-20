<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
			<h3>UNIVERSIDAD PERUANA DE CIENCIAS APLICADAS</h3>
		</div>
		<div class="row">
			<div class="tabbable">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#" data-toggle="tab">Categorias</a></li>
				</ul>
			</div>
		</div>
		<div class="row">
			<h3>Eliminar categoria</h3>
		</div>
		<div class="row">
			<form class="form-horizontal" action="deletec" method="post">
				<input type="hidden" name="id" value="${requestScope.categoria.id}" />
				<p class="alert alert-error">
					Esta seguro de eliminar esta categoria?<br /> <b>Nombre</b>:${requestScope.categoria.nombre}
					<br />
				</p>
				<div class="form-actions">
					<button type="submit" class="btn btn-danger">Si eliminar</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="btn" href="listc">No eliminar</a>
				</div>
			</form>
		</div>
	</div>

</body>
</html>