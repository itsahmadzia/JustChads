
package com.example.focus;
        import java.sql.Connection;
        import java.sql.DriverManager;
public class DBconnection {
    public Connection databaselink;

    public Connection getConnection() {
        String databasename = "FOCUS";
        String databaseuser = "admin";
        String databasepassword = "admin";
        String url = "jdbc:mysql://localhost/"+databasename;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaselink=DriverManager.getConnection(url,databaseuser,databasepassword);

        }catch (Exception e )
        {
            e.printStackTrace();
        }
        return databaselink;
    }
}
