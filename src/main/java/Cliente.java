
package blacky.mbappe;

public class Cliente{
    private String nombre;
    private String rut;
    private int edad;

    public Cliente(String nombre, String rut, int edad){
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getRut(){
        return rut;
    }

    public void setRut(String rut){
        this.rut = rut;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public boolean tieneEdadMinima(int edadMinima){
        System.out.println("Verificando si su edad de '"+ edad + "' años es valida..." );
        return edad >= edadMinima;
    }

    public boolean tieneEdadMinima(int edadMinima, String mensaje){
        boolean tieneEdad = tieneEdadMinima(edadMinima);
        if (!tieneEdad){
            System.out.println(mensaje);
        } 
        else{
            System.out.println("Se ha registrado con ÉXITO!!!");
        }
        return tieneEdad;
    }
}

