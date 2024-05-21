package com.example.focus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbc {
    Connection databaselink;
    Connection habdb;
    public Connection getConnection(){
        String DatabaseName="Focus";
        String DatabaseUser="root";
        String DatabasePassword="admin";
        String url="jdbc:mysql://localhost/"+DatabaseName;
       // String url1="jdbc:mysql://localhost/"+"Focus";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaselink=DriverManager.getConnection(url,DatabaseUser,DatabasePassword);
            //habdb=DriverManager.getConnection(url1,DatabaseUser,DatabasePassword);
        } catch (Exception e )
        {
            e.printStackTrace();
        }
        return databaselink;
    }
}
