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
import javafx.scene.control.*;
import javafx.stage.Stage;


public class SignUpController {

    @FXML
    private TextField backupquestionfield;
    @FXML
    private TextField emailField;
@FXML
    private PasswordField passwordField;
    @FXML
    private  PasswordField reenterpassword;

    @FXML
    private Button lg;
    @FXML
    void lgPage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private TextField usernameField;
    @FXML
    private Label errortext;
    @FXML

    private void OnClick(ActionEvent event){
        String p1=passwordField.getText();

if(usernameField.getText().isEmpty()||backupquestionfield.getText().isEmpty()||emailField.getText().isEmpty()||passwordField.getText().isEmpty()||reenterpassword.getText().isEmpty()){
    errortext.setText("Please enter values");
} else if (!reenterpassword.getText().equals(passwordField.getText())) {
    errortext.setText("Password must be same");

} else{
    DBconnection d = new DBconnection();
    Connection connectdb = d.getConnection();
    String sql = "INSERT INTO user_info (name, exactonerecord, password,backup,email) VALUES (?, ?, ?, ?,?)";
    String sql2= "INSERT INTO score (username,score_value,exact_one_record) VALUES (?, ?, ?)";
    try {
        PreparedStatement stmt = connectdb.prepareStatement(sql);
        PreparedStatement stmt2 = connectdb.prepareStatement(sql2);
        stmt.setString(1, usernameField.getText());
        stmt.setInt(2,1);//explicitly setting an instance every time to avoid multiple entries in this table
        stmt.setString(3,passwordField.getText());

        stmt.setString(4, backupquestionfield.getText());
        stmt.setString(5, emailField.getText());

        stmt2.setString(1,usernameField.getText());
        stmt2.setInt(2,0);
        stmt2.setInt(3,1);
        stmt.execute();
        stmt2.execute();
        errortext.setText("Saved");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        stmt.close();
        stmt2.close();
    } catch (Exception e) {
        if(e instanceof SQLIntegrityConstraintViolationException){
            errortext.setText("User account already exists please log in");
        }

    }

}
    }


}
