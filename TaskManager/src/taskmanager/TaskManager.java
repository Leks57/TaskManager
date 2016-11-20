package taskmanager;

import java.util.Scanner;

public class TaskManager {

    public static void main(String[] args) {

        TaskList tasks = new TaskList("Tasks");
        
        Contact man1 = new Contact("Brus", "Willis", 911);
        Contact man2 = new Contact("Jason", "Stathem", 888);
        Contact man3 = new Contact("Jim", "Carrey", 123);
        
        Task task1 = new Task("Задача №1");
        Task task2 = new Task("Задача №2");
        
        task1.setDescription("Описание задачи №1");
        task2.setDescription("Описание задачи №2");
        
        task1.setDate("15.11.2016");
        task2.setDate("21.11.2016");
        
        task1.addContact(man1);
        task1.addContact(man2);
        task2.addContact(man3);
        
        tasks.addTask(task1);
        tasks.addTask(task2);
        
        tasks.printTasks();
    }
    
}
