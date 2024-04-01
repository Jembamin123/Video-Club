package blacky.mbappe;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class VideoClub{
    private List<Cliente> clientes;
    private List<Pelicula> peliculas;
    private Map<String, Pelicula> peliculasFavoritas;

    public VideoClub(){
        this.clientes = new ArrayList<>();
        this.peliculas = new ArrayList<>();
        this.peliculasFavoritas = new HashMap<>();
    }

    public void agregarPelicula(Pelicula nuevaPelicula){
        peliculas.add(nuevaPelicula);
    }

    public void agregarUsuario(Cliente nuevoCliente){
        clientes.add(nuevoCliente);
    }

    public void mostrarPeliculas(){
        System.out.println("Listado de películas en el Video Club:");
        System.out.println("--------------------------------------");
        for(Pelicula pelicula : peliculas){
            System.out.println("Nombre: " + pelicula.getNombre());
            System.out.println("Estudio: " + pelicula.getStudio());
            System.out.println("Género: " + pelicula.getGenero());
            System.out.println("Fecha de lanzamiento: " + pelicula.getFechaLanzamiento());
            System.out.println("Disponible: " + (pelicula.isDisponible() ? "Sí" : "No"));
            System.out.println("--------------------------------------");
        }
    }

    public void mostrarHistorialPrestamos(String nombrePelicula){

        Pelicula pelicula = null;
        for(Pelicula p : peliculas){
            if(p.getNombre().equals(nombrePelicula)){
                pelicula = p;
                break;
            }
        }

        if(pelicula != null && !pelicula.getHistorial().isEmpty()){
            System.out.println("\nHistorial de préstamos de la película \"" + nombrePelicula + "\":");
            for (HistorialPrestamo prestamo : pelicula.getHistorial()){
                System.out.println("Cliente: " + prestamo.getRutCliente() + ", Fecha de préstamo: " + prestamo.getFechaPrestamo());
            }
        } 
        else{
            System.out.println("La película \"" + nombrePelicula + "\" no tiene historial de préstamos.");
        }
    }

    public void reservarPelicula(String nombrePelicula, String rutCliente, String fecha){

        Pelicula pelicula = null;
        for(Pelicula p : peliculas){
            if(p.getNombre().equals(nombrePelicula)){
                pelicula = p;
                break;
            }
        }

        if(pelicula != null && pelicula.isDisponible()){
            pelicula.setDisponible(false);
            pelicula.agregarHistorial(rutCliente, fecha);
            System.out.println("La película \"" + nombrePelicula + "\" ha sido reservada por el cliente con rut " + rutCliente);
        } 
        else{
            System.out.println("La película \"" + nombrePelicula + "\" no está disponible para ser reservada.");
        }
    }

    public void cancelarReserva(String nombrePelicula){
        Pelicula pelicula = null;
        for(Pelicula p : peliculas){
            if(p.getNombre().equals(nombrePelicula) && !p.isDisponible()){
                pelicula = p;
                break;
            }
        }

        if(pelicula != null){
            pelicula.setDisponible(true); 
            System.out.println("La reserva de la película \"" + nombrePelicula + "\" ha sido cancelada.");
        } 
        else{
            System.out.println("La película \"" + nombrePelicula + "\" no está reservada.");
        }
    }

    public void agregarPeliculaFavorita(String nombrePelicula, String rutCliente){
        Pelicula pelicula = null;
        for (Pelicula p : peliculas){
            if (p.getNombre().equals(nombrePelicula)){
                pelicula = p;
                break;
            }
        }
        if (pelicula != null){
            peliculasFavoritas.put(nombrePelicula, pelicula);
            System.out.println("La película \"" + nombrePelicula + "\" se ha agregado a las favoritas del cliente con rut " + rutCliente);
        } 
        else{
            System.out.println("No se pudo encontrar la película \"" + nombrePelicula + "\".");
        }
    }


    public void mostrarPeliculasFavoritas(String rutCliente){
        System.out.println("Películas favoritas del cliente con rut " + rutCliente + ":");

        boolean encontradas = false;

        for(Map.Entry<String, Pelicula> entry : peliculasFavoritas.entrySet()){
            Pelicula pelicula = entry.getValue();
            for(HistorialPrestamo prestamo : pelicula.getHistorial()){
                if(prestamo.getRutCliente().equals(rutCliente)){
                    System.out.println("Nombre: " + entry.getKey());
                    encontradas = true;
                    break;
                }
            }
        }

        if (!encontradas){
            System.out.println("No se encontraron películas favoritas para el cliente con rut " + rutCliente);
            System.out.println("Primero debes ver las películas para asignarlas a favoritas");
        }
    }

    public void mostrarPeliculasFavoritas(String rutCliente, String genero){
        System.out.println("Películas favoritas del cliente con rut " + rutCliente + " del género " + genero + ":");

        boolean encontradas = false;
        for(Map.Entry<String, Pelicula> entry : peliculasFavoritas.entrySet()){
            Pelicula pelicula = entry.getValue();
            if (pelicula.getGenero().equalsIgnoreCase(genero)){
                for (HistorialPrestamo prestamo : pelicula.getHistorial()){
                    if (prestamo.getRutCliente().equals(rutCliente)){
                        System.out.println("Nombre: " + entry.getKey());
                        encontradas = true;
                        break;
                    }
                }
            }
        }

        if(!encontradas){
            System.out.println("No se encontraron películas favoritas del género " + genero + " para el cliente con rut " + rutCliente);
            System.out.println("Primero debes ver las películas de ese género para asignarlas a favoritas");
        }
    }
}
