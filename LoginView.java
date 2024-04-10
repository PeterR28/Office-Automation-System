
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LoginView extends Application {
	
	public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: white;");

        Label welcomeLabel = new Label("File-a-Doc");
        welcomeLabel.setFont(Font.font("Garamond", FontWeight.BOLD, 24));
        welcomeLabel.setTextFill(Color.BLUE);
        welcomeLabel.setAlignment(Pos.CENTER);

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button signInButton = new Button("Sign In");
        signInButton.setOnAction(e -> {
            String password = passwordField.getText();
            String username = usernameField.getText();
            SignInHandler signInHandler = new SignInHandler();
            Actor.Role accountType = signInHandler.checkAccountType(username, password);
            System.out.println(accountType);
            if (accountType!=null)
            {
            	
	            if (accountType == Actor.Role.DOCTOR) {
	                // Open DoctorView
	            	DoctorView doctorView = new DoctorView();
	               doctorView.display(0);
	               // primaryStage.close(); // Close the login window
	            	System.out.println("Should be doctor view");
	            } else if (password.startsWith("0")) {
	                // Open NurseView
	            	System.out.println("Should be nurse View ");
	               // new NurseView();
	            } else {
	            	
	                // Open PatientView for other passwords
	                PatientView patientView = new PatientView();
	                Patient openPatient = new Patient();
	                try {
						Office.getInstance().storeAccount(usernameField.getText(), passwordField.getText(), openPatient.getRole());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	                try {
						Office.getInstance().storePatientInfo(openPatient.getId(), openPatient.getContactInfo());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	                patientView.display(openPatient.getId());
	                
	            }
            }else 
            {
            	signInHandler.incorrectLoginError();
            	
            }
            });

        Button createAccountButton = new Button("Create New Account");
        createAccountButton.setOnAction(e -> {
        	 PatientView patientView = new PatientView();
             Patient newPatient = new Patient();
             try {
					Office.getInstance().storeAccount(usernameField.getText(), passwordField.getText(), newPatient.getRole());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
             try {
					Office.getInstance().storePatientInfo(newPatient.getId(), newPatient.getContactInfo());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
             patientView.display(newPatient.getId());
           
        });

        root.getChildren().addAll(welcomeLabel, usernameField, passwordField, signInButton, createAccountButton);
        
        Scene scene = new Scene(root, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("File-a-Doc Login");
        primaryStage.show();
    } 
}
