package co.edu.unbosque.util;

public class Constant {

    // Rutas de archivos principales
    public static final String RUTA_INVENTARIO = "inventario.txt";
    public static final String RUTA_VENTAS = "ventas.txt";
    public static final String RUTA_TRANSACCIONES = "transacciones.txt";
    public static final String RUTA_RECHAZOS = "rechazos.txt";
    public static final String RUTA_PROPERTIES = "properties.properties";

    // Claves para archivo de properties
    public static final String IMPUESTO_VENTA = "IMPUESTO_VENTA";
    public static final String MONEDA = "MONEDA";
    
    // Comandos de acción GUI (ActionCommand)
    public static final String CMD_REGISTRAR_MOTO = "CMD_REGISTRAR_MOTO";
    public static final String CMD_REGISTRAR_MOTO_CONFIRMAR = "CMD_REGISTRAR_MOTO_CONFIRMAR";
    public static final String CMD_REGISTRAR_VENTA = "CMD_REGISTRAR_VENTA";
    public static final String CMD_REGISTRAR_VENTA_CONFIRMAR = "CMD_REGISTRAR_VENTA_CONFIRMAR";
    public static final String CMD_BUSCAR_REFERENCIA = "CMD_BUSCAR_REFERENCIA";
    public static final String CMD_BUSCAR_REFERENCIA_CONFIRMAR = "CMD_BUSCAR_REFERENCIA_CONFIRMAR";
    public static final String CMD_BUSCAR_REFERENCIA_VENTA = "CMD_BUSCAR_REFERENCIA_VENTA";
    public static final String CMD_PROCESAR_ARCHIVO = "CMD_PROCESAR_ARCHIVO";
    public static final String CMD_PROCESAR_ARCHIVO_CONFIRMAR = "CMD_PROCESAR_ARCHIVO_CONFIRMAR";
    public static final String CMD_VENTAS_REFERENCIA = "CMD_VENTAS_REFERENCIA";
    public static final String CMD_VENTAS_ANUALES = "CMD_VENTAS_ANUALES";

    // Parámetros de validación
    public static final int LONGITUD_REFERENCIA = 10;
    //Este parametro en especial define el patron para la referencia de la motocicleta
    //De modo que permite informacion de el abecedario de la A hasta la Z
    //y de 0 a 9, o ambos
    public static final String PATRON_REFERENCIA = "[A-Za-z0-9]{10}";
    public static final int MESES_DEL_ANIO = 12;

    private Constant() {
        // Para prevenir instanciación.
    }
}
