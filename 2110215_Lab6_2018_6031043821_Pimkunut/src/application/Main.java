package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import logic.Logic;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
		
	private static CombatScreen combatScreen;
	private static CharacterList characterList;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			combatScreen = new CombatScreen(Logic.getInstance().getParty(),Logic.getInstance().getBoss());
			characterList = new CharacterList(Logic.getInstance().getParty());
			
			BorderPane root = new BorderPane();
			root.setTop(combatScreen);
			root.setBottom(characterList);
			Scene scene = new Scene(root,800,600);
			primaryStage.setTitle("Battle Simulation");
			primaryStage.setOnCloseRequest(e -> {
				primaryStage.close();
				System.exit(0);
			});
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static void updateUI() {
		Main.combatScreen.update();
		Main.characterList.update();
	}
}
