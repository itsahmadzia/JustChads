package com.example.focus;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class PieChartController {
    @FXML
    private PieChart piechart;
    @FXML
    private ChoiceBox<String> mychoice1;
    String[] name={"habit","addiction"};
    @FXML
    public void initialize(){
        mychoice1.getItems().addAll(name);
        mychoice1.setValue("Select type to genrate Graph");
    }


    private void genpiechart_addiction() {
        String addiction = "select name,streak from addiction";
        try {
            dbc connectadd = new dbc();
            Connection connectionadd = connectadd.getConnection();
            Statement statementadd = connectionadd.createStatement();
            ResultSet addictionout = statementadd.executeQuery(addiction);
            ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();
            while (addictionout.next()) {
                String addname = addictionout.getString("name");
                String addstreak = addictionout.getString("streak");
                pieData.add(new PieChart.Data(addname, Integer.parseInt(addstreak)));
                piechart.setData(pieData);
            }
            piechart.getData().forEach(data -> {
                String percentage=String.format("%.2f%%",(data.getPieValue()/100));
                Tooltip tooltip=new Tooltip(percentage);
                Tooltip.install(data.getNode(), tooltip);
            });
            connectionadd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void genpiechart_habit() {
        String connectquery = "select name,streak from habit";
        try {
        dbc connectnow = new dbc();
        Connection connectdb = connectnow.getConnection();
        Statement statement = connectdb.createStatement();
        ResultSet queryout = statement.executeQuery(connectquery);
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();
        while (queryout.next()) {
            String name = queryout.getString("name");
            String streak = queryout.getString("streak");
            pieData.add(new PieChart.Data(name, Integer.parseInt(streak)));
            piechart.setData(pieData);
        }
        piechart.getData().forEach(data -> {
            String percentage=String.format("%.2f%%",(data.getPieValue()/100));
            Tooltip tooltip=new Tooltip(percentage);
            Tooltip.install(data.getNode(), tooltip);
        });
        connectdb.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    @FXML
    public void onclick()
    {
        String mygraph= mychoice1.getValue();
        if(mygraph.equals("habit"))
        {
            System.out.println("habit");
            //mychoice1.setOnAction(this::genpiechart_habit);
            genpiechart_habit();
        }
        if(mygraph.equals("addiction"))
        {
            System.out.println("addiction");
            //mychoice1.setOnAction(this::genpiechart_addiction);
            genpiechart_addiction();
        }
    }
    @FXML
    public void goBack(javafx.event.ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("graph.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
