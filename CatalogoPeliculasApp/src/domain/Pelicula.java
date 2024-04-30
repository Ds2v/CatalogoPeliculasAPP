package domain;

import java.util.Objects;

public class Pelicula {
    //
    private String nombre;

    public Pelicula() {
        //Constructor vacio
    }

    public Pelicula(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(nombre, pelicula.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    public static void main(String[] args) {
        var pelic1 = new Pelicula("AVENGERS");
        var pelic2 = new Pelicula("X-MEN");
        System.out.println("pelic1 = " + pelic1);
        System.out.println("pelic2 = " + pelic2);
    }
}
