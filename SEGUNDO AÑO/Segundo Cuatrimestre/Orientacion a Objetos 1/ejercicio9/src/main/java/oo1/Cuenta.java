package oo1;

public abstract class Cuenta {
    // Atributo privado saldo
    private double saldo;

    // Constructor
    public Cuenta() {
        this.saldo = 0;
    }

    // Método para obtener el saldo
    public double getSaldo() {
        return this.saldo;
    }

    // Método para depositar dinero
    public void depositar(double monto) {
        this.saldo += monto;
    }

    // Método protegido para extraer dinero sin control
    protected void extraerSinControlar(double monto) {
        this.saldo -= monto;
    }

    // Método público para extraer dinero
    public boolean extraer(double monto) {
        if (puedeExtraer(monto)) {
            this.extraerSinControlar(monto);
            return true;
        }
        return false;
    }

    // Método público para transferir a otra cuenta
    public boolean transferirACuenta(double monto, Cuenta cuentaDestino) {
        if (puedeExtraer(monto)) {
            this.extraerSinControlar(monto);
            cuentaDestino.depositar(monto);
            return true;
        }
        return false;
    }

    // Método abstracto para verificar si puede extraer
    protected abstract boolean puedeExtraer(double monto);
}
