package ByteStream;

import java.io.*;
import java.util.Scanner;

public class Account {
    private  String fristName;
    private  String lastName;
    private  int age;
    private  float accountBalance;

    public Account(){

    }
    public Account(String fristName,String lastName,int age,float accountBalance){
        this.fristName=fristName;
        this.lastName=lastName;
        this.age=age;
        this.accountBalance=accountBalance;
    }
    public void addAccount() {
        //Scanner
        Scanner scanner=new Scanner(System.in);
        System.out.println("Firt Name: ");

        this.fristName=scanner.nextLine();
        System.out.println("last Name: ");
        this.lastName=scanner.nextLine();
        System.out.println("Age: ");
        this.age=scanner.nextInt();
        System.out.println("AccountBalance: ");
        this.accountBalance=scanner.nextFloat();
        this.saveState();
        System.out.println("Add new Account DONE!");
    }
    public void saveState() {
        //bufferedWirte


        try{
            FileWriter fileWriter= new FileWriter(new File("D:\\Download\\New folder\\Account.txt"));
            BufferedWriter bufferedWriter= null;
            bufferedWriter= new BufferedWriter(fileWriter);
            bufferedWriter.write(this.fristName);
            bufferedWriter.write("\t");

            bufferedWriter.write(this.lastName);
            bufferedWriter.write("\t");
            bufferedWriter.write(Integer.toString(this.age));
            bufferedWriter.write("\t");
            bufferedWriter.write(Float.toString(this.accountBalance));
            bufferedWriter.write("\t");
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();

        }catch (FileNotFoundException f){
            f.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }


    }
    public void display(){
        //bufferedReaed
        System.out.println("Account Detail: ");
        try {
            FileReader fileReader=new FileReader("D:\\Download\\New folder\\Account.txt");
            BufferedReader bufferedReader=new BufferedReader(fileReader);

            System.out.println("Firt Name: " + this.fristName);
            System.out.println("Last Name: " +this.lastName);
            System.out.println("Age: " +this.age);
            System.out.println(" Balance:" +this.accountBalance);
             bufferedReader.close();
             fileReader.close();



        }catch (FileNotFoundException f){
            f.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        System.out.println("Your account infonation!!!");
    }
}
