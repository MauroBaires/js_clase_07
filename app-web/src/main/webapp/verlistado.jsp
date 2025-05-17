
<%@page import "ar.com.educacionit.domain.Producto" %>
<%@page import "java.util.Collection" %>

<%
	ProductoServices ps = new ProductoServiceImpl();
	Collection<Producto> productos = ps.findAll();
%>


<html>
	<head>
		<jsp:include page="styles.jsp"></jsp:include>
	</head>
	
	<body>
		<jsp:include page="navbar.jsp"></jsp:include>
		<h1>Ver Listado </h1>
		
	</body>	

</html>