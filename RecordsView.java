package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;


public class RecordsView extends Application {
    private String[] dates;
    public int id = 0;
    
    boolean errorShown = false;
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        
        // Search Field and Button
        TextField searchField = new TextField();
        searchField.setPromptText("Search");
        Button searchButton = new Button("Search");
        HBox topMenu = new HBox(10, searchField, searchButton);
        topMenu.setAlignment(Pos.CENTER_RIGHT);
        
        // Title Label
        Label titleLabel = new Label("Records");
        titleLabel.setFont(Font.font("Garamond", FontWeight.BOLD, 24));
        titleLabel.setStyle("-fx-font-size: 20px; -fx-padding: 10px;");
        
        // Layout for Title and Search
        VBox topLayout = new VBox(4); 
        topLayout.getChildren().addAll(titleLabel, topMenu);
        borderPane.setTop(topLayout);
        
        // Attempt to retrieve dates
        try {
            dates = Office.getInstance().getVisitDates(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Medical History Area
        VBox rightBox = new VBox();
        rightBox.setStyle("-fx-padding: 10px;");
        Label historyLabel = new Label("Medical History");
        TextArea historyArea = new TextArea();
        rightBox.getChildren().addAll(historyLabel, historyArea);
        borderPane.setCenter(rightBox);
        
        // Buttons
        HBox buttonBox = new HBox(10);
        buttonBox.setStyle("-fx-padding: 10px;");
        Button editButton = new Button("Edit");
        Button saveButton = new Button("Save");
        Button closeButton = new Button("Close");
        buttonBox.getChildren().addAll(editButton, saveButton, closeButton);
        borderPane.setBottom(buttonBox);
        
        // Button Functionality
        editButton.setDisable(true);
        saveButton.setDisable(true);
        historyArea.setDisable(true);
        
        editButton.setOnAction(event -> {
            saveButton.setDisable(false);
            editButton.setDisable(true);
            historyArea.setDisable(false);
        });
        
        saveButton.setOnAction(event -> {
            saveButton.setDisable(true);
            editButton.setDisable(false);
            historyArea.setDisable(true);
            
            String[] info = {historyArea.getText()};
            try {
                Office.getInstance().storeMedicalHistory(id, info);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        
        searchButton.setOnAction(e -> {
        	String search = searchField.getText().trim();
        	id = Integer.parseInt(search);
        	if (errorShown) 
        	{
        		errorShown = false;
                historyArea.setText("");
        	}
        	
        	if (!search.isEmpty()) {

                int patientId = Integer.parseInt(search);
                try {
					String pInfo = Office.getInstance().getPatientInfo(patientId);
					if (!pInfo.isBlank()) {
						id = patientId;
						saveButton.setDisable(false);
						editButton.setDisable(false);
					}
				} catch (IOException e1) {
					errorShown = true;
					searchField.setText("");
					String errorMessage = "No Patient was found with id " + search;
			        historyArea.setText(errorMessage);
					
					saveButton.setDisable(true);
					editButton.setDisable(true);
				}
        	}
        });
        
        closeButton.setOnAction(event -> Platform.exit());
        
        // Visits List
        ListView<Button> listView = new ListView<>();
        for (String date : dates) {
            Button b = new Button("Visit on " + date);
            listView.getItems().add(b);
            
            b.setOnAction(event -> {
                try {
                    String history = Office.getInstance().getMedicalHistory(id, date);
                    historyArea.setText(history);
                } catch (IOException e) {
                    historyArea.setText(e.toString());
                }
            });
        }
        borderPane.setLeft(listView);
        
        // Final Scene Setup
        Scene scene = new Scene(borderPane, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
        borderPane.setStyle("-fx-background-color: white;");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
