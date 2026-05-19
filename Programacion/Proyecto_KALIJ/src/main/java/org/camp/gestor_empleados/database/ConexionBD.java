package org.camp.gestor_empleados.database;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    // Busca el archivo .env, lo lee y carga sus variables en memoria
    private static final Dotenv dotenv = Dotenv.load();

    private static final String HOST = dotenv.get("DB_HOST");
    private static final String DB_NAME = dotenv.get("DB_NAME");
    private static final String USUARIO = dotenv.get("DB_USER");
    private static final String PASSWORD = dotenv.get("DB_PASSWORD");

    // Construimos la URL completa uniendo las variables
    private static final String URL = "jdbc:postgresql://" + HOST + "/" + DB_NAME;

    public static Connection conectar() {
        Connection conexion = null;
        try {
            System.out.println("Intentando conectar a la base de datos...");
            // Abrimos la comunicación usando nuestras constantes
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("¡Conexión establecida con éxito!");
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
        return conexion;
    }
}
