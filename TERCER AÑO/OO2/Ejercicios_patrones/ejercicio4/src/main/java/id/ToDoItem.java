package id;

import java.time.Duration;

public class ToDoItem {
    private String name;
    private State estado;
    private 
    

    public ToDoItem(String name) {
        this.name = name;
        this.estado = new Pending();
    }
    

    public void start() {
        this.estado.start(this);
    }

    public void togglePause (){
        this.estado.togglePause(this);
    }

    public void finish(){
        this.estado.finish(this);
    }

    public Duration workedTime(){
        return this.estado.workedTime(this);
    }

    public void addComent(String coment){
        this.estado.addComent(coment,this);
    }

    public void setEstado(State estado) {
        this.estado = estado;
    }

}
