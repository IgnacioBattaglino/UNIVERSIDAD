package oo1;

import java.time.LocalDate;

public class EnvioLocal extends Envio {
    private boolean entregaRapida;

    public EnvioLocal (LocalDate fechaDespacho, String direccionOrigen, String direccionDestino, int peso) {
        super(fechaDespacho, direccionOrigen, direccionDestino, peso);
        this.entregaRapida=false;;
    }

    @Override
    public double getPrecio() {
        if (this.entregaRapida) return 1000;
        return 500;
    }

    public void setEntregaRapida (boolean entregaRapida){
        this.entregaRapida=entregaRapida;
    }

    public boolean getEntregaRapida (){
        return this.entregaRapida;
    }

}
