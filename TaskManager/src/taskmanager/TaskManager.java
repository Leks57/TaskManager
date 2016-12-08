package taskmanager;

import java.io.File;

public class TaskManager {

    public static void main(String[] args) {

        TaskList tasks = new TaskList();
        File file = new File("C:\\test.xml");
        if (file.exists()) {
            Xml.readXml("C:\\test.xml", tasks);
        } else {
            System.out.println("Файл не существует.");
        }
        
        
   
        Menu menu = new Menu();
        
        // Добавляем пункт меню PrintTasks
        menu.getEntries().add(new MenuEntry("2 - PrintTasks") {
            @Override
            public void run() {
                /*for (int i=0; i<25; i++)
                System.out.println();
                System.out.println("Текущие задачи:");
                tasks.printTasks(tasks);*/
                for (int i=0; i<25; i++)
                System.out.println();
                Xml.read("C:\\test.xml");
            }
        });
        
        // Добавляем пункт меню CreateTask
        menu.getEntries().add(new MenuEntry("3 - CreateTask") {
            @Override
            public void run() {
                tasks.createTask(tasks);
                Xml.saveXml(tasks, "C:\\test.xml");
            }
        });
        
        // Добавляем пункт меню editTask
        menu.getEntries().add(new MenuEntry("4 - EditTask") {
            @Override
            public void run() {
                Xml.editTask("C:\\test.xml", 1);
            }
        });
        
        // Добавляем пункт меню saveTaskList
        menu.getEntries().add(new MenuEntry("5 - SaveTaskList") {
            @Override
            public void run() {
                Xml.saveXml(tasks, "C:\\test.xml");
            }
        });
        
        menu.run();
        

    }
    
}