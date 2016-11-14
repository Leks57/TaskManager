package taskmanager;

public class Contact {
    String name;
    String surname;
    int phone;
    
    public Contact(String name, String surname, int phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }
    
    public void printContact() {
        System.out.println(this.name + " " + this.surname + ", телефон: " + this.phone);
    }
}