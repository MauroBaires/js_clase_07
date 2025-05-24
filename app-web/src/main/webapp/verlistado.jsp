<%@page import="ar.com.educacionit.domain.Producto"%>
<%@page import= "java.util.*"%>
<%@page import="ar.com.educacionit.services.impl.ProductoServicesImpl" %>
<%@page import="ar.com.educacionit.services.ProductoServices" %>

<%
	ProductoServices ps = new ProductoServicesImpl();
	Collection<Producto> productos = ps.findAll(); 
%>



<html>
	<head>
		<jsp:include page="styles.jsp"></jsp:include>
	</head>
	
	<body>
		<jsp:include page="navbar.jsp"></jsp:include>
		<h1>Ver Listado </h1>
		
		<div class="container">
					<div class="row">
						<div class="col-12 mt-2">
							<table class="table">
								<thead>
									<tr>
										<th scope="col">ID</th>
										<th scope="col">CODIGO</th>
										<th scope="col">TITULO</th>
										<th scope="col">PRECIO</th>
										<th scope="col">TIPO</th>
									</tr>
								</thead>
								<tbody>
									
									<% for (Producto prod : productos) {%>
										
										<tr>
											<td><%= prod.getId()%></td>
											<td><%= prod.getCodigo()%></td>
											<td><%= prod.getTitulo()%></td>
											<td><%= prod.getPrecio()%></td>
											<td><%= prod.getTipoProducto()%></td>	
										</tr>
										
									<% } %>
									
									<tr>
										<td>id</td>
										<td>codigo</td>
										<td>titulo</td>
										<td>precio</td>
										<td>tipo</td>	
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
		
	</body>	

</html>