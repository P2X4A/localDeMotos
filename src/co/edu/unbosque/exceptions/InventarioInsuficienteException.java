package co.edu.unbosque.exceptions;

public class InventarioInsuficienteException extends Exception {

    public InventarioInsuficienteException() {
        super("El inventario es insuficiente para completar la venta.");
    }

    public InventarioInsuficienteException(String referencia, int cantidadSolicitada, int cantidadDisponible) {
        super("Inventario insuficiente para la referencia '" + referencia + "'. Solicitadas: " + cantidadSolicitada + 
              " unidades, Disponibles: " + cantidadDisponible + " unidades.");
    }

    public InventarioInsuficienteException(String message, Throwable cause) {
        super(message, cause);
    }
}
