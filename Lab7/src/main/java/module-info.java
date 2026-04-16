module your.module {
    requires javafx.controls;
    requires javafx.fxml;

    opens package to javafx.fxml;
}