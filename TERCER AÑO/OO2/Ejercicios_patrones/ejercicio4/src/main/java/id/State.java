package id;

import java.time.Duration;

public interface State {
    public void start(ToDoItem item);
    public void togglePause(ToDoItem item);
    public void finish(ToDoItem item);
    public Duration workedTime(ToDoItem item);
    public void addComent (String coment, ToDoItem item);
}
