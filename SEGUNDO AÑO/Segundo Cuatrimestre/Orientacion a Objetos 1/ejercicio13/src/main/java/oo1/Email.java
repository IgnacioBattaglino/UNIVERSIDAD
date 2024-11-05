package oo1;

import java.util.List;

public class Email {
    private String titulo;
    private String cuerpo;
    private List<Archivo> adjuntos;

    public int getTamaño () {
        int sum = titulo.length()+cuerpo.length()+adjuntos.stream()
        .mapToInt(adjunto -> adjunto.tamaño())
        .sum();
        return sum;
    }

    public Email(String titulo, String cuerpo, List<Archivo> adjuntos) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.adjuntos = adjuntos;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getCuerpo() {
        return cuerpo;
    }
    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
    public List<Archivo> getAdjuntos() {
        return adjuntos;
    }
    public void setAdjuntos(List<Archivo> adjuntos) {
        this.adjuntos = adjuntos;
    }


    
}
