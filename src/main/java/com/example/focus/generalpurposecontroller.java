package com.example.focus;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.Duration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

public class generalpurposecontroller {
    @FXML
    TextField note;

    @FXML
    Label errortext;

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
    public  void onSubmitButton(){
        if(note.getText().isEmpty()){
            errortext.setText("Please enter a note");
        }
        else {
            DBconnection d = new DBconnection();
            Connection connectdb = d.getConnection();
            LocalDate currentDate = LocalDate.now();

            // Format the date as a string
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String dateString = currentDate.format(formatter);
            String sql = "INSERT INTO general_purpose_note (note,DateCreated) VALUES (?,?)";

            try {
                PreparedStatement stmt = connectdb.prepareStatement(sql);
                stmt.setString(1, note.getText());
                stmt.setString(2,dateString);
                int rowsInserted = stmt.executeUpdate();
                errortext.setText("Saved");
            } catch (Exception e) {
                if(e instanceof SQLIntegrityConstraintViolationException){
                    errortext.setText("Integrity constraints");
                }

            }
        }

    }
}
