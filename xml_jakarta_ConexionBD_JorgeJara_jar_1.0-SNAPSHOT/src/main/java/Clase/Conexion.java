package Clase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    static final String DB_URL = "jdbc:mysql://localhost:3306/datagaming";
    static final String USER = "GM";
    static final String PASS = "1234";
    static final String QUERY = "SELECT * FROM videojuegos";

    private Connection connection; // Mantén la conexión como un campo de la clase para poder cerrarla más tarde

    // Constructor para inicializar la conexión
    public Conexion() {
        try {
            // Cargar el controlador JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            // Manejar la excepción o relanzarla según tus necesidades
        }
    }

    // Método para realizar operaciones en la base de datos (si es necesario)
    public void realizarOperaciones() throws SQLException {
        try {
            Statement statement = connection.createStatement();
            // statement.execute(QUERY); // Realiza alguna operación con la base de datos

        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejar la excepción o relanzarla según tus necesidades
            throw ex;
        }
    }

    // Método para cerrar la conexión
    public void cerrarConexion() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
