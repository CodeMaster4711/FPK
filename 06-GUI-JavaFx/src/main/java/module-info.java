module thro.ui {
    requires javafx.controls;
    requires javafx.fxml;


    opens thro.ui to javafx.fxml;
    exports thro.ui;
}