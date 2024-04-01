package blacky.mbappe;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class BlackyMbappe{
    public static void main(String[] args) throws IOException{
        BufferedReader mbappe = new BufferedReader(new InputStreamReader(System.in));
        VideoClub videoClub = new VideoClub();

        //PONER LA RUTA ESPECIFICA DE LA RUTA DEL ARCHIVO "peliculas.txt"
        List<Pelicula> peliculas = PaLeerTxt.leerPeliculas("E:\\Accesos SSD\\Desktop\\peliculas.txt");
        for(Pelicula pelicula : peliculas){
            videoClub.agregarPelicula(pelicula);
        }

        System.out.println("█░█ █ █▀▄ █▀▀ █▀█ █▀▀ █░░ █░█ █▄▄   █▄▄ █░░ ▄▀█ █▀▀ █▄▀ █▄█ █▀▄▀█ █▄▄ ▄▀█ █▀█ █▀█ █▀▀\n" +
"▀▄▀ █ █▄▀ ██▄ █▄█ █▄▄ █▄▄ █▄█ █▄█   █▄█ █▄▄ █▀█ █▄▄ █░█ ░█░ █░▀░█ █▄█ █▀█ █▀▀ █▀▀ ██▄");
        System.out.println("Registro de usuario...");
        System.out.println("Ingresa tu nombre completo: ");
        String nombreUsuario = mbappe.readLine();
        System.out.println("Ingresa tu rut sin dijito verificador: ");
        String rutUsuario = mbappe.readLine();
        System.out.println("Ingresa tu edad: ");
        String edadUsuarioStr = mbappe.readLine();
        int edadUsuario = Integer.parseInt(edadUsuarioStr);
        Cliente nuevoCliente = new Cliente(nombreUsuario,rutUsuario,edadUsuario);

        if (!nuevoCliente.tieneEdadMinima(13, "Debe ser mayor de edad para registrarse en el VideoClub.")) {
            System.out.println("Registro cancelado.");
            return;
        }
        videoClub.agregarUsuario(nuevoCliente);

        while(true){
            System.out.println("\nMenú del VideoClub");
            System.out.println("1. Mostrar todas las peliculas.");
            System.out.println("2. Reservar pelicula.");
            System.out.println("3. Devolver pelicula.");
            System.out.println("4. Mostrar historial de reserva.");
            System.out.println("5. Agregar pelicula.");
            System.out.println("6. Mostrar peliculas favoritas.");
            System.out.println("7. Salir.");
            System.out.print("Por favor, seleccione una opción: ");
            String opcionStr=mbappe.readLine();
            int opcion = Integer.parseInt(opcionStr);
            switch(opcion){
                case 1:
                    System.out.println("\n");
                    videoClub.mostrarPeliculas();
                    break;
                case 2:
                    System.out.println("\nRESERVA DE PELICULA");
                    System.out.println("-----------------------\n");
                    System.out.println("Ingrese la fecha de hoy: ");
                    String fechaHoy = mbappe.readLine();
                    System.out.println("Ingrese el nombre de la pelicula: ");
                    String reservaPeli = mbappe.readLine();

                    videoClub.reservarPelicula(reservaPeli, rutUsuario,fechaHoy);
                    break;
                case 3:
                    System.out.println("\nDEVOLVER PELICULA");
                    System.out.println("-----------------------\n");
                    System.out.println("Ingrese el nombre de la pelicula: ");
                    String devolverPeli = mbappe.readLine();
                    videoClub.cancelarReserva(devolverPeli);
                    System.out.println("¿Deseas agregar esta pelicula a tu lista de favoritos? SI/NO");
                    String respuesta = mbappe.readLine();
                    if(respuesta.equals("SI")){
                        videoClub.agregarPeliculaFavorita(devolverPeli,rutUsuario);
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el nombre de la pelicula: ");
                    String reservaPeli2 = mbappe.readLine();
                    videoClub.mostrarHistorialPrestamos(reservaPeli2);
                    break;
                case 5:
                    if(!nuevoCliente.tieneEdadMinima(18)){
                        System.out.println("Registro no tienes la edad requerida para esta función.");
                        break;
                    }
                    System.out.println("\nAGREGAR PELICULA");
                    System.out.println("-----------------------\n");
                    // Agregar una nueva película directamente en el método main
                    System.out.println("Ingrese el nombre de la película:");
                    String nombre = mbappe.readLine();
                    System.out.println("Ingrese el estudio de la película:");
                    String studio = mbappe.readLine();
                    System.out.println("Ingrese el género de la película:");
                    String genero = mbappe.readLine();
                    System.out.println("Ingrese la fecha de lanzamiento de la película:");
                    String fechaLanzamiento= mbappe.readLine();
                    Pelicula nuevaPelicula =new Pelicula(nombre, studio, genero, fechaLanzamiento, new ArrayList<>());
                    videoClub.agregarPelicula(nuevaPelicula);
                    break;
                case 6:
                    videoClub.mostrarPeliculasFavoritas(rutUsuario);
                    System.out.println("Desea ver solo las de un genero en específico? SI/NO");
                    String res = mbappe.readLine();
                    if(res.equals("SI")){
                        System.out.println("Ingrese el genero:");
                        String gen = mbappe.readLine();
                        videoClub.mostrarPeliculasFavoritas(rutUsuario,gen);
                    }
                    break;
                case 7:
                    System.out.println("Saliendo del Video Club. ¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }
}
