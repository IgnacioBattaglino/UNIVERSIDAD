package oo1;
public class ExpressDomicilio implements FormaEnvio{
    private String direccionVendedor;
    private String direccionCliente;

    public ExpressDomicilio(String direccionVendedor, String direccionCliente) {
        this.direccionVendedor = direccionVendedor;
        this.direccionCliente = direccionCliente;
    }

    @Override
    public double getCostoEnvio() {
        CalculadoraDeDistancia calculadora = new CalculadoraDeDistancia();
        return calculadora.distanciaEntre(direccionVendedor, direccionCliente) * 0.5  ;
    }
    
}
