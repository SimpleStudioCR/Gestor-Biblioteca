public class Usuario {
    private String nombre;
    private int edad;
    private int idUsuario;
    private int contadordeUsuarios;

    public Usuario (String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
        this.idUsuario = contadordeUsuarios++ ;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void mostrarUsuario(){
        System.out.println("Usuario: " + nombre + ", Edad: " + edad + ", ID: " + idUsuario);
    }
}
