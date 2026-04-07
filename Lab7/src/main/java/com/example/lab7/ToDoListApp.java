package com.example.lab7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class ToDoListApp extends Application {
    private int editingIndex = -1;

    @Override
    public void start(Stage primaryStage) {
        // List to store tasks
        ObservableList<String> taskList = FXCollections.observableArrayList();
        ListView<String> listView = new ListView<>(taskList);

        // Input field
        TextField taskInput = new TextField();
        taskInput.setPromptText("Enter a task...");

        // Buttons
        Button addButton = new Button("Add Task");
        Button editButton = new Button("Edit Task");
        Button saveEditButton = new Button("Save Edit");
        Button removeButton = new Button("Remove Selected");
        Button completeButton = new Button("Mark Completed");

        // Layout
        HBox inputArea = new HBox(10, taskInput, addButton);
        HBox editArea = new HBox(10, editButton, saveEditButton);
        HBox buttonArea = new HBox(10, completeButton, removeButton);
        VBox layout = new VBox(15, listView, inputArea, editArea, buttonArea);
        layout.setStyle("-fx-padding: 20;");

        // Scene and Stage
        Scene scene = new Scene(layout, 420, 500);
        primaryStage.setTitle("To-Do List App");
        primaryStage.setScene(scene);
        primaryStage.show();


        // 2.1 ADD TASK
        addButton.setOnAction(e -> {  // when button clicked
            String task = taskInput.getText().trim(); // get text, remove leading/trailing spaces
            if (!task.isEmpty() && ! taskList.contains(task)) {  // if input is not blank and task doesn't already exist
                taskList.add(task); // add task to the list
                taskInput.clear(); // clear the input field
            }
        });

        // 2.2 EDIT TASK (load into input field)
        editButton.setOnAction(e -> {
            int selectedIndex = listView.getSelectionModel().getSelectedIndex(); // get selected item index
            if (selectedIndex >= 0) {
                editingIndex = selectedIndex; // remember which task we're editing
                taskInput.setText(taskList.get(selectedIndex)); // select
            }
        });

        // 2.2 SAVE EDIT
        saveEditButton.setOnAction(e -> {
            if (editingIndex >= 0) { // only save if we are actually editing something
                String newTask = taskInput.getText().trim(); // get the modified text
                if (!newTask.isEmpty()) { // if text is not blank
                    taskList.set(editingIndex, newTask); // replace old task with new text
                    taskInput.clear();  // clear input field
                    editingIndex = -1; // reset editing state
                }
            }
        });

        // 2.3 REMOVE TASK
        removeButton.setOnAction(e -> {
            int selectedIndex = listView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) { // if something is selected
                taskList.remove(selectedIndex); // remove the task at that index
            }
        });

        // 2.4 MARK AS COMPLETED (prepend "[Completed]")
        completeButton.setOnAction(e -> {
            int selectedIndex = listView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                String selectedTask = taskList.get(selectedIndex);
                if (!selectedTask.startsWith("[Completed] ")) { // avoid double-marking
                    taskList.set(selectedIndex, "[Completed] " + selectedTask); // Prepend "[Completed]"
                }
            }
        });

        // 2.4 STRIKETHROUGH for completed tasks
        listView.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(String task, boolean empty) {
                super.updateItem(task, empty);

                if (empty || task == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    TextFlow textFlow = new TextFlow();
                    Text text = new Text(task);

                    if (task.startsWith("[Completed] ")) {
                        text.setStyle("-fx-strikethrough: true;");
                    }

                    textFlow.getChildren().add(text);   // Add text to the TextFlow
                    setGraphic(textFlow); // show the TextFlow as this cell's content
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}