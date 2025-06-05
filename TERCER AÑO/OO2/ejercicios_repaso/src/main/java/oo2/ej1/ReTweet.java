package oo2.ej1;

public class ReTweet extends Post {
    private Tweet origen;

    public ReTweet(Usuario autor, Tweet origen) {
        super(autor);
        this.origen = origen;
        this.origen.agregarReferencia(this); // Agregar a las referencias del tweet original
    }

    @Override
    public String getText() {
        return origen.getText();
    }

    public Tweet getOrigen() {
        return origen;
    }

    @Override
    public void eliminar() {
        super.autor.eliminarTweet(this);
    }

}
