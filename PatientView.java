
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
public class PatientView extends Application 
{

	public static void main(String[] args) 
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
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
	     MenuItem contactInfo = new MenuItem("Contact Info");
	     MenuItem insuranceInfo = new MenuItem("Insurance Info");
	     MenuItem pharmacyInfo = new MenuItem("Pharmacy Info");
	     MenuItem signOut = new MenuItem("Sign Out");
	    //add items to account info menu 
	    accountInfo.getItems().addAll(contactInfo, insuranceInfo, pharmacyInfo, signOut);
	       
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
	    MenuItem newMessages = new MenuItem("New Messages");
	    MenuItem sendMessages = new MenuItem("Send Messages");
	    messages.getItems().addAll(newMessages, sendMessages);
	    
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
		
	}

}
