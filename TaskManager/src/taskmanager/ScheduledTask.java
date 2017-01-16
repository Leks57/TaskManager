package taskmanager;

import java.util.Date;
import java.util.TimerTask;
import java.util.Timer;
import java.util.Calendar;
 
public class ScheduledTask extends TimerTask {
 
    Date now;
 
    // Добавляем такс
    @Override
    public void run() {
        now = new Date();
        System.out.println("Текущая задача: " + now);
    }
 
    
    public static void start() {
 
        
        Timer time = new Timer();
        ScheduledTask currentTask = new ScheduledTask();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, 31);
        Date date = calendar.getTime();
        time.schedule(currentTask, date); // void schedule (TimerTask task, Date when)
        }
        
   /*     catch (InterruptedException err) {
        System.out.println ("** Parsing error" + ", line " 
             + err.getLineNumber () + ", uri " + err.getSystemId ());
        System.out.println(" " + err.getMessage ());
    }*/
    
    
    
}

