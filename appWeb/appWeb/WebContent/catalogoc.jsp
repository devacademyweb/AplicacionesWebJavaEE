<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


 CATALOGO USUARIO CONECTADO--BOTON PEDIDO_AGREGA CARRITO
 
 <c:if test="${sessionScope.usuario == null}">
		<jsp:forward page="index.jsp" />
</c:if>
	
<h1>Usuario Conectado:"${sessionScope.usuario.nombres}"</h1>

</br>

<a href="cerraru">Cerrar sesion</a>

IDSESION="${sessionScope.ID}"
</body>
</html>