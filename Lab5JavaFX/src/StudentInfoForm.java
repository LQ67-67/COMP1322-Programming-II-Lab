import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StudentInfoForm extends Application {

    @Override
    public void start(Stage primaryStage) {
        // basic labels for each field
        Label nameLabel = new Label("Student Name:");
        Label idLabel = new Label("Student ID:");
        Label deptLabel = new Label("Department:");
        Label yearLabel = new Label("Year of Study:");

        // text boxes for user input
        TextField nameField = new TextField();
        TextField idField = new TextField();
        nameField.setMaxWidth(Double.MAX_VALUE);
        idField.setMaxWidth(Double.MAX_VALUE);

        // several dropdown list for department
        ComboBox<String> deptComboBox = new ComboBox<>();
        deptComboBox.getItems().addAll("CS", "Math", "Physics", "Admin");
        deptComboBox.setMaxWidth(Double.MAX_VALUE);

        // choice box for study year
        ChoiceBox<String> yearChoiceBox = new ChoiceBox<>();
        yearChoiceBox.getItems().addAll("1", "2", "3");
        yearChoiceBox.setMaxWidth(Double.MAX_VALUE);

        GridPane grid = new GridPane(); // arrange the form in rows and columns
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        // put labels in the first column and inputs in the second column
        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(idLabel, 0, 1);
        grid.add(idField, 1, 1);
        grid.add(deptLabel, 0, 2);
        grid.add(deptComboBox, 1, 2);
        grid.add(yearLabel, 0, 3);
        grid.add(yearChoiceBox, 1, 3);

        // make the second column grow when the window becomes larger
        GridPane.setHgrow(nameField, Priority.ALWAYS);
        GridPane.setHgrow(idField, Priority.ALWAYS);
        GridPane.setHgrow(deptComboBox, Priority.ALWAYS);
        GridPane.setHgrow(yearChoiceBox, Priority.ALWAYS);

        // button to submit the form
        Button submitButton = new Button("Submit");
        submitButton.setMaxWidth(Double.MAX_VALUE);

        submitButton.setOnAction(event -> System.out.println("Form submitted!")); // if button is clicked

        StackPane buttonPane = new StackPane();
        buttonPane.getChildren().add(submitButton);
        buttonPane.setPadding(new Insets(10, 20, 10, 20)); // put the button in the center

        VBox vbox = new VBox();
        vbox.setSpacing(15);
        vbox.setPadding(new Insets(20)); // puts the form and button from top to bottom
        vbox.getChildren().add(grid);
        vbox.getChildren().add(buttonPane);

        BorderPane root = new BorderPane();
        root.setCenter(vbox); // main layout of the window

        Scene scene = new Scene(root, 450, 320);
        primaryStage.setTitle("Student Info Form");
        primaryStage.setScene(scene);
        primaryStage.show(); // create the scene and show the stage
    }

    public static void main(String[] args) {
        // Start the JavaFX program
        launch(args);
    }
}