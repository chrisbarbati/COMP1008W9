module com.example.comp1008w9 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.comp1008w9 to javafx.fxml;
    exports com.example.comp1008w9;
}