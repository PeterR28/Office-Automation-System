package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Pair;


//TODO: use method from office for dates

public class RecordsView extends Application {
	private String[] dates;
	public int id = 0;
	
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("John Doe's Records");
                
        BorderPane borderPane = new BorderPane();

        Label titleLabel = new Label("John Doe's Records");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-padding: 10px;");
        borderPane.setTop(titleLabel);
        titleLabel.setFont(Font.font("Garamond", FontWeight.BOLD, 24));
        
        try {
			//info = Office.getInstance().getMedicalHistory(id);
        	dates = Office.getInstance().getVisitDates(id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       

        // Medical history 
        VBox rightBox = new VBox();
        rightBox.setStyle("-fx-padding: 10px;");
        Label historyLabel = new Label("John Doe's Medical History");
        TextArea historyArea = new TextArea();
        //historyArea.setText(info.isEmpty() ? "" : info.get(index).getValue());
        rightBox.getChildren().addAll(historyLabel, historyArea);
        borderPane.setCenter(rightBox);
        
        // List for visits 
        ListView<Button> listView = new ListView<>();
        for (String date : dates) {
        	Button b = new Button();
        	b.setText("Visit on " + date);
        	listView.getItems().add(b);
        	
        	b.setOnAction(e -> {
        		try {
					String history = Office.getInstance().getMedicalHistory(id, date);
					historyArea.setText(history);
				} catch (IOException e1) {
					historyArea.setText(e1.toString());
				}
        	});
        }
        borderPane.setLeft(listView);

        // Edit, Save, Close buttons 
        HBox buttonBox = new HBox(10);
        buttonBox.setStyle("-fx-padding: 10px;");
        Button editButton = new Button("Edit");
        Button saveButton = new Button("Save");
        Button closeButton = new Button("Close");
        buttonBox.getChildren().addAll(editButton, saveButton, closeButton);
        borderPane.setBottom(buttonBox);
        
        closeButton.setOnAction(event -> Platform.exit());

        Scene scene = new Scene(borderPane, 600, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
        borderPane.setStyle("-fx-background-color: white;");

    }

    public static void main(String[] args) {
        launch(args);
    }

	public void display() {
		// TODO Auto-generated method stub
		
	}
}

