# Motorcycle Shop System - localDeMotos

## Description

Complete inventory and sales management system for a motorcycle shop: register motorcycles, control stock, record sales by reference or directly from inventory, search motorcycles and review monthly and yearly sales statistics. This is the most comprehensive project in this portfolio, built with an **MVC** architecture, a multi-window **Swing** interface and file persistence through the **DAO** pattern with custom business exceptions.

Academic project developed for the **Java programming** courses - Systems Engineering, Universidad El Bosque.

## Author

- Sergio Alejandro Parra Rivera

## Technologies

- Java 21 (compiled with `maven-compiler-plugin`)
- Swing for the graphical interface
- Maven 3.8+ with `exec-maven-plugin` to run the application
- **MVC** architecture (`controller`, `model`, `view`, `persistence`, `exceptions` layers)
- **DAO** and **DTO** patterns with a `DataMapper` for plain text file persistence
- Custom exceptions for business rule validation

## Requirements

| Requirement | Version | How to check |
| --- | --- | --- |
| JDK | 21 or higher | `javac -version` |
| Maven | 3.8 or higher | `mvn -v` |
| Git | Any recent version | `git --version` |

## Installation

Follow these steps exactly so the application runs on the first try.

### 1. Clone the repository

```bash
git clone https://github.com/P2X4A/localDeMotos.git
```

### 2. Enter the project folder

```bash
cd localDeMotos
```

> On Windows, if your path contains spaces, always quote it, for example: `cd "C:\Users\Example\Documents\localDeMotos"`.

### 3. Verify your environment

```bash
javac -version
mvn -v
```

Expected: JDK 21 (or higher) and Maven 3.8 (or higher). If any command fails, install or update that tool before continuing.

### 4. Compile the project

```bash
mvn clean compile
```

What success looks like:

- The console ends with `BUILD SUCCESS`.
- A `target/classes/` folder is created with the compiled classes.

## Running the application

```bash
mvn exec:java
```

The main window opens with access to every module: motorcycle registry, sales, search, transaction file processing and sales statistics. Sample data is included in the repository (`ventas.txt`).

Troubleshooting:

- `ClassNotFoundException` or missing main class: compile first with `mvn clean compile`.
- `UnsupportedClassVersionError`: your JDK is older than 21; install JDK 21 or higher and check it with `javac -version`.

## Main features

- **Motorcycle registry:** full form to register motorcycles with field validation; invalid data raises custom exceptions such as `CampoInvalidoException` and `InformacionInvalidaException`.
- **Inventory control:** stock is updated with every operation and validated against availability (`InventarioInsuficienteException`); unknown references raise `MotoNoExisteException`.
- **Sales:** record sales directly from inventory or by motorcycle reference, with automatic stock update.
- **Search and file processing:** look up a motorcycle by its reference and process transaction files, validating their format (`FormatoArchivoInvalidoException`).
- **Statistics:** monthly and yearly sales reports computed from the recorded sales.
- **Persistence:** inventory, sales and transaction files are stored in plain text through the DAO layer (`InventarioImplIDAO`, `VentaImplIDAO`, `TransaccionArchivoImplIDAO`) using DTOs and a `DataMapper`.

## Project structure

```text
localDeMotos/
├── pom.xml
├── README.md
├── LICENSE
├── ventas.txt                             # Sample sales data used by the application
├── properties.properties                  # Application settings
└── src/
    └── co/edu/unbosque/
        ├── controller/
        │   ├── AplMain.java               # Entry point (main class)
        │   └── Controlador.java           # Application controller (MVC)
        ├── model/
        │   ├── SistemaLocal.java          # Core model of the system
        │   ├── Moto.java                  # Motorcycle entity
        │   ├── Venta.java                 # Sale entity
        │   ├── TransaccionArchivo.java    # Transaction loaded from file
        │   └── EstadisticaVentaMes.java   # Monthly sales statistics
        ├── exceptions/                    # Custom business exceptions
        │   ├── CampoInvalidoException.java
        │   ├── InformacionInvalidaException.java
        │   ├── InventarioInsuficienteException.java
        │   ├── MotoNoExisteException.java
        │   ├── FormatoArchivoInvalidoException.java
        │   └── ValidacionReglaNegocioException.java
        ├── persistence/                   # Data access (DAO pattern)
        │   ├── IDAO.java
        │   ├── InventarioImplIDAO.java
        │   ├── VentaImplIDAO.java
        │   ├── TransaccionArchivoImplIDAO.java
        │   ├── *DTO.java                  # Transfer objects
        │   ├── DataMapper.java
        │   └── FileHandler.java
        ├── util/
        │   ├── Constant.java
        │   └── properties.properties
        └── view/                          # Swing windows
            ├── VentanaPrincipal.java
            ├── VentanaRegistroMoto.java
            ├── VentanaRegistroVenta.java
            ├── VentanaVentaPorReferencia.java
            ├── VentanaBuscarReferencia.java
            ├── VentanaProcesarArchivo.java
            └── VentanaVentasAnuales.java
```
