package com.example.focus;
import java.io.IOException;
import java.sql.Connection;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddictionConntroller {
    @FXML
    private TextField enteredText;

    @FXML
    private TextArea enteredDescription;

    @FXML
    private TextField softtarget;



    @FXML
    Button back;
    @FXML
    void goBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private Label errortext;

    @FXML
    protected void onHelloButtonClick() {
        Habit h;
        if (enteredDescription.getText().isEmpty() || enteredText.getText().isEmpty()||softtarget.getText().isEmpty()) {
            errortext.setText("Please enter values");
        }
        else if (Integer.parseInt(softtarget.getText())<0){
            errortext.setText("Negative values not allowed");
        }
        else {
            DBconnection d = new DBconnection();
            Connection connectdb = d.getConnection();
            LocalDate currentDate = LocalDate.now();

            // Format the date as a string
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String dateString = currentDate.format(formatter);
            // Prepare SQL statement
            String sql = "INSERT INTO addiction (name, description, streak,softtarget, lastModified, StartDate) VALUES (?, ?, ?, ?, ?,?)";

            try {
                PreparedStatement stmt = connectdb.prepareStatement(sql);
                stmt.setString(1, enteredText.getText());
                stmt.setString(2, enteredDescription.getText());
                stmt.setInt(3,0);
                try{
                    stmt.setInt(4, Integer.parseInt(softtarget.getText()));

                }
                catch (Exception r){
                    if(r instanceof NumberFormatException){
                        errortext.setText("Please enter a number");
                    }
                }
                stmt.setString(5, dateString);
                stmt.setString(6, dateString);
                stmt.execute();

                errortext.setText("Saved");

            } catch (Exception e) {
                if(e instanceof SQLIntegrityConstraintViolationException){
                    errortext.setText("Entry exist with the same name");
                }
                if(e instanceof  java.lang.reflect.InvocationTargetException){
                    errortext.setText("Entry exist with the same name");
                }
                e.printStackTrace();
            }
        }
    }
}
