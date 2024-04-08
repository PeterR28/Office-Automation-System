package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class recordView extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("John Doe's Records");

        BorderPane borderPane = new BorderPane();

        Label titleLabel = new Label("John Doe's Records");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-padding: 10px;");
        borderPane.setTop(titleLabel);

        // List for visits 
        ListView<String> listView = new ListView<>();
        listView.getItems().addAll(
                "Visit on DD/MM/YYYY",
                "Visit on DD/MM/YYYY",
                "Visit on DD/MM/YYYY",
                "Visit on DD/MM/YYYY",
                "Visit on DD/MM/YYYY"
        );
        borderPane.setLeft(listView);

        // Medical history 
        VBox rightBox = new VBox();
        rightBox.setStyle("-fx-padding: 10px;");
        Label historyLabel = new Label("John Doe's Medical History");
        TextArea historyArea = new TextArea();
        rightBox.getChildren().addAll(historyLabel, historyArea);
        borderPane.setCenter(rightBox);

        // Edit, Save, Close buttons 
        HBox buttonBox = new HBox(10);
        buttonBox.setStyle("-fx-padding: 10px;");
        Button editButton = new Button("Edit");
        Button saveButton = new Button("Save");
        Button closeButton = new Button("Close");
        buttonBox.getChildren().addAll(editButton, saveButton, closeButton);
        borderPane.setBottom(buttonBox);


        Scene scene = new Scene(borderPane, 600, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

