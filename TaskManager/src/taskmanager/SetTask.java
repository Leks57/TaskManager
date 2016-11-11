package taskmanager;

import java.util.Date;
import java.util.Calendar;

public interface SetTask {
    void setName(String name);
    void setDescription(String description);
    void setDate(Calendar date);
    void addContact(Contact contact);
}
