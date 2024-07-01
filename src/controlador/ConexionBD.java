package controlador;

import java.sql.*;


public class ConexionBD {
    private static final String usuario = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/patitapp";

    private ConexionBD() {}

    public static Connection getConnection() throws SQLException {
        Connection conexion = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexion exitosa contra la base de datos");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se pudo cargar el driver de MySQL.");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("Error: No se pudo conectar a la base de datos.");
            throw new RuntimeException(e);
        }

        return conexion;
    }

    public static void main(String[] args) {
        try (Connection conexion = ConexionBD.getConnection()) {
            if (conexion != null) {
                System.out.println("La conexion fue establecida exitosamente");
            } else {
                System.out.println("La conexion no pudo ser establecida");
            }
        } catch (SQLException e) {
            System.out.println("Excepcion al cerrar la conexion");
            e.printStackTrace();
        }

    }
}
