package com.example.lab6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MouseDrawingApp extends Application {

    @Override
    public void start(Stage stage) {

        Canvas canvas = new Canvas(400, 300); // Canvas is used to create a drawing area where can draw shapes, images, or text
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // White background
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 400, 300);

        // Draw blue circle on mouse click instead of setonAction
        canvas.setOnMouseClicked(e -> {
            double x = e.getX(); // used to
            double y = e.getY();
            gc.setFill(Color.BLUE);
            gc.fillOval(x - 15, y - 15, 30, 30);

            /* these codes used to set up red rectangle
             gc.setFill(Color.RED);
             gc.fillRect(x - 15, y - 15, 30, 30);
             */
        });

        StackPane root = new StackPane(canvas);

        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("Mouse Click Drawing");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}