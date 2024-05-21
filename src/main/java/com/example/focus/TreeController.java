package com.example.focus;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TreeController {
    int currentlevel;
    public void setCurrentlevel() throws SQLException {
        this.currentlevel = getRankval(getScore());
    }
    @FXML
    private ImageView image;

    @FXML
    private Label score;
    @FXML
    Button back;
    @FXML
    void goback(ActionEvent event) {
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
    private Slider slider;
    @FXML
    private Label currRank;
    @FXML
    private Label levelstatus;

    @FXML
    void updateScene() throws FileNotFoundException {
        int i = (int) slider.getValue();
        String myString = String.format("%d", i);
        currRank.setText("Rank:" + myString);

        if(slider.getValue()>currentlevel){
            levelstatus.setText("Locked");
            levelstatus.setStyle("-fx-text-fill: #920202;");
            image.setDisable(true);
        } else if (slider.getValue()<currentlevel) {
            levelstatus.setText("Unlocked");
            levelstatus.setStyle("-fx-text-fill: #028f0a;");

        }
        else {

            levelstatus.setText("Current Level");
            levelstatus.setStyle("-fx-text-fill: #838627;");
        }

        if(currentlevel<slider.getValue()){
      //      slider.setValue(currentlevel);
        }

        image.setImage(getImagebyname(myString));




    }
    public int getScore() throws SQLException {
        int scrc= 0;
        String querey = "Select score_value from score";
        DBconnection connectnow = new DBconnection();
        Connection connectdb = connectnow.getConnection();
        Statement statement = connectdb.createStatement();
        ResultSet queryout = statement.executeQuery(querey);
        if (queryout.next()) {
            scrc = queryout.getInt(1);
        }

        return scrc;
    }
    public  int getRankval(int score){
        if(score>=0 && score <100){
            return 0;
        }
        else if(score>=100 && score <200){
            return 1;
        }
        else if(score>=200 && score <400){
            return 2;
        }
        else if(score>=400 && score <700){
            return 3;
        }
        else if(score>=700 && score <1100){
            return 4;
        }
        else if(score>=1100 && score <1500){
            return 5;
        }
        else if(score>=1500 && score <2000){
            return 6;
        }
        else if(score>=2000 && score <2500){
            return 7;
        }
        else if(score>=2500 && score <5000){
            return 8;
        }

        else if(score>=5000 && score <10000){
            return 9;
        }
        else {
            return 10;
        }

    }

    public Image getImagebyname(String name) throws FileNotFoundException {
        String path= "src/main/resources/com/example/focus/Tree/"+name+".png";
        Image Gladiator = new Image(new FileInputStream(path));
        return Gladiator;

    }
    @FXML
    private void initialize() throws SQLException, FileNotFoundException {
        System.out.println("Initialize method called");
        setCurrentlevel();

        slider.setValue(currentlevel);
        score.setText("Score: " + getScore());

        updateScene();

    }
}
