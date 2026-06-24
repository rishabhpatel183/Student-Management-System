package com.rishabh.sms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    public void addStudent(String name, int age, String course) {

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "INSERT INTO students(name, age, course) VALUES(?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);

            ps.executeUpdate();

            System.out.println("Student Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewStudents() {

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM students";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== STUDENT RECORDS =====");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getInt("age") + " | " +
                                rs.getString("course")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchStudent(int id) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM students WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\n===== STUDENT FOUND =====");

                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getInt("age") + " | " +
                                rs.getString("course")
                );

            } else {

                System.out.println("Student Not Found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(int id, String name, int age, String course) {

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "UPDATE students SET name = ?, age = ?, course = ? WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);
            ps.setInt(4, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("Student Updated Successfully!");

            } else {

                System.out.println("Student Not Found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "DELETE FROM students WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("Student Deleted Successfully!");

            } else {

                System.out.println("Student Not Found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}