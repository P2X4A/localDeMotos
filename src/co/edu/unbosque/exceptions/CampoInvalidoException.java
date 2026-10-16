package co.edu.unbosque.exceptions;

public class CampoInvalidoException extends Exception {

    public CampoInvalidoException() {
        super("El campo ingresado es inválido.");
    }

    public CampoInvalidoException(String campo) {
        super("El campo '" + campo + "' es inválido.");
    }

    public CampoInvalidoException(String campo, String detalle) {
        super("El campo '" + campo + "' es inválido: " + detalle);
    }

    public CampoInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }
}
