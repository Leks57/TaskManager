package taskmanager;

import java.util.*;

public class Task implements SetTask {
    String name;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }
    String description;
    String date;
    List<Contact> contacts = new ArrayList<Contact>();

    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public void setDate(String date) {
        this.date = date;
    }
    
    @Override
    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }
    
    public void printContacts() {
        for(Contact t: contacts){
        t.printContact();
        }
    }
    
    public void printTask() {
        System.out.println(this.name);
        System.out.println(this.description);
        System.out.println("Напоминание: " + this.date);
        this.printContacts();
    }
    
}