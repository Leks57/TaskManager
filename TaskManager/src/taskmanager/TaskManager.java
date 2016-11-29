package taskmanager;

import java.util.Scanner;
import java.io.IOException;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException; 

public class TaskManager {

    public static void main(String[] args) {
        
        TaskList tasks = new TaskList();
        
        Contact man1 = new Contact("Brus", "Willis", 911);
        Contact man2 = new Contact("Jason", "Stathem", 888);
        Contact man3 = new Contact("Jim", "Carrey", 123);
        
        Task task1 = new Task("Задача №1");
        Task task2 = new Task("Задача №2");
        
        task1.setDescription("Описание задачи №1");
        task2.setDescription("Описание задачи №2");
        
        task1.setDate("15.11.2016");
        task2.setDate("21.11.2016");
        
        task1.addContact(man1);
        task1.addContact(man2);
        task2.addContact(man3);
        
        tasks.addTask(task1);
        tasks.addTask(task2);
        
        
        Menu menu = new Menu();
        
        // Добавляем пункт меню PrintTasks
        menu.getEntries().add(new MenuEntry("2 - PrintTasks") {
            @Override
            public void run() {
                for (int i=0; i<25; i++)
                System.out.println();
                System.out.println("Текущие задачи:");
                tasks.printTasks(tasks);
            }
        });
        
        
        menu.run();
        
        
try {   
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true);
    Document doc = factory.newDocumentBuilder().newDocument();

    Element root = doc.createElement("Задачи");
    doc.appendChild(root);

    Element item1 = doc.createElement("Задача");
    item1.setAttribute("Название", "1");
    item1.setAttribute("Описание", "1");
    item1.setAttribute("Дата", "1");
    Element contact = doc.createElement("Контакты");
    contact.setAttribute("Контакт1", "1");
    contact.setAttribute("Контакт2", "2");
    item1.appendChild(contact);
    root.appendChild(item1);

    File file = new File("C:\\test.xml");
 
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    transformer.transform(new DOMSource(doc), new StreamResult(file));
    } catch (Exception e) {
        e.printStackTrace();
      }

     
     
     try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse (new File("C:\\test.xml"));

            // normalize text representation
            doc.getDocumentElement().normalize();
            System.out.println ("Root element of the doc is " + 
                 doc.getDocumentElement().getNodeName());

            NodeList listOfTasks = doc.getElementsByTagName("Задача");
            int totalTasks = listOfTasks.getLength();
            System.out.println("Общее кол-во задач: " + totalTasks);
/*
            for(int s=0; s<listOfTasks.getLength() ; s++){
                Node firstTaskNode = listOfTasks.item(s);
                if(firstTaskNode.getNodeType() == Node.ELEMENT_NODE){
                    Element firstPersonElement = (Element)firstTaskNode;
                    //-------
                    NodeList firstNameList = firstPersonElement.getElementsByTagName("Название");
                    Element firstNameElement = (Element)firstNameList.item(0);

                    NodeList textFNList = firstNameElement.getChildNodes();
                    System.out.println("First Name : " + 
                           ((Node)textFNList.item(0)).getNodeValue().trim());   
                    //-------
                    NodeList lastNameList = firstPersonElement.getElementsByTagName("last");
                    Element lastNameElement = (Element)lastNameList.item(0);

                    NodeList textLNList = lastNameElement.getChildNodes();
                    System.out.println("Last Name : " + 
                           ((Node)textLNList.item(0)).getNodeValue().trim());
                    //----
                    NodeList ageList = firstPersonElement.getElementsByTagName("age");
                    Element ageElement = (Element)ageList.item(0);

                    NodeList textAgeList = ageElement.getChildNodes();
                    System.out.println("Age : " + 
                           ((Node)textAgeList.item(0)).getNodeValue().trim());
                    //------
                }//end of if clause
            }//end of for loop with s var */
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
        //System.exit (0);
     
     
    }
    
}
