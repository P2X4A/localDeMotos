package co.edu.unbosque.exceptions;

public class FormatoArchivoInvalidoException extends Exception {

    public FormatoArchivoInvalidoException() {
        super("El formato del archivo no es válido.");
    }

    public FormatoArchivoInvalidoException(String nombreArchivo) {
        super("El archivo '" + nombreArchivo + "' tiene un formato inválido.");
    }

    public FormatoArchivoInvalidoException(String nombreArchivo, String detalleError) {
        super("El archivo '" + nombreArchivo + "' tiene un formato inválido. Error: " + detalleError);
    }

    public FormatoArchivoInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }
}
