package oo1;

import java.util.LinkedList;
import java.util.List;

public class ClienteDeCorreo {
    private Carpeta inbox;
    private List<Carpeta> carpetas;


    public ClienteDeCorreo() {
        this.inbox = new Carpeta(null);
        this.carpetas = new LinkedList<Carpeta>();
        this.carpetas.add (this.inbox);
    }

    public void recibir (Email email) {
        this.inbox.agregarCorreo(email);
    }

    public void mover (Email email , Carpeta origen, Carpeta destino) {
        origen.eliminarCorreo(email);
        destino.agregarCorreo(email);
    }

    public Email buscar (String texto){
        if (texto != null){
            return carpetas.stream()
                .flatMap(carpeta -> carpeta.getMails().stream())
                .filter(email -> email.getTitulo().contains(texto) || email.getCuerpo().contains(texto))
                .findFirst().orElse(null);
        }
        return null;
    }

    public int espacioOcupado (){
        return carpetas.stream()
            .flatMap(carpeta -> carpeta.getMails().stream())
            .mapToInt(mail -> mail.getTamaño())
            .sum();
    }

    public Carpeta getInbox() {
        return inbox;
    }

    public void setInbox(Carpeta inbox) {
        this.inbox = inbox;
    }

    public List<Carpeta> getCarpetas() {
        return carpetas;
    }

    public void setCarpetas(List<Carpeta> carpetas) {
        this.carpetas = carpetas;
    }

}
