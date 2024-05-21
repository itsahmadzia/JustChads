package com.example.focus;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AvatarsIntroController {
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
    int currentlevel;
    Image Blank = new Image(new FileInputStream("src/main/resources/com/example/focus/Avatars/blank.png"));

    Image Journeyman = new Image(new FileInputStream("src/main/resources/com/example/focus/Avatars/journeyman.jpg"));

   Image Pathfinder = new Image(new FileInputStream("src/main/resources/com/example/focus/Avatars/pathfinder.jpg"));

   Image  Fighter = new Image(new FileInputStream("src/main/resources/com/example/focus/Avatars/fighter.jpeg"));

Image    Huntsman = new Image(new FileInputStream("src/main/resources/com/example/focus/Avatars/huntsman.jpg"));


Image    Vanquisher = new Image(new FileInputStream("src/main/resources/com/example/focus/Avatars/vanquisher.jpg"));

   Image Gladiator = new Image(new FileInputStream("src/main/resources/com/example/focus/Avatars/gladiator.jpg"));

Image    Defender = new Image(new FileInputStream("src/main/resources/com/example/focus/Avatars/defender.jpg"));

   Image Knight = new Image(new FileInputStream("src/main/resources/com/example/focus/Avatars/knight.jpg"));

   Image  Conqueror =  new Image(new FileInputStream("src/main/resources/com/example/focus/Avatars/conqueror.jpg"));

 Image   GigaChad =  new Image(new FileInputStream("src/main/resources/com/example/focus/Avatars/gigachad.png"));
Image Swordsman =  new Image(new FileInputStream("src/main/resources/com/example/focus/Avatars/swordsman.jpg"));
    @FXML
    private ImageView image;
    @FXML
    private Label rankvalue;
    @FXML
    private Label name;

    @FXML
    private Label score;

    @FXML
    private Slider slider;

    @FXML
    private TextArea story;

    @FXML
    private Label levelstatus;

    Image currentAvatar = new Image(new FileInputStream("src/main/resources/com/example/focus/Avatars/vanquisher.jpg"));

    public AvatarsIntroController() throws FileNotFoundException, SQLException {

    }

    public void setCurrentlevel() throws SQLException {
        this.currentlevel = getRankval(getScore());
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


    @FXML
    void updateScene() throws SQLException {
        rankvalue.setText("Rank:"+ slider.getValue());
     //   System.out.println(getScore());
   //     int currentrank = getRankval(getScore());

        //0,1,4,5,6,9,11
image.setFitHeight(300);
image.setFitWidth(300);
image.setPreserveRatio(false);

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

        story.setText("Loading...");
        story.setEditable(false);
        image.setImage(Blank);
        story.setText("No record found");
        name.setText("");
       if(slider.getValue()==0){

            story.setText("If you have achieved the rank of Journeyman, it means that you have made a commitment to improving yourself through consistent effort and dedication. You understand that success doesn't come overnight, and you are willing to put in the work to achieve your goals. You have demonstrated an admirable level of persistence and focus, and we believe that you have what it takes to continue on this journey of self-improvement.");
          image.setImage(Journeyman);
            name.setText("Journeyman");

        }
        else if(slider.getValue()==1){
            story.setText(" If you have reached the rank of Pathfinder, it means that you are someone who is not afraid to take on new challenges and explore uncharted territory. You have a strong sense of direction and are able to navigate through obstacles with ease. You understand that achieving your goals requires a combination of persistence and focus, and you are willing to put in the effort to make it happen. We believe that your ability to lead yourself and others towards success will take you far.");
            image.setImage(Pathfinder);
            name.setText("Path Finder");

        }

        else if(slider.getValue()==2){
            story.setText("If you have achieved the rank of Fighter, it means that you are a true warrior at heart. You have a relentless spirit that drives you to keep pushing forward, no matter how difficult the challenge may seem. You understand that consistency is key, and you are willing to put in the hard work to achieve your goals. Your dedication and focus inspire others to strive for excellence, and we believe that you are destined for greatness.");
            image.setImage(Fighter);
            name.setText("Fighter");

        }

        else if(slider.getValue()==3){
            story.setText("If you have reached the rank of Huntsman, it means that you have developed a keen sense of awareness and focus. You are able to identify your target and pursue it with precision and efficiency. You understand that persistence is key, and you are willing to put in the work to achieve your goals. Your ability to stay focused amidst distractions is truly impressive, and we believe that you are on your way to achieving great things.");
            image.setImage(Huntsman);
            name.setText("Huntsman");

        }else if(slider.getValue()==4){
            story.setText("If you have achieved the rank of Swordsman, it means that you have developed a sharp mind and a disciplined approach to achieving your goals. You understand that consistency and persistence are the keys to success, and you are willing to put in the work to make it happen. Your ability to focus on the task at hand and execute it with precision is truly remarkable, and we believe that you have what it takes to achieve greatness.");

            image.setImage(Swordsman);
            name.setText("Swordsman");

        }else if(slider.getValue()==5){
            story.setText("If you have reached the rank of Vanquisher, it means that you have a fierce determination and an unrelenting spirit. You understand that success requires a combination of consistent effort and persistence, and you are willing to put in the work to achieve your goals. Your ability to stay focused on the end goal, even when faced with challenges and setbacks, is truly inspiring. We believe that you are destined for greatness and that your determination will take you far.");
image.setImage(Vanquisher);
            name.setText("Vanquisher");
        }else if(slider.getValue()==6){
            story.setText("If you have achieved the rank of Gladiator, it means that you are a true champion. You have a warrior's spirit and a determination that is unmatched. You understand that success requires a combination of focus, persistence, and consistency, and you are willing to put in the work to make it happen. Your ability to overcome obstacles and stay focused on the end goal is truly impressive, and we believe that you are destined for greatness.");

            image.setImage(Gladiator);
            name.setText("Gladiator");

        }else if(slider.getValue()==7){
            story.setText("If you have reached the rank of Defender, it means that you have a strong sense of purpose and a commitment to making a difference. You understand that achieving your goals requires a combination of persistence and focus, and you are willing to put in the work to make it happen. Your ability to stay focused on your mission, even in the face of adversity, is truly admirable. We believe that you are destined for greatness");
            name.setText("Defender");
            image.setImage(Defender);

        }else if(slider.getValue()==8){
            story.setText("if you've reached the Knight rank, and that's something to be proud of! This means you're a person of persistence, focus and determination. You've demonstrated the ability to take on challenges and overcome obstacles with a strong will and unwavering commitment. You're on the path to greatness, and you're not letting anything get in your way.");

            image.setImage(Knight);
            name.setText("Knight");
        }else if(slider.getValue()==9){
            story.setText("you've achieved the Conqueror rank! This means you're a person of unstoppable force, unwavering resilience, and incredible strength. You've battled your way through tough times and emerged victorious, stronger and better than ever before. You're on the brink of greatness, and your achievements are truly remarkable.");
            name.setText("Conqueror");
            image.setImage(Conqueror);

        }else if(slider.getValue()==10){
            story.setText("You've reached the pinnacle of success with the GigaChad rank! This means you're a person of extraordinary power, incredible will, and remarkable perseverance. You've conquered every challenge, overcome every obstacle, and achieved things that most people can only dream of. Your achievements are legendary, and you're a true inspiration to others.");
            name.setText("GigaChad");
            image.setImage(GigaChad);

        }
        if(levelstatus.getText()=="Locked"){
            image.setDisable(true);
        }

    }
    @FXML
    private void initialize() throws SQLException {
        System.out.println("Initialize method called");
        setCurrentlevel();

        slider.setValue(currentlevel);
        score.setText("Score: " + getScore());

        updateScene();

    }
}
