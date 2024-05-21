module com.example.focus {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires org.controlsfx.controls;
    requires java.desktop;
    opens com.example.focus to javafx.fxml;
    exports com.example.focus;
}