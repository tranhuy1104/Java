package Lab4;
import java.io.*;
import java.util.Date;

public class ReadWriteObject {
    public static void main(String[] args) throws IOException {
        Date curentDate = new Date();
        //write object
        ObjectOutputStream oos=null;
        try{
            oos =new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("D:\\Download\\New folder\\Data.txt")));
            //Write a String object
            oos.writeObject("The current Date and Time is");
            oos.writeObject(new Date());

            System.out.println("Object writed!");
            oos.flush();
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        //read object
        ObjectInputStream ois = null;
          try{
              ois = new ObjectInputStream(new FileInputStream("D:\\Download\\New folder\\Data.txt"));



              System.out.println("The data read from file: " + curentDate);
              ois.close();

          }catch (Exception e){
              e.printStackTrace();
          }
    }

}
