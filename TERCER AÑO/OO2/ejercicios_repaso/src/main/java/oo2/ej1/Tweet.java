package oo2.ej1;

import java.util.ArrayList;
import java.util.List;

public class Tweet extends Post {
    private String text;
    private List<ReTweet> referencias;

    public Tweet(Usuario autor, String text) {
        super(autor);
        if (text == null || text.length() < 1 || text.length() > 280) {
            throw new IllegalArgumentException("El texto debe tener entre 1 y 280 caracteres.");
        }
        this.text = text;
        this.referencias = new ArrayList<>();
    }

    @Override
    public String getText() {
        return text;
    }

    public void agregarReferencia(ReTweet retweet) {
        this.referencias.add(retweet);
    }

    public List<ReTweet> getReferencias() {
        return referencias;
    }

    @Override
    public void eliminar() {
        referencias.forEach(r -> {r.eliminar();});
    }
}
