
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
public class PatientView
{

	public void display(int id)
	{
		Stage primaryStage = new Stage();
		//the border pain  // splits into top, left , bottom, right, and center
		BorderPane layout = new BorderPane();
		
		//menu bar for account information
	     MenuBar menuBar = new MenuBar();
	     menuBar.setPadding(new Insets(10,10,10,10)); // this increases the height of the menu ba

	      // Create the Account Info menu
	     Menu accountInfo = new Menu();

	     Label label1 = new Label("Account Info");
	     label1.setPadding(new Insets(5,80,5,80));
	     accountInfo.setGraphic(label1);
	     
	     // Create the MenuItems for the Account Info menu
	     MenuItem contactInfo = new MenuItem("Account Info");
	     MenuItem signOut = new MenuItem("Sign Out");
	    //add items to account info menu 
	    accountInfo.getItems().addAll(contactInfo, signOut);
	       
	    //create patient history menu
	    Menu patientHistory = new Menu ();
	    Label label2 = new Label("Patient History");
	    label2.setPadding(new Insets(5,80,5,80));
	    patientHistory.setGraphic(label2);
	    
	    //add drop downs for patient history 
	    MenuItem previousVisits = new MenuItem("Previous Visits");
	    MenuItem  medicalHistory= new MenuItem("Medical History");
	    patientHistory.getItems().addAll(previousVisits, medicalHistory);
	   
	    //create messages menu bar
	    Menu messages = new Menu();
	    Label label3 = new Label("Messages");
	    label3.setPadding(new Insets(5,80,5,80));
	    messages.setGraphic(label3);
	    MenuItem sendMessages = new MenuItem("Go to Messages");
	    messages.getItems().addAll(sendMessages);
	    
	  //add everything to menu bar 
	    menuBar.getMenus().addAll(accountInfo, patientHistory, messages);
	    
	    Label welcome = new Label("Welcome!");
	    welcome.setFont(new Font("Arial", 35));
	    welcome.setTextFill(Color.BLUE);
	    BorderPane.setAlignment(welcome, Pos.CENTER);
	   	BorderPane.setMargin(welcome, new Insets(50,0,50,0));
	    
	    layout.setBottom(welcome);
	    layout.setTop(menuBar);
		Scene scene = new Scene(layout, 800, 600);
		primaryStage.setTitle("Patient View");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	    sendMessages.setOnAction(e -> createMessage());
	    contactInfo.setOnAction(e -> contactInfo(id));
	   // patientInfo.setOnAction(e -> patientInfo(id));
	    
	}

	private void patientInfo(int id) 
	{
		String patientInfo="";
		
	}

	private Object updateInsurance() 
	{
		System.out.println("Access patient Record according to Patient ID and update");
		return null;
	}

	private void contactInfo(int id ) 
	{
		String patientInfo =""; 
		try {
			patientInfo = Office.getInstance().getPatientInfo(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		   Stage popupStage = new Stage();
	        popupStage.setTitle("Patient Information");

	        // Components
	        Label infoLabel = new Label("Contact Info");

	        // TextField for patient information
	        TextArea infoField = new TextArea(); // Assume patientInfo is already set
	        infoField.setPrefWidth(300); // Set preferred width
	        infoField.setText(patientInfo);
	        // TextField for phone number update
	   
	        // Update button for patient information
	        Button updateInfoButton = new Button("Update Info");
	        updateInfoButton.setOnAction(event -> {
	        	String[] updatedInfo = new String[5];
	        	  String text = infoField.getText(); // Get text from the TextArea
	              String[] lines = text.split("\n"); // Split the text into lines
	              
	              // Optional: Print each line to the console
	              for (int i = 0; i<lines.length; i++) {
	                 updatedInfo[i] = lines[i];
	              }

	            try {
					Office.getInstance().storePatientInfo(id, updatedInfo);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            System.out.println("Updated info: " + infoField.getText());
	        });
	        
	        VBox layout = new VBox(10); // 10 pixels space between components
	        layout.setPadding(new Insets(20, 20, 20, 20)); // Margin around the VBox
	        layout.getChildren().addAll(infoLabel, infoField, updateInfoButton);
	        Scene scene = new Scene(layout);
	        popupStage.setScene(scene);
	        popupStage.show();
	        
	}

	private Object createMessage() 
	{
		MessageView patientMessages = new MessageView();
		patientMessages.display();
		return null;
	}

}
