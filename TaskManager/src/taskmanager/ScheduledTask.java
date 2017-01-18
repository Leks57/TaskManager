package taskmanager;

import java.text.ParseException;
import java.util.Date;
import java.util.TimerTask;
import java.util.Timer;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Locale;
 
public class ScheduledTask extends TimerTask {
    
   public static Date alarm;
    public void toDo() throws ParseException {
    try {
    Date now;
    SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
    String dateInString = "2017-01-18 16:25:30";
    alarm = dateFormat.parse(dateInString);
    } catch (ParseException e) {
        e.printStackTrace();
    }
    }

    
    // Добавляем такс
    @Override
    public void run() {
        Date now = new Date();
        System.out.println("Время начала работы таймера: " + now);
        try {
            toDo();
        } catch (ParseException ex) {
            Logger.getLogger(ScheduledTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(true) {
                now = new Date();
                Thread.sleep(1000);
                if (now.compareTo(alarm) >= 0) {
                    System.out.println("Напоминание сработало: " + now);
                    System.out.println("Now " + now);
                    System.out.println("Alarm " + alarm);
                    break;
                }
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
 
    
    public static void start() {
 
        
        Timer time = new Timer();
        TimerTask currentTask = new ScheduledTask();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, 50);
        Date date = calendar.getTime();
        time.schedule(currentTask, alarm); // void schedule (TimerTask task, Date when)
        }
        
   /*     catch (InterruptedException err) {
        System.out.println ("** Parsing error" + ", line " 
             + err.getLineNumber () + ", uri " + err.getSystemId ());
        System.out.println(" " + err.getMessage ());
    }*/

}
