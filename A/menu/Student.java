package collection;


import java.util.Scanner;

public class Student {
    String rollNumber;
    String name;
    int age;
    float mark;

    Scanner scan = new Scanner(System.in);
    public Student(){

    }
    public Student(String rollNumber, String name, int age, float mark) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.mark = mark;
    }
    public String getRollNumber() {
        return rollNumber;
    }
    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public float getMark() {
        return mark;
    }
    public void setMark(float mark) {
        this.mark = mark;
    }
    @Override
    public String toString() {
        return "Student{" +
                "rollNumber='" + rollNumber + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", mark=" + mark +
                '}';
    }
    public void display(){
        System.out.println(toString());
    }
    public void input(){
        System.out.println("Enter roll number student: ");
        rollNumber = scan.nextLine();
        edit();
    }
    public void edit(){
        System.out.println("Enter name student: ");
        name = scan.nextLine();
        System.out.println("Enter age student: ");
        age = Integer.parseInt(scan.nextLine());
        System.out.println("Enter mark student: ");
        mark = Float.parseFloat(scan.nextLine());
    }
    public String getFile(){
        return rollNumber + "," + name + "," + age + "," + mark + "\n";
    }
}




