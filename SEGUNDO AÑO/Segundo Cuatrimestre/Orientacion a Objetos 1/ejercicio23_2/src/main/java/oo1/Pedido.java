package oo1;

public class Pedido {
    private int cant;
    private Producto producto;
    private FormaDePago formaPago;
    private FormaDeEnvio formaEnvio;

    public Pedido(int cant, Producto producto, FormaDePago formaPago, FormaDeEnvio formaEnvio) {
        this.cant = cant;
        this.producto = producto;
        this.formaPago = formaPago;
        this.formaEnvio = formaEnvio;
    }
    
    public int getCant() {
        return this.cant;
    }

    public String getCategoriaProducto (){
        return producto.getCategoria();
    }

    public double getCostoTotal(){
        double precioFinal = producto.getPrecio() * this.cant * formaPago.getMultiplicador();
        return precioFinal + formaEnvio.getCostoAdicional();
    }
    
}
