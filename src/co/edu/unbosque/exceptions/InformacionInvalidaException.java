package co.edu.unbosque.exceptions;

public class InformacionInvalidaException extends Exception {

    public InformacionInvalidaException() {
        super("La información proporcionada es inválida.");
    }

    public InformacionInvalidaException(String detalle) {
        super("Información inválida: " + detalle);
    }

    public InformacionInvalidaException(String detalle, Throwable cause) {
        super("Información inválida: " + detalle, cause);
    }
}
