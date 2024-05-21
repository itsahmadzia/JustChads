package com.example.focus;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class editAddictionController {
    @FXML
    private Button editAddiction;
    public String oldname;

    @FXML
    public TextArea enteredDescription;

    @FXML
    public TextField enteredText;

    @FXML
    private Label errortext;

    @FXML
    public TextField softtarget;

    @FXML
    void onHelloButtonClick(ActionEvent event) {


    }
    @FXML
    public void onEditAddiction(){


        if (enteredDescription.getText().isEmpty() || enteredText.getText().isEmpty()) {
            errortext.setText("Please enter values");
        } else {
            DBconnection d = new DBconnection();
            Connection connectdb = d.getConnection();
            LocalDate currentDate = LocalDate.now();

            // Format the date as a string
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String dateString = currentDate.format(formatter);
            // Prepare SQL statement
            //  oldname="c";

            String sql = "UPDATE addiction SET name=?, description=?,softtarget=? WHERE name=?";
            try {
                PreparedStatement stmt = connectdb.prepareStatement(sql);
                stmt.setString(1, enteredText.getText());
                stmt.setString(2, enteredDescription.getText());
                stmt.setString(3,softtarget.getText());
                stmt.setString(4,oldname);

                stmt.execute();

                errortext.setText("Saved");


            } catch (Exception e) {
                if(e instanceof SQLIntegrityConstraintViolationException){
                    errortext.setText("Entry exist with the same name");
                }


            }
        }
    }



}