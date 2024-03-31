package blacky.mbappe;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.io.File;
import java.io.FileReader;
import java.util.List;

public class BlackyMbappe {
    public static void main(String[] args) throws IOException {
        BufferedReader mbappe = new BufferedReader(new InputStreamReader(System.in));
        VideoClub videoClub = new VideoClub();

        //Colocar ruta especifica del archivo "peliculas.txt"
      
        List<Pelicula> peliculas = ParaLeerTxt.leerPeliculas("C:\\Users\\Javier\\Downloads\\peliculas.txt");

        for (Pelicula pelicula : peliculas) {
            videoClub.agregarPelicula(pelicula);
        }

        //Registramos al usuario
        System.out.println("Registro de usuario.");
        System.out.println("Ingresa tu nombre completo: ");
        String nombreUsuario = mbappe.readLine();
        System.out.println("Ingresa tu rut sin dijito verificador: ");
        String rutUsuario = mbappe.readLine();
        System.out.println("Ingresa tu edad: ");
        String edadUsuarioStr = mbappe.readLine();
        int edadUsuario = Integer.parseInt(edadUsuarioStr);

        Cliente nuevoCliente = new Cliente(nombreUsuario,rutUsuario,edadUsuario);
        videoClub.agregarUsuario(nuevoCliente);

        while(true){
            System.out.println("Bienvenido al Video Club");
            System.out.println("1. Mostrar todas las peliculas.");
            System.out.println("2. Reservar pelicula.");
            System.out.println("3. Devolver pelicula.");
            System.out.println("4. Mostrar historial de reserva.");
            System.out.println("5. Salir.");
            System.out.print("Por favor, seleccione una opción: ");
            String opcionStr = mbappe.readLine();
            int opcion = Integer.parseInt(opcionStr);
            switch (opcion){
                case 1:
                    System.out.println("Ha seleccionado la Opción 1.");
                    videoClub.mostrarPeliculas();
                    break;
                case 2:
                    System.out.println("Ha seleccionado la Opción 3.");
                    System.out.println("Ingrese la fecha de hoy: ");
                    String fechaHoy = mbappe.readLine();
                    System.out.println("Ingrese el nombre de la pelicula: ");
                    String reservaPeli = mbappe.readLine();

                    videoClub.reservarPelicula(reservaPeli, rutUsuario,fechaHoy);
                    break;
                case 3:
                    System.out.println("Ingrese el nombre de la pelicula: ");
                    String cancelarPeli = mbappe.readLine();
                    videoClub.cancelarReserva(cancelarPeli);
                    break;
                case 4:
                    System.out.println("Ingrese el nombre de la pelicula: ");
                    String reservaPeli2 = mbappe.readLine();
                    videoClub.mostrarHistorialPrestamos(reservaPeli2);
                    break;
                case 5:
                    System.out.println("Saliendo del Video Club. ¡Hasta luego!");
                    return;
                case 6:
                    System.out.println("Ha seleccionado la Opción 2.");
                    // Agregar una nueva película directamente en el método main
                    System.out.println("Ingrese el nombre de la película:");
                    String nombre = mbappe.readLine();
                    System.out.println("Ingrese el estudio de la película:");
                    String studio = mbappe.readLine();
                    System.out.println("Ingrese el género de la película:");
                    String genero = mbappe.readLine();
                    System.out.println("Ingrese la fecha de lanzamiento de la película:");
                    String fechaLanzamiento = mbappe.readLine();
                    Pelicula nuevaPelicula = new Pelicula(nombre, studio, genero, fechaLanzamiento, new ArrayList<>());
                    videoClub.agregarPelicula(nuevaPelicula);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }
}
