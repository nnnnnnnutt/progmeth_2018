package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;

public class FXHelloWorld extends Application {

	// Override the start method in the Application class
	@Override
	public void start(Stage primaryStage) {
		// Create a scene and place a button in the scene
		Button btn = new Button("Hello world");
		Button btn2 = new Button("Java");
		StackPane root = new StackPane(); // -> root
		root.getChildren().add(btn);
		root.getChildren().add(btn2);
		Scene scene = new Scene(root, 300, 250); // -> scene; scene's size = 300x250
		primaryStage.setTitle("MyJavaFX"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene
		primaryStage.show(); //command to show
	}

	public static void main(String[] args) {
		launch(args);
	}
}
