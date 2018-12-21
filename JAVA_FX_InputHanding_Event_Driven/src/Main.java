import javafx.application.Application;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import render.GameScreen;

public class Main extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		StackPane root = new StackPane();
		GameScreen gameScreen = new GameScreen(root);
		stage.setScene(gameScreen);
		stage.setTitle("Click click click");

		gameScreen.redraw("");
		stage.show();

		gameScreen.setOnKeyPressed((KeyEvent e) -> {
			String new_code = e.getCode().toString();
			gameScreen.redraw(new_code);
		});

	}
}


