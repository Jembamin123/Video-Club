
package blacky.mbappe;

public class HistorialPrestamo {
    private String rutCliente;
    private String fechaPrestamo;

    public HistorialPrestamo(String rutCliente, String fechaPrestamo) {
        this.rutCliente = rutCliente;
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getRutCliente() {
        return rutCliente;  
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
}
