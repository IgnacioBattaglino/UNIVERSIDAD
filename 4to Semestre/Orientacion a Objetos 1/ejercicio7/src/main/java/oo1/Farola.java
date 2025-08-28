package oo1;
import java.util.LinkedList;
import java.util.List;

public class Farola {

    private LinkedList<Farola> neightbors;
    private Boolean encendida;

    public Farola (){
        this.encendida=false;
        this.neightbors= new LinkedList<>();
    }
    
    public Boolean isOn (){
        return encendida;
    }

    public Boolean isOff (){
        return !encendida;
    }

    public void pairWithNeighbor( Farola otraFarola ){
        this.neightbors.add(otraFarola);
        otraFarola.neightbors.add(this);
    }
    
    public List<Farola> getNeighbors (){
        return this.neightbors;
    }

    public void turnOn() {
        if (this.isOn()) return;
        this.encendida=true;
        for (Farola vecino: this.neightbors){
            vecino.turnOn();
        }
    }

    public void turnOff(){
        if (!this.isOn()) return;
        this.encendida=false;
        for (Farola vecino: this.neightbors){
            vecino.turnOff();
        }
    }

}
