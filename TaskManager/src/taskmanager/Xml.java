
package taskmanager;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.util.Scanner;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public abstract class Xml {
    public static void read(String pathFile) {
    
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse (new File(pathFile));

            // normalize text representation
            doc.getDocumentElement().normalize();
            System.out.println ("Root element of the doc is " + 
                 doc.getDocumentElement().getNodeName());

            NodeList listOfTasks = doc.getElementsByTagName("Задача");
            int totalTasks = listOfTasks.getLength();
            System.out.println("Общее кол-во задач: " + totalTasks);
            
            for(int s=0; s<totalTasks; s++){
                Node taskNode = listOfTasks.item(s);
                if(taskNode.getNodeType() == Node.ELEMENT_NODE){
                    Element firstTask = (Element)taskNode;
                    
                    if ((firstTask.getElementsByTagName("Название")).getLength() != 0){
                        System.out.println("Задача: " +(firstTask.getElementsByTagName("Название").item(0)).getTextContent());
                    }
                    
                    if ((firstTask.getElementsByTagName("Описание")).getLength() != 0) {
                        System.out.println("        " + (firstTask.getElementsByTagName("Описание").item(0)).getTextContent());
                    }

                    if ((firstTask.getElementsByTagName("Дата")).getLength() != 0) {
                        System.out.println("        " + (firstTask.getElementsByTagName("Дата").item(0)).getTextContent());
                    }
                    
                    NodeList listOfContacts = firstTask.getElementsByTagName("Контакт");
                    int totalContacts = listOfContacts.getLength();
                    System.out.println("        " + "Общее кол-во контактов: " + totalContacts);
                        for(int с=0; с<totalContacts; с++){
                            Node contactNode = listOfContacts.item(с);
                            if(contactNode.getNodeType() == Node.ELEMENT_NODE){
                                Element firstContact = (Element)contactNode;
                                
                                if ((firstContact.getElementsByTagName("Имя")).getLength() != 0){
                                    System.out.println("        Контакт:" + (firstContact.getElementsByTagName("Имя").item(0)).getTextContent());
                                }
                                
                                if ((firstContact.getElementsByTagName("Фамилия")).getLength() != 0){
                                    System.out.println("                " + (firstContact.getElementsByTagName("Фамилия").item(0)).getTextContent());
                                }
                                
                                if ((firstContact.getElementsByTagName("Телефон")).getLength() != 0){
                                    System.out.println("                " + (firstContact.getElementsByTagName("Телефон").item(0)).getTextContent());
                                }
                            }
                        }
                }
                }
            }catch (SAXParseException err) {
        System.out.println ("** Parsing error" + ", line " 
             + err.getLineNumber () + ", uri " + err.getSystemId ());
        System.out.println(" " + err.getMessage ());

        }catch (SAXException e) {
        Exception x = e.getException ();
        ((x == null) ? e : x).printStackTrace ();

        }catch (Throwable t) {
        t.printStackTrace ();
        }
}
    /*
public static void save(String pathFile) {
    try {   
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true);
    Document doc = factory.newDocumentBuilder().newDocument();

    Element root = doc.createElement("Задачи");
    doc.appendChild(root);

    Element taskNo1 = doc.createElement("Задача");
    root.appendChild(taskNo1);
    
    Element taskName = doc.createElement("Название");
    taskName.appendChild(doc.createTextNode("Название задачи 1"));
    Element taskDescription = doc.createElement("Описание");
    taskDescription.appendChild(doc.createTextNode("Описание задачи 1"));
    Element taskDate = doc.createElement("Дата");
    taskDate.appendChild(doc.createTextNode("Дата задачи 1"));
    Element taskContact = doc.createElement("Контакт");
    
    Element taskContactName = doc.createElement("Имя");
    taskContactName.appendChild(doc.createTextNode("Имя 1"));
    Element taskContactSurname = doc.createElement("Фамилия");
    taskContactSurname.appendChild(doc.createTextNode("Фамилия 1"));
    Element taskContactPhone = doc.createElement("Телефон");
    taskContactPhone.appendChild(doc.createTextNode("Телефон 1"));
    
    taskContact.appendChild(taskContactName);
    taskContact.appendChild(taskContactSurname);
    taskContact.appendChild(taskContactPhone);
    
    taskNo1.appendChild(taskName);
    taskNo1.appendChild(taskDescription);
    taskNo1.appendChild(taskDate);
    taskNo1.appendChild(taskContact);
    
    File file = new File(pathFile);
 
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    transformer.transform(new DOMSource(doc), new StreamResult(file));
    } catch (Exception e) {
        e.printStackTrace();
      }
}
*/


public static void editTask(String pathFile, int taskNo) {
    try {
        
    DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
    Document doc = docBuilder.parse (new File(pathFile));

    // normalize text representation
    doc.getDocumentElement().normalize();
    Element root = doc.getDocumentElement();

    NodeList listOfTasks = doc.getElementsByTagName("Задача");
            
                Node taskNode = listOfTasks.item(taskNo-1);
                if(taskNode.getNodeType() == Node.ELEMENT_NODE){
                    Element firstTask = (Element)taskNode;
                    (firstTask.getElementsByTagName("Название").item(0)).setTextContent("3455");
                    
                }
    File file = new File(pathFile);
 
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    transformer.transform(new DOMSource(doc), new StreamResult(file));
    } catch (Exception e) {
        e.printStackTrace();
      }
}


public static void saveXml(TaskList taskList, String pathFile) {
        
        
    try {    

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true);
    Document doc = factory.newDocumentBuilder().newDocument();

    Element root = doc.createElement("Задачи");
    doc.appendChild(root);
    
    for(Task t: taskList.getTasks()){

            Element taskName = doc.createElement("Название");
            taskName.appendChild(doc.createTextNode(t.getName()));
            
            Element taskDescription = doc.createElement("Описание");
            taskDescription.appendChild(doc.createTextNode(t.getDescription()));
            
            Element taskDate = doc.createElement("Дата");
            taskDate.appendChild(doc.createTextNode(t.getDate()));
            
            Element taskNo = doc.createElement("Задача");
            
            taskNo.appendChild(taskName);
            taskNo.appendChild(taskDescription);
            taskNo.appendChild(taskDate);
            taskNo.appendChild(taskDate);
            
            for(Contact c: t.contacts){
                
                Element taskContactName = doc.createElement("Имя");
                taskContactName.appendChild(doc.createTextNode(c.getName()));
                
                Element taskContactSurname = doc.createElement("Фамилия");
                taskContactSurname.appendChild(doc.createTextNode(c.getSurname()));
                
                Element taskContactPhone = doc.createElement("Телефон");
                taskContactPhone.appendChild(doc.createTextNode(String.valueOf(c.getPhone())));
                
                Element taskContact = doc.createElement("Контакт");
                taskContact.appendChild(taskContactName);
                taskContact.appendChild(taskContactSurname);
                taskContact.appendChild(taskContactPhone);
                taskNo.appendChild(taskContact);
                
            }
            root.appendChild(taskNo);
    }
    
    
    
    File file = new File(pathFile);
 
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    transformer.transform(new DOMSource(doc), new StreamResult(file));
    } catch (Exception e) {
        e.printStackTrace();
      }
    }


    public static void readXml(String pathFile, TaskList tasks) {
    
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse (new File(pathFile));

            // normalize text representation
            doc.getDocumentElement().normalize();
            //System.out.println ("Root element of the doc is " + 
            //     doc.getDocumentElement().getNodeName());

            NodeList listOfTasks = doc.getElementsByTagName("Задача");
            int totalTasks = listOfTasks.getLength();
            //System.out.println("Общее кол-во задач: " + totalTasks);
            
            for(int s=0; s<totalTasks; s++){
                Node taskNode = listOfTasks.item(s);
                if(taskNode.getNodeType() == Node.ELEMENT_NODE){
                    Element firstTask = (Element)taskNode;
                    
                    Task task1 = new Task();
                    if ((firstTask.getElementsByTagName("Название")).getLength() != 0){
                        task1.setName((firstTask.getElementsByTagName("Название").item(0)).getTextContent());
                    }
                    
                    if ((firstTask.getElementsByTagName("Описание")).getLength() != 0) {
                        task1.setDescription((firstTask.getElementsByTagName("Описание").item(0)).getTextContent());
                    }

                    if ((firstTask.getElementsByTagName("Дата")).getLength() != 0) {
                        task1.setDate((firstTask.getElementsByTagName("Дата").item(0)).getTextContent());
                    }
                    
                    NodeList listOfContacts = firstTask.getElementsByTagName("Контакт");
                    int totalContacts = listOfContacts.getLength();
                    //System.out.println("        " + "Общее кол-во контактов: " + totalContacts);
                        for(int с=0; с<totalContacts; с++){
                            Node contactNode = listOfContacts.item(с);
                            Contact contact1 = new Contact();
                            
                            if(contactNode.getNodeType() == Node.ELEMENT_NODE){
                                Element firstContact = (Element)contactNode;
                                
                                if ((firstContact.getElementsByTagName("Имя")).getLength() != 0){
                                    contact1.setName((firstContact.getElementsByTagName("Имя").item(0)).getTextContent());
                                }
                                
                                if ((firstContact.getElementsByTagName("Фамилия")).getLength() != 0){
                                    contact1.setSurname((firstContact.getElementsByTagName("Фамилия").item(0)).getTextContent());
                                }
                                
                                if ((firstContact.getElementsByTagName("Телефон")).getLength() != 0){
                                    contact1.setPhone(Integer.parseInt((firstContact.getElementsByTagName("Телефон").item(0)).getTextContent()));
                                }
                                
                                task1.addContact(contact1);
                            }
                        }
                        tasks.addTask(task1);
                }
                }
            }catch (SAXParseException err) {
        System.out.println ("** Parsing error" + ", line " 
             + err.getLineNumber () + ", uri " + err.getSystemId ());
        System.out.println(" " + err.getMessage ());

        }catch (SAXException e) {
        Exception x = e.getException ();
        ((x == null) ? e : x).printStackTrace ();

        }catch (Throwable t) {
        t.printStackTrace ();
        }
}


}


