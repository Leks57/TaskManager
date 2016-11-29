package taskmanager;

import java.util.*;

public class TaskList {
    
    private List<Task> tasks = new ArrayList<Task>();

    public TaskList() {}
    
    public void addTask(Task task) {
       this.tasks.add(task);
    }
    
    public void printTasks(TaskList taskList) {
        for(Task t: taskList.tasks){
        t.printTask();
        }
    }
    
}