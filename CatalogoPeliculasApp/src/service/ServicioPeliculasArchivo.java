package service;

import domain.Pelicula;

import java.io.*;

public class ServicioPeliculasArchivo implements IServicioPeliculas{

    private final String NOMBRE_ARCHIVO = "peliculas.txt";

    public ServicioPeliculasArchivo() {
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            if (archivo.exists()){
                System.out.println("El archivo se encuentra creado!");
            }else {
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se ha creado el archivo");
            }
        }catch (Exception e){
            System.out.println("Ha ocurrido un error al abrir el archivo: " + e.getMessage());
        }
    }

    @Override
    public void listarPelicula() {
        //En esta linea cargamos el archivo
        var archivo = new File(NOMBRE_ARCHIVO);;
        try{
            System.out.println("Listado de peliculas");
            // Se abre el archivo para solo lectura
            var reader = new BufferedReader(new FileReader(archivo));
            String linea;
            linea = reader.readLine();
            while (linea != null){
                var pelicula = new Pelicula(linea);
                System.out.println("* " + pelicula);
                linea = reader.readLine();
            }
            reader.close();
        }catch (Exception e){
            System.out.println("Ha ocurrido un error al abrir el archivo: " + e.getMessage());
        }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            // Revisamos si el archivo existe
            anexar = archivo.exists();
            var saver = new PrintWriter(new FileWriter(archivo, anexar));
            // Agregamos la pelicula (toString)
            saver.println(pelicula);
            saver.close();
            System.out.println("Se agrego la pelicula: " + pelicula);
        }catch (Exception e){
            System.out.println("Ha ocurrido un error al guardar en el archivo: " + e.getMessage());
        }
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            //
            var finder = new BufferedReader(new FileReader(archivo));
            String finderLinea;
            var indice = 1;
            var encontrada = false;
            var pBuscar = pelicula.getNombre();
            finderLinea = finder.readLine();
            while (finderLinea != null){
                if (pBuscar != null && pBuscar.equalsIgnoreCase(finderLinea)){
                    encontrada = true;
                    break;
                }
                indice++;
                finderLinea = finder.readLine();
            }
            if (encontrada){
                System.out.println("La pelicula " + pBuscar + " fue encontrada en el indice " + indice);
            }else {
                System.out.println("La pelicula " + pBuscar + " no fue encontrada");
            }
            finder.close();
        }catch (Exception e){
            System.out.println("Ha ocurrido un error al buscar el archivo: " + e.getMessage());
        }
    }
}
