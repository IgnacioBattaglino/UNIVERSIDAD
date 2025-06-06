package id;

public abstract class AbstractState implements State{

    public void start (){
        
    }

    public void togglePause(ToDoItem item) {
        throw new RuntimeException("El objeto ToDoItem no se encuentra en pause o in-progress");
    }

}
