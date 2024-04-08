package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class nurseView extends Application {

    @Override
    public void start(Stage primaryStage) {
   
        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(15));

        
        Label headerLabel = new Label("File-a-doc");
        headerLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

       
        Label welcomeLabel = new Label("Welcome Nurse!");

        //search
        TextField searchField = new TextField();
        searchField.setPromptText("Search");
        Button messagesButton = new Button("Messages");
        HBox topMenu = new HBox(10, searchField, messagesButton);
        topMenu.setAlignment(Pos.CENTER_RIGHT);

        //vitals
        Label vitalLabel = new Label("Vital");
        vitalLabel.setStyle("-fx-background-color:  blue; -fx-text-fill: white; -fx-padding: 5px;"
                + "-fx-font-weight: bold; -fx-border-color: black; -fx-border-width: 1;"
                + "-fx-background-radius: 5px; -fx-border-radius: 5px;");
        vitalLabel.setMinWidth(Region.USE_PREF_SIZE); // Make sure the label is wide enough to fit the text
        GridPane vitalGrid = new GridPane();
        TextField weightField = new TextField();
        weightField.setPromptText("Weight");
        TextField heightField = new TextField();
        heightField.setPromptText("Height");
        TextField bodyTemperatureField = new TextField();
        bodyTemperatureField.setPromptText("Body temperature");
        TextField bloodPressureField = new TextField();
        bloodPressureField.setPromptText("Blood pressure");
        TextField ageField = new TextField();
        ageField.setPromptText("Age");
        vitalGrid.add(weightField, 1, 0);
        vitalGrid.add(heightField, 1, 1);
        vitalGrid.add(bodyTemperatureField, 1, 2);
        vitalGrid.add(bloodPressureField, 1, 3);
        vitalGrid.add(ageField, 1, 4);
        Button confirmButton = new Button("Confirm");
        vitalGrid.add(confirmButton, 1, 5);

        
        //medicalHistory
        Label medicalHistoryLabel = new Label("Medical History");
        medicalHistoryLabel.setStyle("-fx-background-color:  blue; -fx-text-fill: white; -fx-padding: 5px;"
                + "-fx-font-weight: bold; -fx-border-color: black; -fx-border-width: 1;"
                + "-fx-background-radius: 5px; -fx-border-radius: 5px;");

        TextArea medicalHistoryArea = new TextArea();
        medicalHistoryArea.setPromptText("Type here");
        HBox medicalHistoryBox = new HBox(10, medicalHistoryLabel, medicalHistoryArea);
        HBox buttonsBox = new HBox(10);
        Button editButton = new Button("Edit");
        Button saveButton = new Button("Save");
        Button sendButton = new Button("Send to Doctor");
        buttonsBox.getChildren().addAll(editButton, saveButton, sendButton);

        
        mainLayout.getChildren().addAll(headerLabel, welcomeLabel, topMenu, vitalLabel,vitalGrid, medicalHistoryBox, buttonsBox);

     
        Scene scene = new Scene(mainLayout, 600, 600);
        primaryStage.setTitle("File-a-doc Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

