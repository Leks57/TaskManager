package taskmanager;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.GregorianCalendar;
import java.text.ParseException;

import java.time.*;

public class TaskManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Contact man1 = new Contact("Brus", "Willis", 911);
        Contact man2 = new Contact("Jason", "Stathem", 888);
        Contact man3 = new Contact("Jim", "Carrey", 123);
        
        Task task1 = new Task("Позвонить Стэтэму");
        Task task2 = new Task("Позвонить Виллису");
        
        task1.setDescription("Description #1");
        task2.setDescription("Description #2");

        LocalDateTime date1 = LocalDateTime.of(2016, 10, 10, 20, 30);
        int year = date1.getYear(); // 2014 
        Month month = date1.getMonth(); // Июнь
        int dom = date1.getDayOfMonth(); // 10 
        DayOfWeek dow = date1.getDayOfWeek(); // Вторник
        
        int hour = date1.getHour(); // 20 
        int minute = date1.getMinute(); // 30
        
        //int len = date1.lengthOfMonth(); // 30 (дней в Июне) 
        //boolean leap = date1.isLeapYear(); // false (не високосный год) 
        System.out.println(hour);

    }
    
}
