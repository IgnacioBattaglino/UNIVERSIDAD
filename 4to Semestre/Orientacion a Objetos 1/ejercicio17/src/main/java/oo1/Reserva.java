package oo1;

import java.time.LocalDate;

public class Reserva {
    private DateLapse periodo;
    private double precioPorNoche;
    private Usuario inquilino;

    public Reserva(double precioPorNoche, DateLapse periodo, Usuario inquilino) {
        this.periodo = periodo;
        this.precioPorNoche = precioPorNoche; 
        this.inquilino = inquilino;
    }

    public double getPrecioTotal() {
        return this.periodo.sizeInDays()*this.precioPorNoche;
    }

    public boolean reservaInDateLapse (DateLapse lapso) {
        return this.periodo.overlaps(lapso);
    }

    public boolean isNow (){
        return this.periodo.includesDate(LocalDate.now());
    }

    public DateLapse getPeriodo() {
        return periodo;
    }
    public void setPeriodo(DateLapse periodo) {
        this.periodo = periodo;
    }
    public double getPrecioPorNoche() {
        return precioPorNoche;
    }
    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }
    public Usuario getInquilino() {
        return inquilino;
    }
    public void setInquilino(Usuario inquilino) {
        this.inquilino = inquilino;
    }
}
