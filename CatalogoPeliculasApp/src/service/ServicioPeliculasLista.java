package service;

import domain.Pelicula;

import java.util.*;

public class ServicioPeliculasLista implements IServicioPeliculas{

    private List<Pelicula> peliculas;

    public ServicioPeliculasLista() {
        this.peliculas = new ArrayList<>();
    }

    @Override
    public void listarPelicula() {
        //
        System.out.println();
        System.out.println("Listado de Peliculas...");
        peliculas.forEach(System.out::println);
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        //
        peliculas.add(pelicula);
        System.out.println("Se agrego la pelicula: " + pelicula);
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        //
        var indice = peliculas.indexOf(pelicula);
        if(indice == -1){
            System.out.println("Pelicula no encontrada");
            System.out.println();
        }else{
            System.out.println("Pelicula encontrada en el indice: " + indice);
            System.out.println();
        }
    }

    public static void main(String[] args) {

        var pelic1 = new Pelicula("AVENGERS");
        var pelic2 = new Pelicula("X-MEN");

        //Se implementa la interfaz con sus metodos abstractos junto con la clase concreta
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
        servicioPeliculas.agregarPelicula(pelic1);
        servicioPeliculas.agregarPelicula(pelic2);

        servicioPeliculas.listarPelicula();

        servicioPeliculas.buscarPelicula(pelic2);
    }

}
