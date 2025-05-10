package ar.com.educacionit.proyecto.menu;

public class BuscarPorId extends AccionBase implements IAccion {

	@Override
	public void execute() {
		System.out.println("Ingrese el ID de producto a eliminar");
		
		Long id = teclado.nextLong();
		
	}

}
