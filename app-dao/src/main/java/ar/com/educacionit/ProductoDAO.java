package ar.com.educacionit;

import java.util.Collection;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.DuplicatedException;
import ar.com.educacionit.exceptions.GenericException;

public interface ProductoDAO {
	
	public Producto create(Producto producto) throws GenericException, DuplicatedException;
	public Collection<Producto> findAll()throws GenericException;
	public Producto getById(Long id)throws GenericException;
	public Producto getByCodigo(String codigo)throws GenericException;
	public Producto update(Producto producto)throws GenericException;
	public Producto deleteById(long id)throws GenericException;
	public Producto deleteByCodigo(String codigo)throws GenericException;
	public Collection<Producto> findAllByTitulo(String titulo)throws GenericException;
}
