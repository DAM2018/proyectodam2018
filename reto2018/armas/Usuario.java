package jose.armas;

import java.util.Objects;

public class Usuario {

    private String nombre;
    private String mail;
    private String dni;
    private String user;
    private String password;

    public Usuario(String nombre, String mail, String dni, String user, String password) {
        this.nombre = nombre;
        this.mail = mail;
        this.dni = dni;
        this.user = user;
        this.password = password;
    }

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombre, usuario.nombre) &&
                Objects.equals(dni, usuario.dni);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nombre, dni);
    }

    @Override
    public String toString() {
        return nombre;
    }
}
