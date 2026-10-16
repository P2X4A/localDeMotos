package co.edu.unbosque.exceptions;

public class MotoNoExisteException extends Exception {

    public MotoNoExisteException() {
        super("La referencia de moto no existe en el inventario.");
    }

    public MotoNoExisteException(String referencia) {
        super("La moto con referencia '" + referencia + "' no existe en el inventario.");
    }

    public MotoNoExisteException(String message, Throwable cause) {
        super(message, cause);
    }
}
