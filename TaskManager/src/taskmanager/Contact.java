package taskmanager;

public class Contact {
    String name;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getPhone() {
        return phone;
    }
    String surname;
    int phone;
    
 /*   public Contact(String name, String surname, int phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }
*/
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
    
    public void printContact() {
        System.out.println(this.name + " " + this.surname + ", телефон: " + this.phone);
    }
}