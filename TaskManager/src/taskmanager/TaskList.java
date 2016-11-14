package taskmanager;

import java.util.ArrayList;

public class TaskList {
    
    private ArrayList<Task> tasks = new ArrayList<Task>();
    String name;
    
    public TaskList(String name) {
        this.name = name;
    }
    
    public void addTask(Task task) {
       tasks.add(task);
    }
    
    public void printTasks() {
        for(Task t: tasks){
        t.printTask();
        }
    }
    
}