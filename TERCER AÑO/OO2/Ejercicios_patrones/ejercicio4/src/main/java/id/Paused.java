package id;

import java.time.Duration;

public class Paused extends AbstractState{


    @Override
    public void togglePause(ToDoItem item) {
        item.setEstado(new InProgress());
    }


}
