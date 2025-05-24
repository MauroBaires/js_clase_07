package ar.com.educacionit.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.protobuf.ServiceException;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.services.ProductoServices;
import ar.com.educacionit.services.impl.ProductoServicesImpl;

@WebServlet("/NuevoProductoServlet")
public class NuevoProductoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//capturar los datos que me envia el JSP (nuevoProducto.jsp)
		String codigo = req.getParameter("codigo"); // como en el form
		String titulo = req.getParameter("titulo"); // como en el form
		String precio = req.getParameter("precio"); // como en el form
		String tipoProducto = req.getParameter("tipoProducto"); // como en el form
		
		
		Float precioF = Float.parseFloat(precio);
		Long tipoProductoL = Long.parseLong(tipoProducto);
		
		Producto nuevoProducto = new Producto(titulo, precioF, codigo, tipoProductoL);
		
		ProductoServices ps = new ProductoServicesImpl();
		
		String target;
		try {
			ps.nuevoProducto(nuevoProducto);
			target = "verlistado.jsp";
		} catch (ServiceException e) {
			target = "nuevo.jsp?error=" + e.getMessage();
		}
		
		//redireccion
		getServletContext().getRequestDispatcher("/" + target).forward(req, resp);		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
