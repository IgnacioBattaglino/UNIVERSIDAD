package oo1;

import java.util.LinkedList;
import java.util.List;

public class Carpeta {
    private String nombre;
    private List<Email> mails;

    public Carpeta(String nombre) {
        this.nombre = nombre;
        this.mails = new LinkedList<Email>();
    }

    public void agregarCorreo (Email mail){
        mails.add(mail);
    }

    public void eliminarCorreo (Email mail){
        mails.remove(mail);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Email> getMails() {
        return mails;
    }

    public void setMails(List<Email> mails) {
        this.mails = mails;
    }

    
    
}
