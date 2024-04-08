package login;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

public class DoctorView {

    public void start(Stage primaryStage) {
    	 VBox root = new VBox(20);
         root.setPadding(new Insets(20));
         root.setAlignment(Pos.TOP_CENTER);
         root.setStyle("-fx-background-color: white;");

         // Welcome message
         Label welcomeLabel = new Label("Doctor View");
         welcomeLabel.setFont(Font.font("Garamond", 24));
         welcomeLabel.setTextFill(Color.BLUE);

         // Search bar
         HBox searchBox = new HBox(10);
         TextField searchBar = new TextField();
         searchBar.setPromptText("Search Patient");
         Button searchButton = new Button("Search");
         searchBox.getChildren().addAll(searchBar, searchButton);
         searchBox.setAlignment(Pos.CENTER);

         // Buttons for viewing patient records and messages
         HBox buttonBox = new HBox(20);
         Button viewRecordsButton = new Button("View Patient Records");
         viewRecordsButton.setOnAction(e -> {
             RecordsView recordsView = new RecordsView();
             recordsView.start(new Stage());
         });
         
         Button viewMessagesButton = new Button("View Messages");
         viewMessagesButton.setOnAction(e -> {
             MessageView messageView = new MessageView();
             messageView.start(new Stage());
         });
         
         buttonBox.getChildren().addAll(viewRecordsButton, viewMessagesButton);
         buttonBox.setAlignment(Pos.CENTER);

         // Patient information fields
         TextField patientNameField = new TextField();
         patientNameField.setPromptText("Patient Name");
         
         TextField dobField = new TextField();
         dobField.setPromptText("Date of Birth");
         
         TextField reasonField = new TextField();
         reasonField.setPromptText("Reason for Visit");
         
         TextArea notesArea = new TextArea();
         notesArea.setPromptText("Doctor's Notes");
         
         TextArea prognosisArea = new TextArea();
         prognosisArea.setPromptText("Preliminary Prognosis");
         
         TextArea prescriptionsArea = new TextArea();
         prescriptionsArea.setPromptText("Recommended Prescriptions");
         
         TextArea referralsArea = new TextArea();
         referralsArea.setPromptText("Referrals");

         // Send to pharmacy button
         Button sendToPharmacyButton = new Button("Send to Pharmacy");
         sendToPharmacyButton.setOnAction(e -> {
             // Implement logic to send patient information to pharmacy
             System.out.println("Sending patient information to pharmacy...");
         });

         // Save patient info button
         Button saveInfoButton = new Button("Save Patient Info");
         saveInfoButton.setOnAction(e -> {
             // Implement logic to save patient information to a text file
             System.out.println("Saving patient information...");
         });

         // Add all components to the root layout
         root.getChildren().addAll(
                 welcomeLabel, searchBox, buttonBox,
                 patientNameField, dobField, reasonField,
                 notesArea, prognosisArea, prescriptionsArea, referralsArea,
                 sendToPharmacyButton, saveInfoButton
         );

         // Create scene and set stage
         Scene scene = new Scene(root, 800, 600);
         primaryStage.setScene(scene);
         primaryStage.setTitle("Doctor View");
         primaryStage.show();
     }

}
