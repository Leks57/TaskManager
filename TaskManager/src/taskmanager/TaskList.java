package taskmanager;

import java.util.*;

public class TaskList {
    
    private static List<Task> tasks = new ArrayList<Task>();

    public static List<Task> getTasks() {
        return tasks;
    }

    public TaskList() {}
    
    public static void addTask(Task task) {
       tasks.add(task);
    }
    
    public void printTasks() {
        for(Task t: this.tasks){
        t.printTask();
        }
    }
    
    public void createTask() {
        Scanner sc = new Scanner(System.in);
        Task task = new Task();
        System.out.println("Введите название задачи: ");
        task.setName(sc.nextLine());
        System.out.println("Введите описание задачи: ");
        task.setDescription(sc.nextLine());
        System.out.println("Введите дату задачи: ");
        task.setDate(sc.nextLine());
        
        Contact contact = new Contact();
        System.out.println("Введите имя контакта: ");
        contact.setName(sc.nextLine());
        System.out.println("Введите фамилию контакта: ");
        contact.setSurname(sc.nextLine());
        System.out.println("Введите телефон контакта: ");
        contact.setPhone(sc.nextInt());
        
        task.addContact(contact);
        addTask(task);
    }
}