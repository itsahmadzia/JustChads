package com.example.focus;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class habitListController {
    private Parent root;

    private Stage stage;
    private Scene scene;

    @FXML
    Button e;
@FXML
    Button b;
public String habitname;
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
    private TableView<Habit> table;

    @FXML
    private TableColumn<Habit, String> nameColumn;

    @FXML
    private TableColumn<Habit, String> descriptionColumn;

    @FXML
    private TableColumn<Habit, Integer> streakColumn;

    private ObservableList<Habit> habits;
    @FXML
    public void editSelectedRow(ActionEvent event) throws IOException {

        Habit selectedItem = table.getSelectionModel().getSelectedItem();
        habitname=selectedItem.getName();
        if (selectedItem != null) {
            // Modify the data for the selected item
            FXMLLoader loader2 = new FXMLLoader(getClass().getResource("updatehabit.fxml"));
            Parent root2 = loader2.load();
            editHabitController e = loader2.getController();
            e.oldname=selectedItem.getName();
            e.enteredDescription.setText(selectedItem.getDescription());
            e.enteredText.setText(selectedItem.getName());


// Create a new scene and show it in a new stage
            Scene scene2 = new Scene(root2);
            Stage stage2 = new Stage();
            stage2.setScene(scene2);
            stage2.show();

         //   selectedItem.setName("New name");
          //  selectedItem.setStreak(0);
          //  selectedItem.setDescription("I am sparta");

            // Refresh the table view to show the updated data
            table.refresh();
            // Clear the selection
            table.getSelectionModel().clearSelection();
        } else {
            // Show an error message or take some other action
        }
    }

    @FXML
    public void deleteSelectedRowHabit(ActionEvent event) {
        //  populate_habits();
        Habit selectedItem = table.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            // Delete the item from the database
            deleteHabitFromDatabase(selectedItem);

            // Remove the item from the table
            table.getItems().remove(selectedItem);

            // Clear the selection
            table.getSelectionModel().clearSelection();
        } else {
            // Show an error message or take some other action
        }
    }

    private void deleteHabitFromDatabase(Habit selectedItem) {
        String todeletename = selectedItem.getName();
        DBconnection connectnow = new DBconnection();
        Connection connectdb = connectnow.getConnection();
        String connectquery = "DELETE FROM habit WHERE name=?";
        try {
            PreparedStatement preparedStatement = connectdb.prepareStatement(connectquery);
            preparedStatement.setString(1, todeletename);
            int numRowsAffected = preparedStatement.executeUpdate();
            if (numRowsAffected == 1) {
                System.out.println("Successfully deleted row with name " + todeletename);
            } else {
                System.out.println("Could not delete row with name " + todeletename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connectdb != null) {
                    connectdb.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    public void initialize(ActionEvent actionEvent) {
        // Create the observable list to store the data for the table
        habits = FXCollections.observableArrayList();

        // Retrieve the data from the habit table and add it to the observable list
        try {
            DBconnection d= new DBconnection();

            Connection conn = d.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name, description, streak FROM habit");

            while (rs.next()) {
                System.out.println("F");
                String name = rs.getString("name");
                String description = rs.getString("description");
                int streak = rs.getInt("streak");

                habits.add(new Habit(name, description, streak));
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Set the items for the table to the observable list
        table.setItems(habits);

        // Set the cell value factories for the table columns to display the data from the observable list
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        streakColumn.setCellValueFactory(new PropertyValueFactory<>("streak"));
    }
}