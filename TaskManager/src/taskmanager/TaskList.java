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
    
    public void editTask() {
        PrintLine.line();
        for(Task t: this.tasks){
        System.out.println(tasks.indexOf(t) + " - " + t.getName());
        }
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер выбранной задачи: ");
        int taskNumber = sc.nextInt();
        tasks.get(taskNumber).printTask();
        
        System.out.println("Введите номер данных для изменения: ");
        System.out.println("1 - Название задачи");
        System.out.println("2 - Описание задачи");
        System.out.println("3 - Дата события");
        System.out.println("0 - Выход");
        boolean notExit = true;
        while(notExit) {
        int userChoice = sc.nextInt();
        switch(userChoice) {
          case 1: tasks.get(taskNumber).setName(sc.nextLine()); break;
          case 2: tasks.get(taskNumber).setDescription(sc.nextLine()); break;
          case 3: tasks.get(taskNumber).setDate(sc.nextLine()); break;
       //   case 4: tasks.get(taskNumber).addContact(sc.nextLine()); break;
          case 0: notExit = false; break;
        } // switch
      }
    }
}