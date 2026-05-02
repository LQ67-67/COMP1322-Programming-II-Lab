import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloFX extends Application {
    @Override
    public void start(Stage stage) {
        Label label = new Label("Hello, JavaFX!"); // Create a label with the text "Hello, JavaFX!"
        Scene scene = new Scene(new StackPane(label), 300, 200);
        stage.setTitle("Hello JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    static void main(String[] args) {
        launch(args);
    }
}