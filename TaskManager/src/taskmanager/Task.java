package taskmanager;

public class Task implements SetTask {
    private int MAX_CONTACTS = 5;
    private int index = 0;
    String name;
    String description;
    String date;
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
    public void setDate(String date) {
        this.date = date;
    }
    
    @Override
    public void addContact(Contact contact) {
        this.contacts[index] = contact;
        this.index++;
    }
    
    public void printTask() {
        System.out.println(this.name);
        System.out.println(this.description);
        System.out.println("Напоминание: " + this.date);
        for (int i = 0; i < index; i++) {
            contacts[i].printContact();
        }
    }
    
}