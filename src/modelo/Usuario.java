package modelo;

public class Usuario {
    private String nombre;
    private int cedula;
    private String direccion;
    private String email;
    private String usuario;
    private String contrasena;
    private String fechaDeRegistro;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario(String nombre, int cedula, String direccion, String email, String usuario, String contrasena) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.email = email;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", cedula=" + cedula +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}
