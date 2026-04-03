package com.example.lab6;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SceneGraphAnimated extends Application {

    @Override
    public void start(Stage stage) {

        Rectangle rect = new Rectangle(150, 150, 150, 120);
        rect.setFill(Color.LIGHTBLUE);
        rect.setOnMouseClicked(e -> rect.setRotate(rect.getRotate() + 10));

        Circle circle = new Circle(225, 210, 40, Color.RED);

        Text text = new Text(155, 145, "Pls Click the Rectangle!");
        text.setFont(Font.font("Arial", FontWeight.BOLD, 13));

        // Move circle left and right
        TranslateTransition move = new TranslateTransition(Duration.seconds(1), circle);
        move.setByX(80); // setByX is used to specify how much to move the circle in x direction
        // move.setByY(80); // setByY: how much to move the circle in y direction
        move.setAutoReverse(true); // setAutoReverse is used to automatically reverse the animation back to the original position after it finishes
        move.setCycleCount(Animation.INDEFINITE);
        move.play();

        // Rectangle follows the circle movement
        TranslateTransition rectMove = new TranslateTransition(Duration.seconds(1), rect);
        rectMove.setByX(80);
        rectMove.setAutoReverse(true);
        rectMove.setCycleCount(Animation.INDEFINITE);
        rectMove.play();

        // Change circle color red to yellow
        FillTransition colorChange = new FillTransition(Duration.seconds(1), circle);
        colorChange.setFromValue(Color.RED);
        colorChange.setToValue(Color.LIGHTYELLOW);
        colorChange.setAutoReverse(true);
        colorChange.setCycleCount(Animation.INDEFINITE);
        colorChange.play();

        // Blink effect for rectangle (opacity 1 -> 0 -> 1)
        FadeTransition blink = new FadeTransition(Duration.seconds(0.5), rect);
        blink.setFromValue(1.0);
        blink.setToValue(0.0);
        blink.setAutoReverse(true);
        blink.setCycleCount(Animation.INDEFINITE);
        blink.play();

        Group root = new Group(rect, circle, text);

        Scene scene = new Scene(root, 400, 350, Color.WHITE);
        stage.setTitle("Animated JavaFX Scene Graph");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}