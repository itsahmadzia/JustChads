
/**
 * Sample Skeleton for 'homepage.fxml' Controller Class
 */

package com.example.focus;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.Label;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Homepage {

    /*@FXML
    private TableColumn<TableSetterGetter, String> name;
    @FXML
    private TableColumn<TableSetterGetter,Integer> Streak;
    @FXML
    private TableColumn<TableSetterGetter, CheckBox> MarkasDone;

    @FXML
    private TableView<TableSetterGetter> HabitTable;
    ObservableList<TableSetterGetter> list= FXCollections.observableArrayList();
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        for(int i=0;i<10;i++)
        {
            CheckBox ch=new CheckBox(""+"\uD83D\uDD25");
            list.add(new TableSetterGetter("name",1,ch));
            HabitTable.setItems(list);
            name.setCellValueFactory(new PropertyValueFactory<TableSetterGetter,String>("Name"));
            Streak.setCellValueFactory(new PropertyValueFactory<TableSetterGetter,Integer>("Streak"));
            MarkasDone.setCellValueFactory(new PropertyValueFactory<TableSetterGetter,CheckBox>("MarkasDone"));

        }
    }*/
    @FXML Button back;
    @FXML
    void goBack(ActionEvent event){
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
    private ChoiceBox<String> myChoiceBox;
    @FXML
    private ChoiceBox<String> myChoiceBox1;
    @FXML
    private ChoiceBox<String> graphtype;
    private  String[] gtype={"Bar Graph","Area Chart","Pie Chart","Stacked Bar Chart","Stacked Area Chart","Scatter Chart",};
    @FXML
    public void initialize() {
        graphtype.getItems().addAll(gtype);
        graphtype.setValue("Select type of graph");
        //myChoiceBox.setOnAction(this::getFood);
        //myChoiceBox.setOnAction(this::gengraph);
    }
    @FXML
    public void generatebutton(ActionEvent event)
    {
        try {
            String mygraph= graphtype.getValue();
            if(mygraph.equals("Bar Graph"))
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Bargraph.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
            else if(mygraph.equals("Area Chart")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AreaChart.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
            else if(mygraph.equals("Pie Chart")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("PieChart.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
            else if(mygraph.equals("Stacked Bar Chart")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("StackedBarChart.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
            else if(mygraph.equals("Stacked Area Chart")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("StackedArea.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
            else if(mygraph.equals("Scatter Chart")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ScatterChart.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
            } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    }







