package modelo;

import controlador.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO  {
    public void insertarUsuario(String nombre, int cedula, String direccion, String email, String usuario, String contrasena){
        String sql = "INSERT INTO usuarios (nombre, cedula, direccion, email, usuario, contrasena) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.getConnection();
        PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setInt(2, cedula);
            statement.setString(3, direccion);
            statement.setString(4,email);
            statement.setString(5, usuario);
            statement.setString(6, contrasena);

            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("un nuevo usuario fue insertado exitosamente");
            }

        } catch (SQLException e) {
            System.out.println("Error al insertar el usuario");
            e.printStackTrace();
        }
    }

    public List listarUsuarios(){
        String sql= "SELECT * FROM usuarios";
        List<Usuario> lista = new ArrayList<>();

        try (Connection conexion = ConexionBD.getConnection();
             PreparedStatement statement = conexion.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                lista.add(usuario);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar los usuarios");
            e.printStackTrace();
        }

        return lista;
    }

    public void actualizarUsuario(String nombre, String direccion, int cedula) {
        String sql = "UPDATE usuarios SET nombre = ?, direccion = ? WHERE cedula = ?";

        try (Connection conexion = ConexionBD.getConnection();
             PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, direccion);
            statement.setInt(3, cedula);

            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("El usuario fue actualizado exitosamente");
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario");
            e.printStackTrace();
        }
    }

    public void eliminarUsuario(int cedula) {
        String sql = "DELETE FROM usuarios WHERE cedula = ?";

        try (Connection conexion = ConexionBD.getConnection();
             PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, cedula);

            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("El usuario con cedula " + cedula +  "fue eliminado exitosamente");
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario");
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        //usuarioDAO.insertarUsuario("Daniel", 12345566, "transversal 96d N 80 - 43", "daniiell7@hotmail.com","daniiell", "qwerty1234");
        //List<Usuario> lista = usuarioDAO.listarUsuarios();
        //for(Usuario usuario : lista) {
        //    System.out.println(usuario);
        //}

        //usuarioDAO.actualizarUsuario("Alejandro", "calle 89 N 28-08", 12345566);
        usuarioDAO.eliminarUsuario(12345566);

    }
}

