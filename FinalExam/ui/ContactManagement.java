package FinalExam.ui;
import FinalExam.db.ContactAccessor;
import FinalExam.entity.Contact;
import java.util.*;
public class ContactManagement {

    ContactAccessor contactAccessor = new ContactAccessor();
    Scanner scanner = new Scanner(System.in);


    public ContactManagement() {

    }

    public static void main(String[] args) {
        ContactAccessor contactAccessor = new ContactAccessor();
        ContactManagement contactManagement = new ContactManagement();
        Contact contact = new Contact();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n------------------ MENU ---------------------");
            System.out.println(" Enter 1 : To add new contact");
            System.out.println(" Enter 2 : To find a contact by name");
            System.out.println(" Enter 3 : To display all contacts");
            System.out.println(" Enter 4 : Exit");
            System.out.println("\nEnter your choice :");
            String choice = input.nextLine();
            switch (choice) {
                case "1":
                    contactManagement.addContact();
                    break;
                case "2":
                    contactManagement.findByName();
                    break;
                case "3":
                    contactManagement.displayAll();
                    break;
                case "4":
                    System.out.println("\nThank you ! See you again !");
                    return;
                default:
                    System.out.println(" Invalid choice !");
                    continue;

            }
        }
    }

    public void addContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Contact name :");
        String contactName = scanner.next();
        System.out.println("Company name :");
        String company = scanner.next();
        System.out.println(" Email :");
        String email = scanner.next();
        System.out.println("Phone number :");
        String phone = scanner.next();
        Contact contact = new Contact();
        contact.setContactName(contactName);
        contact.setContactName(company);
        contact.setContactName(email);
        contact.setContactName(phone);

        ContactAccessor contactAccessor = new ContactAccessor();
        try {
            contactAccessor.insert(contact);
            System.out.println("\nInsert success !");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void findByName() {
        try {
            System.out.println("Enter contact name :");
            String contactName = scanner.next();
            List<Contact> contactList = contactAccessor.getByName(contactName);
            contactList.forEach(contact -> {

                System.out.println("Contact name \t\t  Company  \t\t  Email address  \t\t  Phone Number \t\t");
                System.out.println(contact.getContactName() + "\t\t" + contact.getCompany() +"\t\t"+contact.getEmail()+"\t\t" +contact.getPhone());

            });

        }catch (Exception ex){
            System.out.println("Not found !");
            ex.printStackTrace();
        }
    }

    public void displayAll(){
        try{
            System.out.println("---------- Show all students -----------");
            String name ="";
            List<Contact> contactList = contactAccessor.getContacts(name);
            contactList.forEach(contact -> {

                System.out.println("Contact name \t\t  Company  \t\t  Email address  \t\t  Phone Number \t\t");
                System.out.println(contact.getContactName() + "\t\t" + contact.getCompany() +"\t\t"+contact.getEmail()+"\t\t" +contact.getPhone());

            });
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
