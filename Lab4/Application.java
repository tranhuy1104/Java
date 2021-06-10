package ByteStream;

import java.util.Scanner;

public class Application {
    public Application(){

    }
    public static void main(String[] args) {
       Account account=new Account();
        Scanner scanner=new Scanner(System.in);
        int action=0;
        do{
            System.out.println("\n\t\t***MENU***");
            System.out.println("1.Create a new Account");
            System.out.println("2.loading list of Students from a File");
            System.out.println("3.Exit");
            System.out.println("Your choice: ");
            action=scanner.nextInt();
            switch (action){
                case 1:
                    account.addAccount();
                    break;
                case 2:
                    account.display();
                    break;
                case 3: break;

                default:
                    System.out.println("Your chole");
                    break;
            }
        }while (action!=3);
    }
}
