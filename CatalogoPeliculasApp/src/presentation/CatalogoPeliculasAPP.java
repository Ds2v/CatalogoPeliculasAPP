package presentation;

import domain.Pelicula;
import service.IServicioPeliculas;
import service.ServicioPeliculasArchivo;
import service.ServicioPeliculasLista;

import java.util.Scanner;

public class CatalogoPeliculasAPP {
    public static void main(String[] args) {
        //
        Scanner scann = new Scanner(System.in);
        var salir = false;
        //Implementamos el servicio
        //IServicioPeliculas servPelis = new ServicioPeliculasLista();
        IServicioPeliculas servPelis = new ServicioPeliculasArchivo();
        while (!salir){
            mostrarMenu();
            try {
                salir = ejecutarSeleccion(scann, servPelis);
            }catch (Exception e){
                System.out.println("Ha ocurrido un error: " + e.getMessage() + " Ingrese solo valores numericos");
            }
        }
    }
    private static void mostrarMenu(){
        //
        System.out.print("""
               ***** Catalago de Peliculas APP *****
                1. Agregar Pelicula
                2. Listar Pelicula
                3. Buscar Pelicula
                4. Salir
                Selecciona la opcion deseada: 
                """);
    }
    private static boolean ejecutarSeleccion(Scanner scanner, IServicioPeliculas servPeliculas){
        var salir = false;
        var opcion = Integer.parseInt(scanner.nextLine());
        switch (opcion){
            case 1 -> { //Agrega una pelicula
                System.out.println("Ingrese el nombre de la pelicula: ");
                var nombrePelicula = scanner.nextLine();
                servPeliculas.agregarPelicula(new Pelicula(nombrePelicula));
                System.out.println();
            }
            case 2 -> { //Lista todas las peliculas
                servPeliculas.listarPelicula();
                System.out.println();
            }
            case 3 -> { //Busca una pelicula
                System.out.println("Ingrese el nombre de la pelicula a buscar: ");
                var busqPelicula = scanner.nextLine();
                servPeliculas.buscarPelicula(new Pelicula(busqPelicula));
            }
            case 4 -> {
                System.out.println("Hasta pronto!!!");
                salir = true;
            }
            default -> {
                System.out.println("Seleccione una opcion valida!");
            }
        }
        return salir;
    }

}
