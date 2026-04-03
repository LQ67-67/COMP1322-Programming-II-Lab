package com.example.lab6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InteractiveFormApp extends Application {

    @Override
    public void start(Stage stage) {

        Label nameLabel = new Label("Enter your name:");
        TextField nameField = new TextField();
        CheckBox checkBox = new CheckBox("Subscribe to updates");

        Button submitBtn = new Button("Submit");
        submitBtn.setOnAction(e -> {
            String name = nameField.getText(); // nameField is used to get the text input from user
            boolean subscribed = checkBox.isSelected(); // get the state of the checkbox

            if (name.isEmpty()) {
                Alert failAlert = new Alert(Alert.AlertType.ERROR);
                failAlert.setTitle("Submit Failed");
                failAlert.setHeaderText(null);
                failAlert.setContentText("Name cannot be empty.");
                failAlert.showAndWait();
                return;
            }

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Submit Success");
            successAlert.setHeaderText(null);
            if (subscribed) {
                successAlert.setContentText("Subscribed successfully! Your Name: " + name);
            } else {
                successAlert.setContentText("Submitted successfully!");
            }
            successAlert.showAndWait();
        });

        VBox vbox = new VBox(10, nameLabel, nameField, checkBox, submitBtn);

        Scene scene = new Scene(vbox, 300, 200);
        stage.setTitle("Interactive Form");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}