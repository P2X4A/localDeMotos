# ðŸï¸ Sistema de Local de Motos

Sistema completo de inventario y ventas para un local de motos. Es el proyecto mÃ¡s amplio del portafolio, desarrollado en Java con arquitectura **MVC**, interfaz grÃ¡fica en **Swing** y persistencia de datos mediante el patrÃ³n **DAO**.

## ðŸ“‹ CaracterÃ­sticas

- Registro de motos con validaciÃ³n de datos y excepciones personalizadas
- GestiÃ³n de inventario (alta, consulta y control de stock)
- Registro de ventas por referencia o registro directo
- Ventana de bÃºsqueda de motos por referencia
- EstadÃ­sticas de ventas mensuales y anuales
- Procesamiento de transacciones desde archivo
- Persistencia de datos con patrÃ³n DAO y DTO
- Interfaz grÃ¡fica Swing con mÃºltiples ventanas (MVC)

## ðŸ› ï¸ TecnologÃ­as

- **Java** (JDK)
- **Swing** â€” interfaz grÃ¡fica
- **Maven** â€” gestiÃ³n del proyecto y dependencias
- **PatrÃ³n MVC** â€” separaciÃ³n de vista, controlador y modelo
- **PatrÃ³n DAO** â€” acceso a datos

## ðŸš€ CÃ³mo ejecutar

```bash
# Clonar el repositorio
git clone https://github.com/P2X4A/localDeMotos.git
cd localDeMotos

# Compilar con Maven
mvn clean compile

# Ejecutar (clase principal: AplMain)
mvn exec:java -Dexec.mainClass="AplMain"
```

> Nota: si no tienes Maven instalado, compila directamente con `javac` los archivos de `src/` y ejecuta la clase `AplMain`.

## ðŸ“ Estructura del proyecto

```
localDeMotos/
â”œâ”€â”€ pom.xml
â”œâ”€â”€ README.md
â”œâ”€â”€ LICENSE
â”œâ”€â”€ src/
â”‚   â”œâ”€â”€ AplMain.java              # Punto de entrada
â”‚   â”œâ”€â”€ Controlador.java          # LÃ³gica de negocio
â”‚   â”œâ”€â”€ SistemaLocal.java         # Modelo del sistema
â”‚   â”œâ”€â”€ Moto.java, Venta.java     # Entidades de dominio
â”‚   â”œâ”€â”€ DataMapper.java           # Mapeo objeto-relacional
â”‚   â”œâ”€â”€ FileHandler.java          # Lectura/escritura de archivos
â”‚   â”œâ”€â”€ IDAO.java, ...DAOImpl.java # Acceso a datos (patrÃ³n DAO)
â”‚   â”œâ”€â”€ *.DTO.java                # Objetos de transferencia
â”‚   â”œâ”€â”€ *.Exception.java          # Excepciones personalizadas
â”‚   â”œâ”€â”€ VentanaPrincipal.java     # Ventana principal Swing
â”‚   â””â”€â”€ *.java                    # Otras ventanas Swing
â””â”€â”€ ventas.txt                    # Archivo de datos incluido
```

## ðŸ‘¨â€ðŸ’» Autor

Sergio Parra â€” Estudiante de ingenierÃ­a de sistemas

---

*Proyecto desarrollado con fines acadÃ©micos y de portafolio.*
