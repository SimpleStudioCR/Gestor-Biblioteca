package utl;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class Biblioteca {

    private ArrayList<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("utl.Libro agregado: " + libro.getTitulo());
    }

    public void mostrarLibrosDisponibles() {
        System.out.println("\nLibros disponibles:");
        for (Libro libro : libros) {
            if (libro.isDisponible()) {
                libro.mostrarLibros();
            }
        }
    }

    public void buscarLibro(String criterio) {
        System.out.println("\nutl.Libro buscado: " + criterio);
        boolean encontrado = false;

        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(criterio) || libro.getAutor().equalsIgnoreCase(criterio)) {
                libro.mostrarLibros();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontre el libro con esas caracterisiticas");
        }
    }

    public void prestarLibro(String titulo, Usuario usuario) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                if (libro.isDisponible()) {
                    libro.setDisponible(false);
                    System.out.println(usuario.getNombre() + " agarro el libro: " + titulo);
                } else {
                    System.out.println("El libro '" + titulo + "' ya está prestado.");
                }
                return;
            }
        }
        System.out.println("El libro '" + titulo + "' no está en el catálogo.");
    }

    public void devolverLibro(String titulo, Usuario usuario) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                if (!libro.isDisponible()) {
                    libro.setDisponible(true);
                    System.out.println(usuario.getNombre() + " ha devuelto el libro: " + titulo);
                } else {
                    System.out.println("El libro '" + titulo + "' no estaba prestado.");
                }
                return;
            }
        }
        System.out.println("El libro '" + titulo + "' no está en el catálogo.");
    }

    public void guardarLibrosArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("LibreriaMayorga.Archivos"))) {
            for (Libro libro : libros) {
                writer.write(libro.getTitulo() + "," + libro.getAutor() + "," + libro.getPublicacion() + "," + libro.isDisponible());
                writer.newLine();
            }
            System.out.println("Libros guardado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar libros de archivo.");
        }
    }

    public void cargarLibrosArchivos () {
        try (BufferedReader leedor = new BufferedReader(new FileReader("LibreriaMayorga.Archivos"))) {
            String linea;
            while ((linea = leedor.readLine()) != null) {
                String[] datos = linea.split(",");
                String titulo = datos[0];
                String autor = datos[1];
                int publicacion = Integer.parseInt(datos[2]);
                boolean disponible = Boolean.parseBoolean(datos[3]);
                libros.add(new Libro(titulo, autor, publicacion));
            }
            System.out.println("Libros cargados exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al cargar libros de archivo." + e.getMessage());
        }
    }
}
