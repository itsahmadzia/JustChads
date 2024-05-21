package com.example.focus;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LineChartController {
    @FXML
    private StackedBarChart<?, ?> stackchart;

    @FXML
    private ChoiceBox<String> mychoicebox;
    String[] name={"habit","addiction"};
    @FXML
    private NumberAxis yaxis;
    @FXML
    public void initialize(){
        mychoicebox.getItems().addAll(name);
        mychoicebox.setValue("Select type to genrate Graph");
        yaxis.setTickUnit(2);
        double x=yaxis.getTickUnit();
        System.out.println(x);
    }
    public void gengrapAddiction() {

        stackchart.getData().clear();
        String addiction = "select name,streak from addiction";
        String query="select max(streak) from addiction";
        try {

            dbc connectadd = new dbc();
            Connection connectionadd = connectadd.getConnection();
            Statement statementadd = connectionadd.createStatement();
            ResultSet addictionout = statementadd.executeQuery(addiction);
            dbc connectnow1 = new dbc();
            Connection connectdb1 = connectnow1.getConnection();
            Statement statement1 = connectdb1.createStatement();
            ResultSet newquery=statement1.executeQuery(query);
            if (newquery.next()) {
                int size = newquery.getInt(1);
                int s1=0;
                if(size>s1){
                    s1=size;
                }
                yaxis.setUpperBound(s1);
            }
            while(addictionout.next())
            {
                String addname = addictionout.getString("name");
                String addstreak = addictionout.getString("streak");
                XYChart.Series series2 = new XYChart.Series();
                series2.setName(addname);
                series2.getData().add(new XYChart.Data(addname, Integer.parseInt(addstreak)));

                stackchart.getData().add(series2);
            }
            connectionadd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void gengraph_habit(){
        stackchart.getData().clear();
        String connectquery = "select name,streak from habit";
        String query="select max(streak) from habit";
        try {
            dbc connectnow = new dbc();
            Connection connectdb = connectnow.getConnection();
            Statement statement = connectdb.createStatement();
            ResultSet queryout = statement.executeQuery(connectquery);

            dbc connectnow1 = new dbc();
            Connection connectdb1 = connectnow1.getConnection();
            Statement statement1 = connectdb1.createStatement();
            ResultSet newquery=statement1.executeQuery(query);
            if (newquery.next()) {
                int size = newquery.getInt(1);
                int s1=0;
                if(size>s1){
                    s1=size;
                }
                yaxis.setUpperBound(s1);
            }
            while (queryout.next()) {
                String name = queryout.getString("name");
                String streak = queryout.getString("streak");

                XYChart.Series series1 = new XYChart.Series();
                series1.setName(name);

                series1.getData().add(new XYChart.Data(name, Integer.parseInt(streak)));
                stackchart.getData().add(series1);
            }
            connectdb.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void setYaxis() {
        yaxis.setTickUnit(0.5);
    }
    @FXML
    public void onclick()
    {

        //setYaxis(5);
        String mygraph= mychoicebox.getValue();
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
