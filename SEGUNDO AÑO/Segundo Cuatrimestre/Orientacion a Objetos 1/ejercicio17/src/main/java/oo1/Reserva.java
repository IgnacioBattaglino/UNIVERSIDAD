package oo1;

public class Reserva {
    private DateLapse periodo;
    private double precioTotal;
    private Propiedad propiedad;

    public Reserva(Propiedad propiedad, double precioPorNoche, DateLapse periodo) {
        this.periodo = periodo;
        this.precioTotal = periodo.sizeInDays()*precioPorNoche;
        this.propiedad=propiedad;
    }

    public DateLapse getPeriodo() {
        return periodo;
    }
    public void setPeriodo(DateLapse periodo) {
        this.periodo = periodo;
    }
    public double getPrecioTotal() {
        return precioTotal;
    }
    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }
    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

    
}
