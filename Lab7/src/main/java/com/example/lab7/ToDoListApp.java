package com.example.lab7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ToDoListApp extends Application {
    private int editingIndex = -1;

    // PART 3 EXTENSION 1: Task class to store name + timestamps
    static class Task {
        String name, addedTime, completedTime;
        boolean completed = false;

        Task(String name) {
            this.name = name;
            this.addedTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }

        public String toString() {
            if (completed){
                return "[Completed] " + name + " (Added: " + addedTime + ") (Done: " + completedTime + ")";
            } else {
                return name + " (Added: " + addedTime + ")";
            }
        }
    }

    @Override
    public void start(Stage primaryStage) {
        // List to store tasks
        ObservableList<Task> taskList = FXCollections.observableArrayList();
        FilteredList<Task> filteredList = new FilteredList<>(taskList, t -> true);
        ListView<Task> listView = new ListView<>(filteredList);

        // Input field
        TextField taskInput = new TextField();
        taskInput.setPromptText("Enter a task...");

        // Buttons
        Button addButton = new Button("Add Task");
        Button editButton = new Button("Edit Task");
        Button saveEditButton = new Button("Save Edit");
        Button removeButton = new Button("Remove Selected");
        Button completeButton = new Button("Mark Completed");

        // PART 3 EXTENSION 2: Filter dropdown
        // Filter dropdown
        ComboBox<String> filterBox = new ComboBox<>();
        filterBox.getItems().addAll("All Tasks", "Completed", "Pending");
        filterBox.setValue("All Tasks");

        // Layout
        HBox inputArea = new HBox(10, taskInput, addButton);
        HBox editArea = new HBox(10, editButton, saveEditButton);
        HBox buttonArea = new HBox(10, completeButton, removeButton);
        HBox filterArea = new HBox(10, new Label("Filter:"), filterBox);
        VBox layout = new VBox(15, listView, inputArea, editArea, buttonArea, filterArea);
        layout.setStyle("-fx-padding: 20;");

        // Scene and Stage
        Scene scene = new Scene(layout, 420, 550);
        primaryStage.setTitle("To-Do List App");
        primaryStage.setScene(scene);
        primaryStage.show();


        // 2.1 ADD TASK (same logic, now creates Task object)
        addButton.setOnAction(e -> {
            String taskName = taskInput.getText().trim();
            boolean duplicate = taskList.stream().anyMatch(t -> t.name.equals(taskName)); // check duplicate
            if (!taskName.isEmpty() && !duplicate) {
                taskList.add(new Task(taskName));  // create Task object with timestamp
                taskInput.clear();
            }
        });

        // 2.2 EDIT TASK (load into input field)
        editButton.setOnAction(e -> {
            int selectedIndex = listView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                Task selectedTask = filteredList.get(selectedIndex);
                editingIndex = taskList.indexOf(selectedTask); // find index in master list
                taskInput.setText(selectedTask.name);          // load task name into input
            }
        });

        // 2.2 SAVE EDIT
        saveEditButton.setOnAction(e -> {
            if (editingIndex >= 0) {
                String newName = taskInput.getText().trim();
                if (!newName.isEmpty()) {
                    taskList.get(editingIndex).name = newName;  // update name
                    Task temp = taskList.get(editingIndex);
                    taskList.set(editingIndex, temp);           // trigger UI refresh
                    taskInput.clear();
                    editingIndex = -1;
                }
            }
        });

        // 2.3 REMOVE TASK
        removeButton.setOnAction(e -> {
            int selectedIndex = listView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                Task selectedTask = filteredList.get(selectedIndex);
                taskList.remove(selectedTask); // remove from master list
            }
        });

        // 2.4 MARK COMPLETED
        completeButton.setOnAction(e -> {
            int i = listView.getSelectionModel().getSelectedIndex();
            if (i >= 0) {
                Task task = filteredList.get(i);
                if (!task.completed) {
                    task.completed = true;
                    task.completedTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    taskList.set(taskList.indexOf(task), task); // trigger refresh
                }
            }
        });

        // PART 3 EXTENSION 2: FILTER DROPDOWN
        filterBox.setOnAction(e -> {
            String selected = filterBox.getValue();
            if (selected.equals("Completed")) {
                filteredList.setPredicate(t -> t.completed); // setPredicate filters the list based on condition
            } else if (selected.equals("Pending")) {
                filteredList.setPredicate(t -> !t.completed);
            } else {
                filteredList.setPredicate(t -> true);
            }
        });

        // 2.4 STRIKETHROUGH + PART 3 EXTENSION 1 (colors) + EXTENSION 3 (drag and drop)
        listView.setCellFactory(param -> new ListCell<Task>() {
            {
                // detected drag or not
                setOnDragDetected(e -> {
                    if (getItem() == null) return;
                    Dragboard db = startDragAndDrop(TransferMode.MOVE);
                    ClipboardContent c = new ClipboardContent();
                    c.putString(String.valueOf(getIndex()));
                    db.setContent(c);
                    e.consume();
                });

                // allow drop
                setOnDragOver(e -> {
                    if (e.getGestureSource() != this && e.getDragboard().hasString())
                        e.acceptTransferModes(TransferMode.MOVE);
                    e.consume();
                });

                // swap positions
                setOnDragDropped(e -> {
                    int from = Integer.parseInt(e.getDragboard().getString());
                    int to   = getIndex();
                    if (from != to && from < taskList.size() && to < taskList.size()) {
                        Task temp = taskList.get(from);
                        taskList.set(from, taskList.get(to));
                        taskList.set(to, temp);
                    }
                    e.setDropCompleted(true);
                    e.consume();
                });
            }

            @Override
            protected void updateItem(Task task, boolean empty) {
                super.updateItem(task, empty);
                if (empty || task == null) {
                    setText(null);
                    setGraphic(null);
                    setStyle("");
                } else {
                    TextFlow textFlow = new TextFlow();
                    Text text = new Text(task.toString()); // uses Task's toString() with timestamps

                    if (task.completed) {
                        text.setStyle("-fx-strikethrough: true;"); // strikethrough for completed
                        setStyle("-fx-background-color: #d4edda;"); // green background
                    } else {
                        text.setStyle("");
                        setStyle("-fx-background-color: #fff3cd;"); // yellow background for pending
                    }
                    textFlow.getChildren().add(text);
                    setGraphic(textFlow);
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}