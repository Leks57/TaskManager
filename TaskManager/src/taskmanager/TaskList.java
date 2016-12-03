package taskmanager;

import java.util.*;

public class TaskList {
    
    private List<Task> tasks = new ArrayList<Task>();

    public List<Task> getTasks() {
        return tasks;
    }

    public TaskList() {}
    
    public void addTask(Task task) {
       this.tasks.add(task);
    }
    
    public void printTasks(TaskList taskList) {
        for(Task t: taskList.tasks){
        t.printTask();
        }
    }
    
    public void createTask(TaskList tasks) {
        Scanner sc = new Scanner(System.in);
        Task task1 = new Task();
        System.out.println("Введите название задачи: ");
        task1.setName(sc.nextLine());
        System.out.println("Введите описание задачи: ");
        task1.setDescription(sc.nextLine());
        System.out.println("Введите дату задачи: ");
        task1.setDate(sc.nextLine());
        
        Contact contact1 = new Contact();
        System.out.println("Введите имя контакта: ");
        contact1.setName(sc.nextLine());
        System.out.println("Введите фамилию контакта: ");
        contact1.setSurname(sc.nextLine());
        System.out.println("Введите телефон контакта: ");
        contact1.setPhone(sc.nextInt());
        
        task1.addContact(contact1);
        tasks.addTask(task1);
    }
}