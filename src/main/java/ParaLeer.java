package blacky.mbappe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PaLeerTxt{
    public static List<Pelicula> leerPeliculas(String rutaArchivo) throws IOException{
        List<Pelicula> peliculas = new ArrayList<>();
        File file = new File(rutaArchivo);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null){
            String[] parts = line.split(",");
            String nombre = parts[0].trim();
            String estudio = parts[1].trim();
            String genero = parts[2].trim();
            String fechaLanzamiento = parts[3].trim();

            Pelicula pelicula = new Pelicula(nombre, estudio, genero, fechaLanzamiento, new ArrayList<>());
            peliculas.add(pelicula);
        }
        reader.close();
        return peliculas;
    }
}

