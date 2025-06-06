package id;

import java.time.Duration;

public class Pending extends AbstractState{

    @Override
    public void start(ToDoItem item) {
        item.setEstado(new InProgress());
    }

    @Override
    public Duration workedTime (ToDoItem item){
        throw new RuntimeException("La tarea aun no se ha inicializado");
    }
}
