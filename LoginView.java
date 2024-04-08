package login;

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
            if (password.startsWith("00")) {
                // Open DoctorView
            	DoctorView doctorView = new DoctorView();
                doctorView.start(new Stage());
                primaryStage.close(); // Close the login window
            } else if (password.startsWith("0")) {
                // Open NurseView
                new NurseView();
            } else {
                // Open PatientView for other passwords
                new PatientView();
            }
        });

        Button createAccountButton = new Button("Create New Account");
        createAccountButton.setOnAction(e -> {
            // Implement logic to handle account creation
            System.out.println("Create New Account button clicked");
        });

        root.getChildren().addAll(welcomeLabel, usernameField, passwordField, signInButton, createAccountButton);

        Scene scene = new Scene(root, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("File-a-Doc Login");
        primaryStage.show();
    }
   
}
