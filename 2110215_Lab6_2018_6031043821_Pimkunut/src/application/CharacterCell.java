package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.Character;
import logic.Logic;

public class CharacterCell extends HBox {

	private Character owner;
	private ActiveBar activeBar;
	private Button attackBtn;
	private Label hpLabel;
	private PotionPane potionPane;
	
	public CharacterCell(Character owner) {
		super(10);
		
		this.owner = owner;
		
		Label nameLabel = new Label(this.owner.getName());
		nameLabel.setFont(new Font(24));
		nameLabel.setPrefWidth(100);
		nameLabel.setAlignment(Pos.CENTER);
		
		hpLabel = new Label(this.owner.printHp());
		hpLabel.setPrefWidth(100);
		hpLabel.setFont(new Font(18));
	
		activeBar = new ActiveBar();
		potionPane  = new PotionPane(owner);
		
		attackBtn = new Button("Attack");
		attackBtn.setPrefWidth(200);
		attackBtn.setOnAction(e -> {
			this.owner.attack(Logic.getInstance().getBoss());
			this.owner.setActivePoint(0);
			activeBar.setProgress(0);
		});
		
		this.getChildren().addAll(nameLabel,  hpLabel, activeBar, attackBtn, potionPane);
		this.setPadding(new Insets(5));
		this.setHeight(50);
		this.setFillHeight(true);
		this.setAlignment(Pos.CENTER_LEFT);
		this.setBorder(new Border(new BorderStroke(Color.gray(0.80),BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));	
	}
	
	public void update() {
		this.activeBar.setProgress((double) owner.getActivePoint()/(double) Character.getLimit());
		this.hpLabel.setText(owner.printHp());
		this.attackBtn.setDisable(!owner.isReady());
		
	}

	public Character getOwner() {
		return owner;
	}

	public ActiveBar getActiveBar() {
		return activeBar;
	}

	public Label getHpLabel() {
		return hpLabel;
	}
	
}
