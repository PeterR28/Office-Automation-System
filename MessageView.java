
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class MessageView 
{
	public TextArea newMessages;
	private TextArea inputMessage;
	private TextField messageId;
	private TextField sendMessageId;
	public void display(int id)
	{
		//create the main stage
		Stage primaryStage = new Stage();
		//label for new messages
		VBox root = new VBox(10);
		root.setAlignment(Pos.CENTER_LEFT);

		// New Messages section
		HBox newMessageBox = new HBox(5);
		Label newMessageLabel = new Label("New Messages:");
		messageId = new TextField();
		Button viewButton = new Button("View");
		newMessageBox.getChildren().addAll(newMessageLabel, messageId, viewButton);

		newMessages = new TextArea(); // Presumed existing TextArea

		// Send Messages section
		HBox sendMessageBox = new HBox(5);
		Label sendMessageLabel = new Label("Send Messages:");
		sendMessageId = new TextField();
		sendMessageBox.getChildren().addAll(sendMessageLabel,sendMessageId);

		inputMessage = new TextArea(); // Presumed existing TextArea
		Button sendButton = new Button("Send");

		// Add all components to root
		 root.setPadding(new Insets(15));
		root.getChildren().addAll(newMessageBox, newMessages, sendMessageBox, inputMessage, sendButton);
	    Scene scene = new Scene(root,400,500);
		primaryStage.setTitle("Patient View");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		sendButton.setOnAction(e -> sendMessage(id) );
		viewButton.setOnAction(e -> viewMessages(id));
	}																			
	private void viewMessages(int id) 
	{
		String viewId = messageId.getText();
		int useableId  = Integer.parseInt(viewId);
		try {
			String getMessage = Office.getInstance().getMessages(useableId);
			newMessages.setText(getMessage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void sendMessage(int id) 
	{
		String viewId = sendMessageId.getText();
		int useableId  = Integer.parseInt(viewId);
		String message = inputMessage.getText();
		try {
			Office.getInstance().storeMessages(useableId, message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inputMessage.clear();
		//messages.setText(inputMessage.getText());
	}
}
