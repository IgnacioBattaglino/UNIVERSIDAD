package oo1;

class CuentaCorriente extends Cuenta {
    private double descubierto;

    // Constructor
    public CuentaCorriente() {
        super();
        this.descubierto = 0;
    }

    // Método para obtener el descubierto
    public double getDescubierto() {
        return this.descubierto;
    }

    // Método para establecer el descubierto
    public void setDescubierto(double descubierto) {
        this.descubierto = descubierto;
    }

    // Implementación del método puedeExtraer
    @Override
    protected boolean puedeExtraer(double monto) {
        return (getSaldo() + this.descubierto) >= monto;
    }
}