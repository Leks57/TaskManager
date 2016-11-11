package taskmanager;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Task implements SetTask {
    private int MAX_CONTACTS = 5;
    private int index = 0;
    String name;
    String description;
    Calendar date;
    Contact[] contacts = new Contact[MAX_CONTACTS];
    
    public Task(String name) {
        this.name = name;
    }
    
    
    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public void setDate(Calendar date) {
        this.date = date;
    }
    
    @Override
    public void addContact(Contact contact) {
        this.contacts[index] = contact;
        this.index++;
    }
    
}