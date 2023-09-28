package org.example;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true){
            //CreateDB();
            System.out.println("Chose action");
            System.out.println("(1) Add student");
            System.out.println("(2) Update student");
            System.out.println("(3) Delete student");
            System.out.println("(4) List students");

            Scanner scanner = new Scanner(System.in);

            int selection = scanner.nextInt();

            switch (selection){
                case 1:
                    System.out.println("Input name :");
                    String name = scanner.next();
                    System.out.println("Input age :");
                    int age = scanner.nextInt();
                    System.out.println("Input grade :");
                    String grade = scanner.next();
                    HandleStudents.InsertStudent(name,age,grade);
                    break;
                case 2:
                    System.out.println("Input name :");
                    String name1 = scanner.next();
                    System.out.println("Input new age :");
                    int age1 = scanner.nextInt();
                    HandleStudents.UpdateAge(name1,age1);
                    break;
                case 3:
                    System.out.println("Input name :");
                    String name2 = scanner.next();
                    HandleStudents.DeleteStudent(name2);
                    break;
                case 4:
                    HandleStudents.PrintStudents();
                    break;
                default:
                    System.out.println(selection +" is not a valid option");

            }
        }
    }

}