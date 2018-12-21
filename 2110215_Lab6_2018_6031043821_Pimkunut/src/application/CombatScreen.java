package application;

import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import logic.Character;

public class CombatScreen extends HBox {
	
	private Canvas bossCanvas;
	private Canvas partyCanvas;	
	private ArrayList<Character> party;
	private Character boss;

	public CombatScreen(ArrayList<Character> party, Character boss) {
		super();
		
		this.party = party;
		this.boss = boss;
		
		bossCanvas = new Canvas(500,400);
		drawPortrait(bossCanvas.getGraphicsContext2D(), this.boss, 0, 0, bossCanvas.getWidth(), bossCanvas.getHeight());
		partyCanvas = new Canvas(300, 400);
		drawPartyCanvas(partyCanvas.getGraphicsContext2D(), this.party);
		
		this.getChildren().addAll(bossCanvas, partyCanvas);
	}
	
	private void drawPartyCanvas(GraphicsContext gc, ArrayList<Character> party) {
		double portraitWidth = 95;
		double portraitHeight = 190;
		gc.setFill(Color.BLACK);
		gc.fillRect(0,0,partyCanvas.getWidth(),partyCanvas.getHeight());
		drawPortrait(gc, party.get(0), 35, 5, portraitWidth, portraitHeight);
		drawPortrait(gc, party.get(1), 170, 5, portraitWidth, portraitHeight);
		drawPortrait(gc, party.get(2), 35, 205, portraitWidth, portraitHeight);
		drawPortrait(gc, party.get(3), 170, 205, portraitWidth, portraitHeight);
	}
	
	private void drawPortrait(GraphicsContext gc, Character character, double x, double y, double w, double h) {
		gc.setFill(Color.WHITE);
		gc.fillRect(x, y, w, h);
		gc.drawImage(LoadImage(character.getImagePath()), x, y, w, h);
		gc.setFill(new Color( 1, 0, 0, 0.4));
		double fillHeight = h * ( (double) (character.getMaxHp() - character.getHp()) / (double) character.getMaxHp() );
		gc.fillRect(x, y + h - fillHeight, w, fillHeight);
	}
	
	private Image LoadImage(String imagePath) {
		// TODO
		return new Image(ClassLoader.getSystemResource(imagePath).toString());
	}
	
	public void update() {
		drawPortrait(bossCanvas.getGraphicsContext2D(), this.boss, 0, 0, bossCanvas.getWidth(), bossCanvas.getHeight());
		drawPartyCanvas(partyCanvas.getGraphicsContext2D(), this.party);
	}
		
}
