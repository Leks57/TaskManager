package taskmanager;

import java.io.File;

public class TaskManager {

    private static final String pathFile = "C:\\test.xml";

    public static String getPathFile() {
        return pathFile;
    }
        
    public static void main(String[] args) {

        TaskList tasks = new TaskList();
        File file = new File("C:\\test.xml");
        if (file.exists()) {
            Xml.readXml();
        } else {
            System.out.println("Файл не существует.");
        }
        
        
   
        Menu menu = new Menu();
        
        // Добавляем пункт меню PrintTasks
        menu.getEntries().add(new MenuEntry("2 - PrintTasks") {
            @Override
            public void run() {
                tasks.printTasks();
            }
        });
        
        // Добавляем пункт меню CreateTask
        menu.getEntries().add(new MenuEntry("3 - CreateTask") {
            @Override
            public void run() {
                tasks.createTask();
                Xml.saveXml();
            }
        });
        
        // Добавляем пункт меню editTask
        menu.getEntries().add(new MenuEntry("4 - EditTask") {
            @Override
            public void run() {
            tasks.editTask();
            }
        });
        
        // Добавляем пункт меню saveTaskList
        menu.getEntries().add(new MenuEntry("5 - SaveTaskList") {
            @Override
            public void run() {
                Xml.saveXml();
            }
        });
        
        // Добавляем пункт меню Timer
        menu.getEntries().add(new MenuEntry("6 - Timer") {
            @Override
            public void run() {
                ScheduledTask.start();
            }
        });        
        
        menu.run();
        

    }
    
}
