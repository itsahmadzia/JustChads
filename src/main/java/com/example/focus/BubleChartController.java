package com.example.focus;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BubleChartController {

    @FXML
    StackedAreaChart<?,?> stackedareachart;

    @FXML
    private ChoiceBox<String> mychoicebox;
    String[] name={"habit","addiction"};
    @FXML
    public void initialize(){
        mychoicebox.getItems().addAll(name);
        mychoicebox.setValue("Select type to genrate Graph");
    }
    public void gengrapAddiction() {
        stackedareachart.getData().clear();
        String addiction = "select name,streak from addiction";

        try {

            dbc connectadd = new dbc();
            Connection connectionadd = connectadd.getConnection();
            Statement statementadd = connectionadd.createStatement();
            ResultSet addictionout = statementadd.executeQuery(addiction);

            while(addictionout.next())
            {
                String addname = addictionout.getString("name");
                String addstreak = addictionout.getString("streak");
                XYChart.Series series2 = new XYChart.Series();
                series2.setName(addname);
               // series2.getData().add(new XYChart.Data(addname, Integer.parseInt(addstreak),2.0));
                series2.getData().add(new XYChart.Data(Integer.parseInt(addstreak), Integer.parseInt(addstreak)));
                stackedareachart.getData().addAll(series2);
                // bubblechart.getData().add(series2);
            }
            connectionadd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void gengraph_habit(){
        stackedareachart.getData().clear();
        String connectquery = "select name,streak from habit";
        try {
            dbc connectnow = new dbc();
            Connection connectdb = connectnow.getConnection();
            Statement statement = connectdb.createStatement();
            ResultSet queryout = statement.executeQuery(connectquery);

            while (queryout.next()) {
                String name = queryout.getString("name");
                String streak = queryout.getString("streak");
                XYChart.Series series1 = new XYChart.Series();
                series1.setName(name);

                series1.getData().add(new XYChart.Data(Integer.parseInt(streak), Integer.parseInt(streak),2.0));
                stackedareachart.getData().add(series1);
            }
            connectdb.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void onclick()
    {
        String mygraph= (String) mychoicebox.getValue();
        if(mygraph.equals("habit"))
        {
            gengraph_habit();
        }
        if(mygraph.equals("addiction"))
        {
            gengrapAddiction();
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
