package oo1;

import java.time.LocalDate;

public class Factura {
    private Usuario usuario;
    private LocalDate fecha;
    private boolean bonificacion;
    private double montoFinal;

    public Factura(Usuario usuario, CuadroTarifario cuadro) {
        this.usuario = usuario;
        this.fecha = LocalDate.now();
        this.bonificacion = (usuario.getFPE() > 0.8);
        if (this.bonificacion)
            this.montoFinal= usuario.getConsumoActiva() * cuadro.getPrecio() * 0.9;
        else 
            this.montoFinal= usuario.getConsumoActiva() * cuadro.getPrecio();
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
   
    public double getMontoFinal() {
        return montoFinal;
    }
    public void setMontoFinal(double montoFinal) {
        this.montoFinal = montoFinal;
    }
    
}
