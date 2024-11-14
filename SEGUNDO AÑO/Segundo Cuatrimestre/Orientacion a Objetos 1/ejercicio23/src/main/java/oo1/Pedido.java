package oo1;

public class Pedido {
    private FormaPago formaPago;
    private FormaEnvio formaEnvio;
    private int cant;
    private Producto producto;

    public Pedido(Producto producto, FormaPago formaPago, FormaEnvio formaEnvio, int cant) {
        this.producto = producto;
        this.formaPago = formaPago;
        this.formaEnvio = formaEnvio;
        this.cant = cant;
    }
    public FormaPago getFormaPago() {
        return formaPago;
    }
    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }
    public FormaEnvio getFormaEnvio() {
        return formaEnvio;
    }
    public void setFormaEnvio(FormaEnvio formaEnvio) {
        this.formaEnvio = formaEnvio;
    }
    public int getCant() {
        return cant;
    }
    public void setCant(int cant) {
        this.cant = cant;
    }

    public String getCategoria(){
        return this.producto.getCategoria();
    }

    public double calcularCostoTotal () {
        return this.getCostoProducto() * formaPago.getPorcentajeExtra() + formaEnvio.getCostoEnvio();
    }
    
    private double getCostoProducto(){
        return cant*producto.getPrecio();
    }
    
}
