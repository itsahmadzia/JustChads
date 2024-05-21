package com.example.focus;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LoginController {
    @FXML
    private TextField username ;
    @FXML
    private PasswordField password;


    @FXML
    private Label errortext;
  /*  public void showNotification2(String message) {
        if (SystemTray.isSupported()) {
            Image image = new Image(getClass().getResourceAsStream("/path/to/notification-image.png"));

            SystemTray tray = SystemTray.getSystemTray();

            TrayIcon trayIcon = new TrayIcon(image, "Quote of the Day");
            trayIcon.setImageAutoSize(true);

            trayIcon.addActionListener(event -> {
                // Handle the click event
            });

            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                e.printStackTrace();
            }

            trayIcon.displayMessage("Quote of the Day", message, TrayIcon.MessageType.NONE);
        }
    }*/

@FXML
    public void onLogin(ActionEvent event) throws IOException {

    if (username.getText().isEmpty() || password.getText().isEmpty()) {
        errortext.setText("Please enter data in all input fields");
    }
    else {
        String value1="";
        String value2="";
        DBconnection d = new DBconnection();
        Connection connectdb = d.getConnection();
        String querey = "select name,password from user_info;";
        try{
            Statement st = connectdb.createStatement();
            ResultSet rs = st.executeQuery(querey);
            while(rs.next()){
                 value1 = rs.getString("name");
                 value2 = rs.getString("password");

            }


        }
        catch (Exception e){
            e.printStackTrace();
        }
        if(value1.equals(username.getText())&&value2.equals(password.getText())){
            errortext.setText("correct");
            maintainingStreaks();
            String q = getRandomQuote();
            showNotification(q);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
        else{
            errortext.setText("wrong");
        }
    }
    }
    public void maintainingStreaks(){
        try {
            LocalDate currentDate = LocalDate.now();
           currentDate= currentDate.minusDays(1);


            // Format the date as a string
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String dateString = currentDate.format(formatter);
            Connection conn = new DBconnection().getConnection();
            Statement stmt = conn.createStatement();

       //     ResultSet rs = stmt.executeQuery("Update habit set streak = 0 where lastmodified="+"''"+dateString+"''");
                int i =stmt.executeUpdate("Update habit set streak = 0 where lastModified<"+"'"+dateString+"'");
                System.out.println("Statement updated"+i);
            Statement stmt2 = conn.createStatement();

            //     ResultSet rs = stmt.executeQuery("Update habit set streak = 0 where lastmodified="+"''"+dateString+"''");
            int i2 =stmt.executeUpdate("Update addiction set streak = 0 where lastModified<"+"'"+dateString+"'");
            System.out.println("Statement updated for addiction"+i);
         //   if (rs.next()) {
              //  quote = rs.getString("quote");
               // author = rs.getString("author");
        //    }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String getRandomQuote() {
        String quote = "";
        String author = "";

        try {
            Connection conn = new DBconnection().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT quote, author FROM quote_of_the_day ORDER BY RAND() LIMIT 1");

            if (rs.next()) {
                quote = rs.getString("quote");
                author = rs.getString("author");
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quote + " - " + author;
    }
    public void showNotification(String message) {
    //built in
        Notifications.create()
                .title("Quote of the Day")
                .text(message)
                .hideAfter(Duration.seconds(10))
                .position(Pos.BOTTOM_RIGHT)
                .show();
    }

}