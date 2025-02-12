package utl;

public class Libro {
    private String titulo;
    private String autor;
    private int Publicacion;
    private boolean disponible;

    public Libro (String titulo, String autor, int Publicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.Publicacion = Publicacion;
        this.disponible = true;
    }


    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getPublicacion() {
        return Publicacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void mostrarLibros(){
        System.out.println("Titulo: " + titulo + ", Autor: " + autor + ", Publicacion: " + Publicacion + ", Disponible: " + disponible);
    }
}