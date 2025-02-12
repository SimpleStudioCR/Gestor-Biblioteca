import utl.Biblioteca;
import utl.Libro;
import utl.Usuario;

public class MainGestor {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.cargarLibrosArchivos(); //para cargar los libros

        Usuario usuario1 = new Usuario("Julian", 15);
        Usuario usuario2  = new Usuario("TioAndres", 32);
        Usuario usuario3  = new Usuario("Naza", 12);

        // aqui se agregan libros
        biblioteca.agregarLibro(new Libro("The bible", "Dios", 1545));
        biblioteca.agregarLibro(new Libro("El principito", "Antoine de Saint-Exupéry", 1943));
        biblioteca.agregarLibro(new Libro("El utl.Libro Rojo", "Carl Gustav Jung", 2009));
        biblioteca.agregarLibro(new Libro("utl.Libro de Mayorgas", "Don Jorge Mayorga", 2006));

        biblioteca.mostrarLibrosDisponibles();

        biblioteca.buscarLibro("Dios");
        biblioteca.buscarLibro("El utl.Libro Rojo");

        biblioteca.prestarLibro("The Bible", usuario1);
        biblioteca.mostrarLibrosDisponibles();

        biblioteca.prestarLibro("The Bible", usuario2);
        biblioteca.mostrarLibrosDisponibles();

        biblioteca.devolverLibro("The Bible", usuario1);
        biblioteca.mostrarLibrosDisponibles();

        biblioteca.prestarLibro("The Bible", usuario2);
        biblioteca.mostrarLibrosDisponibles();


        biblioteca.guardarLibrosArchivo();




    }
}
