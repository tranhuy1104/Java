package jdbcrework.ui;
import jdbcrework.db.PersonAccessor;
import jdbcrework.entity.Person;
import java.util.*;
import java.io.*;
public class PersonManagement {

    PersonAccessor personAccessor = new PersonAccessor();
    Scanner scan = new Scanner(System.in);
    Person person = new Person();

    public PersonManagement(){

    }

    public  void main(String[] args) {

        ArrayList<Person> people = new ArrayList<Person>();
        Person person = new Person();
        Scanner input = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("\n ------------------- MENU -------------------");
            System.out.println(" Enter 1 : To add Person.");
            System.out.println(" Enter 2 : To delete Person.");
            System.out.println(" Enter 3 : To update Person.");
            System.out.println(" Enter 4 : To search Person through Id .");
            System.out.println(" Enter 5 : To display all persons.");
            System.out.println(" Enter 6 : To exit .");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                   insert();
                    break;
                case 2:
                   // removeAll();
                    break;
                case 3:
                    try{
                        personAccessor.update(person);
                    }catch(Exception ex){

                    }
                    break;
                case 4:
                    findById(12);
                    break;
                case 5:
                   try{
                       showAll();
                   }catch ( Exception ex){

                   }
                                       break;
                case 6:
                    System.out.println("\nThank you ! See you again !");
                    return;
                default:
                    System.out.println(" Invalided choice !");
                    continue;
            }
        }
    }

    public void showAll() {
        try {

            System.out.println("------ Show all people ------");
            String name = "";
            List<Person> personList = personAccessor.getPersons(name);
            personList.forEach(person -> {
                System.out.println(person.getId() + "\t" + person.getName());
            });
        }catch (Exception ex){

        }
    }

    public  void insert(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Person's name :");
        String name = scan.nextLine();
        Person person = new Person();
        person.setName(name);
        PersonAccessor personAccessor = new PersonAccessor();
        try{
            personAccessor.insert(person);
        }catch (Exception ex){

        }
    }

    public void findById(int id){
        System.out.println("ID : ");
        int id = Integer.parseInt(scan.nextLine());
        try{
           person =  personAccessor.findByPrimaryKey(id);
        }catch(Exception ex){

        }
    }

}
