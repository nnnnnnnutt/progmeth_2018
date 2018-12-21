package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logic.Character;
import logic.Logic;

public class PotionPane extends StackPane {
	private Character owner;
	private Button potionbtn;
	private ProgressBar potionbar;
	
	public PotionPane(Character owner) {
		this.setAlignment(Pos.CENTER_LEFT);
		this.owner = owner;
		
		potionbtn = new Button("Use Potion");
		potionbtn.setPrefWidth(100);
		
		potionbar = new ProgressBar();
		potionbar.setPrefWidth(100);
		
		potionbar.setVisible(false);
		
		this.getChildren().addAll(potionbtn,potionbar);
		this.setPadding(new Insets(5));
		this.setHeight(50);
		
		if (this.owner.isDead()) {
			potionbtn.setVisible(true);
			potionbtn.setDisable(false);
			potionbar.setVisible(false);
		}
		
	
		potionbtn.setOnAction(new EventHandler<ActionEvent>() { 
			@Override
			public void handle(ActionEvent event){ 
				this.owner.usePotion();
				potionbtn.setVisible(false);
				potionbar.setVisible(true);
				potionbar.setProgress(0);
				

				
			}
			
		});
	}
		
//	public void update() {
//		if (this.owner.isDead()) {
//			potionbtn.setVisible(true);
//			potionbtn.setDisable(false);
//			potionbar.setVisible(false);
//		}
//	}
}
