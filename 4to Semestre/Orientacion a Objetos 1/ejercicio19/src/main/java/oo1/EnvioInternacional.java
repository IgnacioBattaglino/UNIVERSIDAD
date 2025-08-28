package oo1;

import java.time.LocalDate;

public class EnvioInternacional extends Envio {
    private String paisDestino;
    
    public EnvioInternacional (LocalDate fechaDespacho, String direccionOrigen, String direccionDestino, int peso, String paisDestino) {
        super(fechaDespacho, direccionOrigen, direccionDestino, peso);
        this.paisDestino=paisDestino;
    }

    @Override
    public double getPrecio() {
        if (this.getPeso()<=100)
            return 5000 + 10*this.getPeso();
        return 5000 + 12*this.getPeso();
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

}
