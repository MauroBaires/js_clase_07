package ar.com.educacionit.services;

import java.util.Collection;

import com.google.protobuf.ServiceException;

import ar.com.educacionit.domain.Producto;

public interface ProductoServices {
	
	Collection<Producto> findAll() throws ServiceException;

	public Producto getById(long id) throws ServiceException;
	
	public Producto nuevoProducto(Producto producto) throws ServiceException;
	
	public Collection<Producto> buscarProductos(String clave)throws ServiceException;
	
	public Producto eliminarProducto(Long id) throws ServiceException;
	
	public void actualizarProducto(Producto producto) throws ServiceException;
	
	public Producto obtenerProductoPorCodigo(String codigo) throws ServiceException;
}
