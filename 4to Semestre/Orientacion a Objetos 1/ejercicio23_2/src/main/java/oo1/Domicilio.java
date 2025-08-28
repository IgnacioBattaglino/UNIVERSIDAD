package oo1;
public class Domicilio implements FormaDeEnvio {
    private String domicilioVendedor; private String domicilioCliente;

    public Domicilio(String domicilioVendedor, String domicilioCliente) {
        this.domicilioVendedor = domicilioVendedor;
        this.domicilioCliente = domicilioCliente;
    }

    @Override
    public double getCostoAdicional() {
        return CalculadoraDeDistancia.distanciaEntre(domicilioVendedor, domicilioCliente) * 0.5;
    }
    
}
