package co.edu.unbosque.persistence;

public interface IDAO <T>{
	//Uso de generics para no implementar cada DAO por separado dentro de esta interfaz
	void guardar(T entidad);
	void actualizar (T entidad);
	T leer(T entidad);
	void eliminar (T entidad);
}
