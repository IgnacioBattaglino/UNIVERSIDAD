package oo1;

public class Empresa extends Cliente{
    private String CUIT;

    public Empresa(String nombre, String direccion, String cUIT) {
        super(nombre, direccion);
        CUIT = cUIT;
    }

    public String getCUIT() {
        return CUIT;
    }

    public void setCUIT(String cUIT) {
        CUIT = cUIT;
    }
}
