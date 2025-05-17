package ar.com.educacionit.services.impl;

import java.util.Collection;

import com.google.protobuf.ServiceException;

import ar.com.educacionit.ProductoDAO;
import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.impl.ProductoDAOjdbcImpl;
import ar.com.educacionit.services.ProductoServices;

public class ProductoServicesImp implements ProductoServices {
	
	private ProductoDAO productoDao;
	
	public void ProductoServiceImp() {
		this.productoDao = new ProductoDAOjdbcImpl();
	}

	@Override
	public Collection<Producto> findAll() throws ServiceException {
		
		try {
			return this.productoDao.findAll();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e);
		}
		
	}

	@Override
	public Producto getById(long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto nuevoProducto(Producto producto) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Producto> buscarProductos(String clave) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto eliminarProducto(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarProducto(Producto producto) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto obtenerProductoPorCodigo(String codigo) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
