package taskmanager;

public class TaskList {
    private final int MAX_TASK = 10;
    Task[] tasks = new Task[MAX_TASK];
    private int index = 0;
    String name;
    
    public TaskList(String name) {
        this.name = name;
    }
    
    public void addTask(Task task){
        this.tasks[index] = task;
        this.index++;
    }
}