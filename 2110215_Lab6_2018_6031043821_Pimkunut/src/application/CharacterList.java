package application;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.Character;

public class CharacterList extends VBox{

	public CharacterList(ArrayList<Character> party) {
		super();
		this.setFillWidth(true);
		this.setAlignment(Pos.CENTER);
		
		for (Character character : party) {
			this.getChildren().add(new CharacterCell(character));
		}
		
		this.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));	
	}
	
	public void update() {
		for (Node node : this.getChildren()) {
			((CharacterCell) node).update();
		}
	}

}
