<html>
	<head>
		<jsp:include page="styles.jsp"></jsp:include>
	</head>
	
	<body>
		<jsp:include page="navbar.jsp"></jsp:include>
		
		<div class= "container">
			<h1>Nuevo Producto </h1>
			<div class = "row"">
				<div class = "col">
					<form action="<%= request.getContextPath()%>/NuevoProductoServlet"> <!-- por defecto el metodo de envio de info (method) en los form html es get -->
						
						<!-- Campo codigo -->
						<div class="mb-3">
						  <label for="lbl-codigo" class="form-label">Codigo</label>
						  <input name= "codigo" type="text" class="form-control" id="lbl-codigo" placeholder="Ingrese un codigo. Ej: 000010">
						</div>

						<!-- Campo Titulo -->
						<div class="mb-3">
							<label for="lbl-titulo" class="form-label">Titulo</label>
							<input name= "titulo" type="text" class="form-control" id="lbl-titulo" placeholder="Ingrese un titulo. Ej: tablet">
						</div>
						
						<!-- Campo Precio -->
						<div class="mb-3">
							<label for="lbl-precio" class="form-label">Precio</label>
							<input name= "precio" type="text" class="form-control" id="lbl-precio" placeholder="Ingrese un codigo. Ej: 000010">
						</div>
						
						<div class ="mb-3">						
							<label for="lbl-tipoProducto" class="form-label">Tipo de producto</label>

								<select name="tipoProducto" class="form-select" aria-label="Default select example">
								  <option selected value="">Seleccione una opcion</option>
								  <option value="1">Herramientas</option>
								  <option value="2">Electrodomesticos</option>
								  <option value="3">Celulares</option>
								  <option value="4">Informatica</option>
								</select>
						</div>	
						
						<button type="submit" class="btn btn-primary">Enviar</button>
								
					</form>
				</div>
			</div>
		
		</div>
	</body>	

</html>