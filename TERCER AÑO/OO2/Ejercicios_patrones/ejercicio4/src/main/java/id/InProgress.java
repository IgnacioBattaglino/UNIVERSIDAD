package id;

import java.time.Duration;

public class InProgress extends AbstractState {

    @Override
    public void togglePause(ToDoItem item) {
       item.setEstado(new Paused());
    }

}
