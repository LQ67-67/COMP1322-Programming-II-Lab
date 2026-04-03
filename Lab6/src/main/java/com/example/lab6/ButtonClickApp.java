package com.example.lab6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonClickApp extends Application {
    @Override
    public void start(Stage stage) {
        Label label = new Label("Click the button!");

        Button button1 = new Button("Click Me");
        button1.setOnAction(e -> label.setText("Button Clicked!")); // e is actually event handler which is lambda expression

        Button button2 = new Button("Click Me :)");
        button2.setOnAction(e -> label.setText("Button Clicked! I am Button 2"));
        button2.setOnMouseClicked(e -> label.setText("Button Clicked!")); // same way like above but this is mouse click event handler

        button2.setOnAction(e -> {
            getHostServices().showDocument("https://www.liuqi.cc"); // get access to host services and open the website in default browser
        });

        VBox vbox = new VBox(10, label, button1,button2);

        Scene scene = new Scene(vbox, 300, 200);

        stage.setTitle("Event Handling Example");
        stage.setScene(scene);
        stage.getIcons().add(new javafx.scene.image.Image("/icon.png")); // set the icon of the stage
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}