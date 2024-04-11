import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

public class DoctorView {

	 	private TextField patientNameField;
	    private TextField dobField;   
	    private TextField reasonField;
	    private TextArea notesArea;
	    private TextArea prognosisArea;
	    private TextArea prescriptionsArea;
	    private TextArea referralsArea;
	    
    public void display(int id) {
    	
    	
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
         searchBar.setPromptText("Search by Patient I.D.");
         Button searchButton = new Button("Search");
         searchBox.getChildren().addAll(searchBar, searchButton);
         searchBox.setAlignment(Pos.CENTER);
         patientNameField = new TextField();
         patientNameField.setPromptText("Patient Name");
         dobField = new TextField();
         dobField.setPromptText("Date of Birth");
        searchButton.setOnAction(e -> {
        	 String patientIdText = searchBar.getText();
                     int patientId = Integer.parseInt(patientIdText);
                     
                    String patientInfo ="";
					try {
						patientInfo = Office.getInstance().getPatientInfo(patientId);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                     String[] patientInfoLines = patientInfo.split("\n", -1);

                     if (patientInfo != null && patientInfoLines.length >= 2) {
                         // Assuming nameTextBox and dobTextBox are your JTextFields
                         patientNameField.setText(patientInfoLines[0]); // Set the patient's name
                         dobField.setText(patientInfoLines[1]); // Set the patient's date of birth
                     } else {
                         // Handle error or invalid patient ID scenario
                         System.out.println("Unable to retrieve patient information.");
                     }
         
         });



         // Initialize patient information fields
      
         // Buttons for viewing patient records and messages
         HBox buttonBox = new HBox(20);
         Button viewRecordsButton = new Button("View Patient Records");
         viewRecordsButton.setOnAction(e -> {
        	 Stage popupStage = new Stage();
    	     popupStage.setTitle("Patient Information");
    	        // Components
    	    
    	      Label enterIdLabel = new Label("Enter Id:");
    	      TextField enterIdField = new TextField();
    	      enterIdField.setPrefWidth(200); 
    	      Button enterIdButton = new Button("Enter Id");
    	      enterIdButton.setOnAction(even ->
    	      {
    	    		String IdEntered = enterIdField.getText();
    	        	int intId = Integer.parseInt(IdEntered);
    	    	  RecordsView newRecord = new RecordsView();
    	  		newRecord.display(intId);
    	        	
    	        });
    	      VBox layout = new VBox(10); // 10 pixels space between components
    	      layout.setPadding(new Insets(20, 20, 20, 20)); // Margin around the VBox
    	      layout.getChildren().addAll(enterIdLabel, enterIdField, enterIdButton);
    	       Scene scene = new Scene(layout);
    	       popupStage.setScene(scene);
    	      popupStage.show();       
         });
         
         Button viewMessagesButton = new Button("View Messages");
         viewMessagesButton.setOnAction(e -> {
             MessageView messageView = new MessageView();
             messageView.display(id);
         });
         
         buttonBox.getChildren().addAll(viewRecordsButton, viewMessagesButton);
         buttonBox.setAlignment(Pos.CENTER);

         // Patient information fields
        
   
         reasonField = new TextField();
         reasonField.setPromptText("Reason for Visit");
         
         notesArea = new TextArea();
         notesArea.setPromptText("Doctor's Notes");
         
          prognosisArea = new TextArea();
         prognosisArea.setPromptText("Preliminary Prognosis");
         
         prescriptionsArea = new TextArea();
         prescriptionsArea.setPromptText("Recommended Prescriptions");
         
         referralsArea = new TextArea();
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
        	 String patientIdText = searchBar.getText();
        	 
             int patientId = Integer.parseInt(patientIdText);
             String currentInfo ="";
			try {
				currentInfo = Office.getInstance().getPatientInfo(patientId);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
             String[] infoArray = currentInfo.split("\n");
             String[] addedInfo = new String[11];
             System.arraycopy(infoArray, 0, addedInfo, 0, infoArray.length);
             addedInfo[6] = reasonField.getText();
             addedInfo[7] = notesArea.getText();
             addedInfo[8] = prognosisArea.getText();
             addedInfo[9] = prescriptionsArea.getText();
             addedInfo[10] = referralsArea.getText();
             
             //loop through text fields and put it into the info
           
             try {
				Office.getInstance().storePatientInfo(patientId, addedInfo);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
         Stage Stage = new Stage();
         Stage.setScene(new Scene(root, 800,600));
         Stage.setTitle("Doctor View");
         Stage.show();
        
     }
    

}
