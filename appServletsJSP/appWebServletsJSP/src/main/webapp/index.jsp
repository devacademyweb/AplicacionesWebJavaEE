<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>OPERACIONES ARITMETICAS</h1>
	<form method="post" action="Basico">

		<table>

			<tr>
				<td>Operación:</td>
				<td><select name="opera">
						<option value="1">Suma</option>
						<option value="2">Producto</option>
				</select></td>
			</tr>

			<tr>
				<td>Número 1:</td>
				<td><input type="text" name="n1" /></td>
			</tr>

			<tr>
				<td>Número 2:</td>
				<td><input type="text" name="n2" /></td>
			</tr>

		</table>

		<input type="submit" value="Procesar" />
	</form>
</body>
</html>