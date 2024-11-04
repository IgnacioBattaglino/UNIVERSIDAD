package oo1;

class CajaDeAhorro extends Cuenta {

    // Constructor
    public CajaDeAhorro() {
        super();
    }

    // Implementación del método puedeExtraer
    @Override
    protected boolean puedeExtraer(double monto) {
        return getSaldo() >= monto;
    }
}