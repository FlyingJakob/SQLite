package org.example;

import java.sql.*;

public class HandleStudents {



    static void DeleteStudent(String name){

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:school.db");

            String sql = "DELETE FROM students WHERE name = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,name);

            pstmt.executeUpdate();

            conn.close();
            pstmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static void UpdateAge(String name, int newAge){
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:school.db");

            String sql = "UPDATE students SET age = ? WHERE name = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,newAge);
            pstmt.setString(2,name);

            pstmt.executeUpdate();

            conn.close();
            pstmt.close();

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static void PrintStudents()
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:school.db");
            Statement stmt = conn.createStatement();

            String sql = "SELECT name,age FROM students";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("Name : "+ name+" age : "+age);
            }


            stmt.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static void InsertStudent(String name, int age, String grade){

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:school.db");

            String sql = "INSERT INTO students(name,age,grade) VALUES(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,name);
            pstmt.setInt(2,age);
            pstmt.setString(3,grade);

            pstmt.executeUpdate();

            conn.close();
            pstmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static void CreateDB() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:school.db");
            Statement stmt = conn.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS students(" +
                    "id INTERGER PRIMARY KEY," +
                    "name TEXT NOT NULL," +
                    "age INTEGER NOT NULL," +
                    "grade TEXT NOT NULL)";

            stmt.execute(sql);

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }






}
