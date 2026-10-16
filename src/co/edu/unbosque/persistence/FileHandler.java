package co.edu.unbosque.persistence;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class FileHandler {

    // Lee todas las líneas de un archivo .txt plano y retorna una lista de String.
    public static List<String> leerArchivoPlano(String rutaArchivo) throws IOException {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        }
        return lineas;
    }

    // Escribe una lista de Strings en un archivo plano (.txt), cada uno en una línea (sobrescribe todo el archivo).
    public static void escribirArchivoPlano(String rutaArchivo, List<String> lineas) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
        }
    }

    // Agrega una línea al final del archivo plano (.txt).
    public static void agregarLineaArchivo(String rutaArchivo, String linea) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            bw.write(linea);
            bw.newLine();
        }
    }

    // Carga todas las propiedades desde un archivo .properties.
    public static Properties cargarProperties(String rutaProperties) throws IOException {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(rutaProperties)) {
            props.load(fis);
        }
        return props;
    }

    // Obtiene el valor de una clave desde el archivo de properties.
    public static String obtenerProperty(String rutaProperties, String key) throws IOException {
        Properties props = cargarProperties(rutaProperties);
        return props.getProperty(key);
    }

    // Guarda o actualiza una clave en el archivo de properties.
    public static void actualizarProperty(String rutaProperties, String key, String value) throws IOException {
        Properties props = cargarProperties(rutaProperties);
        props.setProperty(key, value);
        try (FileOutputStream fos = new FileOutputStream(rutaProperties)) {
            props.store(fos, "Actualizado desde FileHandler");
        }
    }
}
