package blacky.mbappe;

import java.util.ArrayList;
import java.util.List;

public class VideoClub {
    private List<Cliente> clientes;
    private List<Pelicula> peliculas;

    public VideoClub() {
        this.clientes = new ArrayList<>();
        this.peliculas = new ArrayList<>();
    }

    public void agregarPelicula(Pelicula nuevaPelicula) {
        peliculas.add(nuevaPelicula);
    }

    public void agregarUsuario(Cliente nuevoCliente){
        clientes.add(nuevoCliente);
    }

    public void mostrarPeliculas() {
        System.out.println("Listado de películas en el Video Club:");
        System.out.println("--------------------------------------");
        for (Pelicula pelicula : peliculas) {
            System.out.println("Nombre: " + pelicula.getNombre());
            System.out.println("Estudio: " + pelicula.getStudio());
            System.out.println("Género: " + pelicula.getGenero());
            System.out.println("Fecha de lanzamiento: " + pelicula.getFechaLanzamiento());
            System.out.println("Disponible: " + (pelicula.isDisponible() ? "Sí" : "No"));
            System.out.println("--------------------------------------");
        }
    }

    public void mostrarHistorialPrestamos(String nombrePelicula) {
        // Buscar la película por su nombre
        Pelicula pelicula = null;
        for (Pelicula p : peliculas) {
            if (p.getNombre().equals(nombrePelicula)) {
                pelicula = p;
                break;
            }
        }

        // Verificar si la película existe y si tiene historial de préstamos
        if (pelicula != null && !pelicula.getHistorial().isEmpty()) {
            System.out.println("Historial de préstamos de la película \"" + nombrePelicula + "\":");
            for (HistorialPrestamo prestamo : pelicula.getHistorial()) {
                System.out.println("Cliente: " + prestamo.getRutCliente() + ", Fecha de préstamo: " + prestamo.getFechaPrestamo());
            }
        } else {
            System.out.println("La película \"" + nombrePelicula + "\" no tiene historial de préstamos.");
        }
    }

    public void reservarPelicula(String nombrePelicula, String rutCliente, String fecha) {
        // Buscar la película por su nombre
        Pelicula pelicula = null;
        for (Pelicula p : peliculas) {
            if (p.getNombre().equals(nombrePelicula)) {
                pelicula = p;
                break;
            }
        }

        // Verificar si la película existe y está disponible
        if (pelicula != null && pelicula.isDisponible()) {
            // Marcar la película como reservada
            pelicula.setDisponible(false);

            // Agregar un registro al historial de préstamos de la película
            pelicula.agregarHistorial(rutCliente, fecha);

            System.out.println("La película \"" + nombrePelicula + "\" ha sido reservada por el cliente con rut " + rutCliente);
        } else {
            System.out.println("La película \"" + nombrePelicula + "\" no está disponible para ser reservada.");
        }
    }

    public void cancelarReserva(String nombrePelicula) {
        Pelicula pelicula = null;
        for (Pelicula p : peliculas) {
            if (p.getNombre().equals(nombrePelicula) && !p.isDisponible()) {
                pelicula = p;
                break;
            }
        }

        if (pelicula != null) {
            pelicula.setDisponible(true); // Marcar la película como disponible nuevamente
            System.out.println("La reserva de la película \"" + nombrePelicula + "\" ha sido cancelada.");
        } else {
            System.out.println("La película \"" + nombrePelicula + "\" no está reservada.");
        }
    }



}
