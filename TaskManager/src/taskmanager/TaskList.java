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
        System.out.println("Текущие задачи:");
        for(Task t: this.tasks){
        System.out.println(tasks.indexOf(t) + 1 + " - " + t.getName());
        }
        
        Scanner scInt = new Scanner(System.in);
        Scanner scLine = new Scanner(System.in);
        System.out.println("Введите номер выбранной задачи: ");
        int taskNumber = scInt.nextInt() - 1;
        PrintLine.line();
        tasks.get(taskNumber).printTask();
        
        System.out.println("Введите номер данных для изменения: ");
        System.out.println("1 - Название задачи");
        System.out.println("2 - Описание задачи");
        System.out.println("3 - Дата события");
        System.out.println("0 - Выход");

        int userChoice = scInt.nextInt();
        PrintLine.line();
        switch(userChoice) {
          case 1: System.out.println("Введите новое название:"); tasks.get(taskNumber).setName(scLine.nextLine()); break;
          case 2: System.out.println("Введите новое описание:"); tasks.get(taskNumber).setDescription(scLine.nextLine()); break;
          case 3: System.out.println("Введите новую дату:"); tasks.get(taskNumber).setDate(scLine.nextLine()); break;
       //   case 4: tasks.get(taskNumber).addContact(sc.nextLine()); break;
          case 0: break;
        } // switch
    }
}