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
                import java.sql.*;
                import java.sql.Connection;
                import  java.sql.PreparedStatement;
                import java.time.LocalDate;
                import java.time.format.DateTimeFormatter;
                import java.util.EmptyStackException;
                import java.util.Vector;

                public class Homepagecontroller {
                    private Vector<String> selected_habit = new Vector<String>();
                    private Vector<String> selected_addiction = new Vector<String>();
                    @FXML
                    Button refresh;
                  @FXML
                    Button backButton;
                    @FXML
                    Button deletehabit;
                    @FXML
                    Button deleteaddiction;

                    @FXML
                    Button edithabit;

                    @FXML
                    private TableColumn<TableSetterGetter, String> name;
                    @FXML
                    private TableColumn<TableSetterGetter, Integer> Streak;
                    @FXML
                    private TableColumn<TableSetterGetter, CheckBox> MarkasDone;
                    @FXML
                    private TableColumn<TableSetterGetter, String> name1;
                    @FXML
                    private TableColumn<TableSetterGetter, Integer> Streak1;
                    @FXML
                    private TableColumn<TableSetterGetter, CheckBox> MarkasDone1;
                    @FXML
                    private TableView<TableSetterGetter> HabitTable;
                    @FXML
                    private TableView<TableSetterGetter> HabitTable1;
                    ObservableList<TableSetterGetter> list = FXCollections.observableArrayList();
                    ObservableList<TableSetterGetter> list2 = FXCollections.observableArrayList();
@FXML
void backButton(ActionEvent event){
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
                    void onrefreshbuttonClick() {
                        LocalDate currentDate = LocalDate.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        String dateString = currentDate.format(formatter);
                        DBconnection connectnow = new DBconnection();
                        Connection connectdb = connectnow.getConnection();
                        String connectquery = "select name,streak from habit where streak=0 or lastModified <>'" + dateString + "'";

                        list.clear();
                        try {
                            Statement statement = connectdb.createStatement();
                            ResultSet queryout = statement.executeQuery(connectquery);

                            while (queryout.next()) {
                                CheckBox ch = new CheckBox("");
                                int numRows = HabitTable.getItems().size();
                                String name2 = queryout.getString(1);
                                int streak = queryout.getInt(2);


                                // Add new item to the ObservableList if name doesn't already exist
                                    ch = new CheckBox("");

                                    list.add(new TableSetterGetter(queryout.getString(1), queryout.getInt(2), ch));
                                    HabitTable.setItems(list);
                                    name.setCellValueFactory(new PropertyValueFactory<TableSetterGetter, String>("Name"));
                                    Streak.setCellValueFactory(new PropertyValueFactory<TableSetterGetter, Integer>("Streak"));
                                    MarkasDone.setCellValueFactory(new PropertyValueFactory<TableSetterGetter, CheckBox>("MarkasDone"));



                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    @FXML
                    void onrefreshbuttonClick1() {

                        LocalDate currentDate = LocalDate.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        String dateString = currentDate.format(formatter);
                        DBconnection connectnow = new DBconnection();
                        Connection connectdb = connectnow.getConnection();
                        String connectquery = "select name,streak from addiction where streak=0 or lastModified <>'" + dateString + "'";
                        list2.clear();
                        try {
                            Statement statement = connectdb.createStatement();
                            ResultSet queryout = statement.executeQuery(connectquery);

                            while (queryout.next()) {
                                CheckBox ch = new CheckBox("");
                                int numRows = HabitTable1.getItems().size();
                                String name2 = queryout.getString(1);
                                int streak = queryout.getInt(2);



                                // Add new item to the ObservableList if name doesn't already exist
                                    ch = new CheckBox("");

                                    list2.add(new TableSetterGetter(queryout.getString(1), queryout.getInt(2), ch));
                                    HabitTable1.setItems(list2);
                                    name1.setCellValueFactory(new PropertyValueFactory<TableSetterGetter, String>("Name"));
                                    Streak1.setCellValueFactory(new PropertyValueFactory<TableSetterGetter, Integer>("Streak"));
                                    MarkasDone1.setCellValueFactory(new PropertyValueFactory<TableSetterGetter, CheckBox>("MarkasDone"));


                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    @FXML
                    void refreshhabotsandaddiction() {
                        onrefreshbuttonClick1();
                        onrefreshbuttonClick();

                    }

                    @FXML
                    public void editSelectedRow(ActionEvent event) {
                        TableSetterGetter selectedItem = HabitTable.getSelectionModel().getSelectedItem();
                        if (selectedItem != null) {
                            // Modify the data for the selected item
                            selectedItem.setName("New name");
                            selectedItem.setStreak(0);
                            selectedItem.setMarkasDone(new CheckBox());

                            // Refresh the table view to show the updated data
                            HabitTable.refresh();

                            // Clear the selection
                            HabitTable.getSelectionModel().clearSelection();
                        } else {
                            // Show an error message or take some other action
                        }
                    }

                    @FXML
                    public void deleteSelectedRowAddiction(ActionEvent event) {
                        TableSetterGetter selectedItem = HabitTable1.getSelectionModel().getSelectedItem();
                        if (selectedItem != null) {
                            // Delete the item from the database
                            deleteAddictionFromDatabase(selectedItem);

                            // Remove the item from the table
                            HabitTable1.getItems().remove(selectedItem);

                            // Clear the selection
                            HabitTable1.getSelectionModel().clearSelection();
                        }
                    }

                    @FXML
                    public void deleteSelectedRowHabit(ActionEvent event) {
                        //  populate_habits();
                        TableSetterGetter selectedItem = HabitTable.getSelectionModel().getSelectedItem();
                        if (selectedItem != null) {
                            // Delete the item from the database
                            deleteHabitFromDatabase(selectedItem);

                            // Remove the item from the table
                            HabitTable.getItems().remove(selectedItem);

                            // Clear the selection
                            HabitTable.getSelectionModel().clearSelection();
                        } else {
                            // Show an error message or take some other action
                        }
                    }

                    // Helper method to delete the selected item from the database
                    private void deleteHabitFromDatabase(TableSetterGetter selectedItem) {
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

                    private void deleteAddictionFromDatabase(TableSetterGetter selectedItem) {
                        String todeletename = selectedItem.getName();
                        DBconnection connectnow = new DBconnection();
                        Connection connectdb = connectnow.getConnection();
                        String connectquery = "DELETE FROM addiction WHERE name=?";
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
                    Button Submit;



                    @FXML
                    void onSubmitButtonClick() throws SQLException {
                        LocalDate currentDate = LocalDate.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        String dateString = currentDate.format(formatter);
                        populate_habits();
                        populate_addictions();
                        DBconnection d = new DBconnection();
                        Connection connectdb = d.getConnection();
                        String query = "UPDATE habit SET streak = streak + 1, lastModified = '" + dateString + "' WHERE name = ?";
                        String query2 = "INSERT INTO stats_for_habit (habit_name, current_streak, last_update_date) VALUES (?, ?, ?)";
                        String query3 = "Select streak from habit WHERE name = ?";
                        String query4 = "Update score set score_value = score_value+1 where exact_one_record=1";

                        PreparedStatement statement = connectdb.prepareStatement(query);
                        PreparedStatement statement2 = connectdb.prepareStatement(query2);
                        PreparedStatement statement3 = connectdb.prepareStatement(query3);
                        PreparedStatement statement4 = connectdb.prepareStatement(query4);
                        for (String habit : selected_habit) {
                            statement.setString(1, habit);
                            statement2.setString(1,habit);
                            statement3.setString(1,habit);
                            statement3.executeQuery();


                            ResultSet  result = statement3.getResultSet();

                            int streak = 0;
                            if(result.next()){
                                streak=result.getInt(1);
                            }
                            else{
                               break;
                            }
                            statement2.setInt(2,streak);
                            statement2.setString(3,dateString);
                            statement2.executeUpdate();
                            int rowsUpdated = statement.executeUpdate();
                            statement4.execute();
                            System.out.println("Rows updated: " + rowsUpdated);
                        }


         query = "UPDATE addiction SET streak = streak + 1, lastModified = '" + dateString + "' WHERE name = ?";
         statement = connectdb.prepareStatement(query);
                        query2 = "INSERT INTO stats_for_addiction (addiction_name, current_streak, last_update_date) VALUES (?, ?, ?)";
                        query3 = "Select streak from addiction WHERE name = ?";
                        statement2 = connectdb.prepareStatement(query2);
                       statement3 = connectdb.prepareStatement(query3);
                        for (String addiction : selected_addiction) {
                            statement.setString(1,addiction);
                            statement2.setString(1,addiction);
                            statement3.setString(1,addiction);
                            statement3.executeQuery();


                            ResultSet  result = statement3.getResultSet();
                            int streak = 0;
                            if(result.next()){
                                streak=result.getInt(1);
                            }
                            else {
                                break;
                            }
                            statement2.setInt(2,streak);
                            statement2.setString(3,dateString);
                            statement2.executeUpdate();
                            int rowsUpdated = statement.executeUpdate();
                            System.out.println("Rows updated: " + rowsUpdated);
                            statement4.execute();
                        }

                        statement.close();
                        statement2.close();
                        statement3.close();
                        connectdb.close();

                    refreshhabotsandaddiction();
                    }

                    public void populate_habits() {
                        selected_habit.clear();

                        for (TableSetterGetter item : HabitTable.getItems()) {
                           if(item.getMarkasDone().isSelected()) {
                               System.out.println("a");
                               selected_habit.add(item.getName());
                           }
                        }
                        System.out.println(selected_habit);
                    }
                    public void populate_addictions() {
                        selected_addiction.clear();

                        for (TableSetterGetter item : HabitTable1.getItems()) {
                            if(item.getMarkasDone().isSelected()) {
                                System.out.println("a");
                                selected_addiction.add(item.getName());
                            }
                        }
                        System.out.println(selected_addiction);

                    }
                }