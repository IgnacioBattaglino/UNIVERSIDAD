package oo1;

import java.util.ArrayList;
import java.util.List;

public class Propiedad {
    private String direccion;
    private String nombre;
    private double precioPorNoche;
    private List<Reserva> reservas;
    private PoliticaDeCancelacion politica;

    public Propiedad(String direccion, String nombre, double precioPorNoche, PoliticaDeCancelacion politica) {
        this.direccion = direccion;
        this.nombre = nombre;
        this.precioPorNoche = precioPorNoche;
        this.reservas = new ArrayList<>();
        this.politica = politica;
    }

    public Reserva reservar (DateLapse periodo, Usuario inquilino) {
        if (isAvailable(periodo)) {
            Reserva r = new Reserva (precioPorNoche,periodo,inquilino);
            this.reservas.add(r);
            return r;
        }
        return null;
    }

    public double eliminarReserva (Reserva unaReserva) {
        if (unaReserva.isNow()) return 0;
        reservas.remove(unaReserva);
        return politica.devolverDinero(unaReserva);
    }

    public boolean isAvailable (DateLapse periodo) {
        return  this.reservas.stream()
        .noneMatch(r -> r.reservaInDateLapse(periodo));
    }

    public double totalReservasInLapse (DateLapse lapso){
        return this.reservas.stream()
        .filter (reserva -> reserva.reservaInDateLapse(lapso))
        .mapToDouble (reserva -> reserva.getPrecioTotal())
        .sum() ;
    }

    
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecioPorNoche() {
        return precioPorNoche;
    }
    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }
    public List<Reserva> getReservas() {
        return reservas;
    }
    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public PoliticaDeCancelacion getPolitica() {
        return politica;
    }

    public void setPolitica(PoliticaDeCancelacion politica) {
        this.politica = politica;
    }
    
}
