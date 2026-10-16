package co.edu.unbosque.exceptions;

public class ValidacionReglaNegocioException extends Exception {

	public ValidacionReglaNegocioException() {
		super("La validación de regla de negocio falló.");
	}

	public ValidacionReglaNegocioException(String detalle) {
		super("Validación de regla de negocio falló: " + detalle);
	}

	public ValidacionReglaNegocioException(String detalle, Throwable cause) {
		super("Validación de regla de negocio falló: " + detalle, cause);
	}
}
