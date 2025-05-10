package ar.com.educacionit.proyecto.menu;

import java.util.HashMap;
import java.util.Map;

public class MenuAccionFactory {

	static Map<MenuEnum, IAccion> mapMenuAccion;
	
	static {
		mapMenuAccion = new HashMap<>();
		
		mapMenuAccion.put(MenuEnum.CREAR, new Crear());
		mapMenuAccion.put(MenuEnum.BUSCAR_POR_ID, new BuscarPorId());
		mapMenuAccion.put(MenuEnum.BUSCAR_POR_CODIGO, new BuscarPorCodigo());
		mapMenuAccion.put(MenuEnum.ACTUALIZAR, new Actualizar());
		mapMenuAccion.put(MenuEnum.ELIMINAR_POR_ID, new DeletePorId());
		mapMenuAccion.put(MenuEnum.ELIMINAR_POR_CODIGO, new DeletePorCodigo());
		mapMenuAccion.put(MenuEnum.LISTAR_TODOS, new ListarTodos());
	}
	
	public static IAccion getIAccion(MenuEnum menuEnum) {
		IAccion accion = null;
		if(mapMenuAccion.containsKey(menuEnum)) {
			accion = mapMenuAccion.get(menuEnum);
		}
		
		return accion;
	}
	
}
