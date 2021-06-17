package collection;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Studenttest {




    public static class StudentTest {
        static Scanner scan = new Scanner(System.in);
        static List<Student> studentList = new ArrayList<>();
        public static void main(String[] args) throws IOException {
            int choose,n;
            String s;
            do{
                menu();
                System.out.println("Choose: ");
                choose = Integer.parseInt(scan.nextLine());
                switch (choose){
                    case 1:
                        System.out.println("Enter number student: ");
                        n = Integer.parseInt(scan.nextLine());
                        for (int i = 0; i < n; i++){
                            Student student = new Student();
                            student.input();

                            studentList.add(student);
                        }
                        break;
                    case 2:
                        System.out.println("Enter roll number sutdent update: ");
                        s = scan.nextLine();
                        for (Student std : studentList){
                            if (std.getRollNumber().equalsIgnoreCase(s)){
                                std.edit();
                            }
                            else {
                                System.out.println("Not found!");
                                break;
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Enter roll number sutdent delete: ");
                        s = scan.nextLine();
                        for(int i = 0; i < studentList.size(); i++){
                            if (studentList.get(i).getRollNumber().equalsIgnoreCase(s)){
                                studentList.remove(i);
                                System.out.println("Delete successfully!!!");
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Enter roll number sutdent search: ");
                        s = scan.nextLine();
                        for(int i = 0; i < studentList.size(); i++){
                            if (studentList.get(i).getRollNumber().equalsIgnoreCase(s)){
                                studentList.get(i).display();
                                break;
                            }
                            else {
                                break;
                            }
                        }
                        break;
                    case 5:
                        for (Student std : studentList){
                            std.display();
                        }
                        break;
                    case 6:
                        System.out.println("Start save file");
                        FileOutputStream fos = null;

                        try {
                            fos = new FileOutputStream("D:\\Download\\New folder\\Account.txt",true);
                            for (Student std : studentList) {
                                fos.write(std.getFile().getBytes(StandardCharsets.UTF_8));
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (Exception e){ }
                        finally {
                            if (fos != null){
                                try{
                                    fos.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        break;
                    case 7:
                        FileInputStream fis = null;
                        InputStreamReader isr = null;
                        BufferedReader bis = null;
                        try {
                            fis = new FileInputStream("D:\\Download\\New folder\\Account.txt");
                            isr = new InputStreamReader(fis,StandardCharsets.UTF_8);
                            bis = new BufferedReader(isr);
                            String ch = "";
                            while ((ch = bis.readLine()) != ""){
                                Student std = new Student();

                                String[] a = ch.split(",");
                                std.rollNumber = a[0];
                                std.name = a[1];
                                std.age = Integer.parseInt(a[2]);
                                std.mark = Float.parseFloat(a[3]);
                                System.out.println(ch);

                                studentList.add(std);
                            }

                        }catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (Exception e){ }
                        finally {
                            try{
                                if (bis != null){
                                    bis.close();
                                }
                                if(isr != null){
                                    isr.close();
                                }
                                if(fis != null){
                                    fis.close();
                                }
                            } catch (Exception e){

                            }
                        }
                        break;
                    case 8:
                        System.out.println("Good bye!");
                        break;
                    default:
                        System.out.println("Invalid!!!");
                        break;

                }
            }while (choose != 8);
        }
        static void menu(){
            System.out.println("1.Add student ");
            System.out.println("2.update a student ");
            System.out.println("3.delete a student ");
            System.out.println("4.search student ");
            System.out.println("5.display add student ");
            System.out.println("6.save to file ");
            System.out.println("7.Load to file ");
            System.out.println("8.Exit ");
        }
    }
}
