package com.harman.database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class Company {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a;
        while(true){
            System.out.println("Select an option");
            System.out.println("1.Add employee");
            System.out.println("2.View Employee");
            System.out.println("3.Exit");
            a = input.nextInt();
            switch (a){
                case 1:
                    System.out.println("Add employee");
                try {
                    Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/company?autoReconnect=true&useSSL=false","root","");
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
                    Statement stmt = (Statement) c.createStatement();
                    stmt.executeUpdate("INSERT INTO `employee`(`employee code`, `name`, `designation`, `salary`, `mobileno`) " +
                            "VALUES("+empcode+",'"+name+"','"+desig+"',"+salary+","+mobno+")");
                    System.out.println("Inserted successfully");
                }
                catch (Exception e){
                    System.out.println(e);
                }break;
                case 2:
                    System.out.println("The employee data:");
                    try{Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/company?autoReconnect=true&useSSL=false","root","");
                    Statement stmt = (Statement) c.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM `employee` WHERE 1");
                    while(rs.next()){
                        System.out.println("Employee code :"+rs.getInt("employee code"));
                        System.out.println("Name :"+rs.getString("name"));
                        System.out.println("Designation :"+rs.getString("designation"));
                        System.out.println("Salary :"+rs.getInt("salary"));
                        System.out.println("Mobile number :"+rs.getBigDecimal("mobileno"));
                    }
                }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }

        }

    }
}
