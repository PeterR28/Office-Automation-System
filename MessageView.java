import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class MessageView 
{
	public void display()
	{
		//create the main stage
		Stage primaryStage = new Stage();
		//label for new messages
		Label newMessages = new Label("New Messages: ");
		
		//text area to display messages
		TextArea messages = new TextArea();
		//mark the messages as read 
		Button markAsRead = new Button("Mark as read");
		
		//Send Messages label 
		Label sendMessage = new Label("Send Messages to");

		//layout for formatting 
		VBox layout = new VBox(15);
		//choose to send the message either to the doctor or nurse 
	    ToggleGroup radioGroup = new ToggleGroup();
	    RadioButton nurse = new RadioButton("Nurse");
	    nurse.setToggleGroup(radioGroup);
	    RadioButton doctor = new RadioButton("Doctor");
	    doctor.setToggleGroup(radioGroup);
	    //show the new messages 
	    TextArea inputMessage = new TextArea();
	    Button sendButton = new Button("Send");
	    
	    layout.setPadding(new Insets(15));
	    layout.getChildren().addAll(newMessages, messages, markAsRead, sendMessage, nurse, doctor,inputMessage, sendButton );
	    
	    Scene scene = new Scene(layout,400,500);
		primaryStage.setTitle("Patient View");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
