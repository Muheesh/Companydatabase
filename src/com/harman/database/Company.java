package com.harman.database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.util.Scanner;

public class Company {
    public static void main(String[] args) {
        try {
            Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/company?autoReconnect=true&useSSL=false","root","");
            Scanner input = new Scanner(System.in);
            String empcode,name,desig,salary,mobno;
            System.out.println("Enter the following details");
            System.out.println("employee code");
            empcode = input.next();
            System.out.println("Employee name");
            name = input.next();
            System.out.println("Designation of employee");
            desig = input.next();
            System.out.println("Salary:");
            salary = input.next();
            System.out.println("Mobile number");
            mobno = input.next();
            Statement a = (Statement) c.createStatement();
            a.executeUpdate("INSERT INTO `employee`(`employee code`, `name`, `designation`, `salary`, `mobileno`) " +
                    "VALUES("+empcode+",'"+name+"','"+desig+"',"+salary+","+mobno+")");
            System.out.println("Inserted successfully");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
