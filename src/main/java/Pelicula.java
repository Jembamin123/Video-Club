package blacky.mbappe;

import java.util.ArrayList;
import java.util.List;

public class Pelicula{
    private String nombre;
    private String estudio;
    private String genero;
    private String fechaLanzamiento;
    private List<HistorialPrestamo> historial;
    private boolean disponible;

    public Pelicula(String nombre, String estudio, String genero, String fechaLanzamiento, List<String> historial){
        this.nombre = nombre;
        this.estudio = estudio;
        this.genero = genero;
        this.fechaLanzamiento = fechaLanzamiento;
        this.historial = new ArrayList<>();
        this.disponible = true;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getStudio(){
        return estudio;
    }

    public void setStudio(String studio){
        this.estudio = studio;
    }

    public String getGenero(){
        return genero;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public String getFechaLanzamiento(){
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento){
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public List<HistorialPrestamo> getHistorial(){
        return historial;
    }

    public void setHistorial(List<HistorialPrestamo> historial){
        this.historial = historial;
    }

    public void agregarHistorial(String rutCliente, String fecha){
        HistorialPrestamo nuevoHistorial = new HistorialPrestamo(rutCliente, fecha);
        historial.add(nuevoHistorial);
    }

    public boolean isDisponible(){
        return disponible;
    }

    public void setDisponible(boolean disponible){
        this.disponible = disponible;
    }

}
