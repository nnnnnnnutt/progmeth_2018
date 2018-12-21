package logic;

import java.util.ArrayList;
import java.util.Random;

import application.Main;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Logic {

	public static Logic instance = new Logic();
	private ArrayList<Character> party;
	private ArrayList<Character> activeCharacters;
	private Character boss;

	public Logic() {
		party = new ArrayList<Character>();
		Character cloud = new Character("Cloud", 345, 30, 65, "cloud.png");
		Character tifa = new Character("Tifa", 295, 50, 45, "tifa.png");
		Character aerith = new Character("Aerith", 200, 40, 20, "aerith.png");
		Character caitsith = new Character("Cait Sith", 425, 35, 45, "cait-sith.png");
		party.add(cloud);
		party.add(tifa);
		party.add(aerith);
		party.add(caitsith);
		
		boss = new Character("Sephiroth", 1500, 40, 105, "sephiroth.png");

		startGameLoop();
	}

	public void startGameLoop() {
		activeCharacters = new ArrayList<Character>(party);
		Thread t = new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(16);
					runLogicLoop();
					Platform.runLater(() -> {
						Main.updateUI();
					});
					if (activeCharacters.isEmpty() || boss.isDead()) {
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (activeCharacters.isEmpty())
			{
				Platform.runLater(() -> {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setContentText("So sad that Sephiroth will destroy this planet!");
					alert.setHeaderText("You are DEFEATED!");
					alert.setTitle("Battle Result");
					alert.show();
				});
			} else {
				Platform.runLater(() -> {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setContentText("Congratulation! The planet is saved!");
					alert.setHeaderText("You are VICTORIOUS!");
					alert.setTitle("Battle Result");
					alert.show();
				});
			}
		});
		t.start();
	}

	public static Logic getInstance() {
		return instance;
	}

	public ArrayList<Character> getParty() {
		return this.party;
	}

	public Character getBoss() {
		return this.boss;
	}
	
	public void runLogicLoop () {
		boss.setActivePoint(boss.getActivePoint() + boss.getSpeed());
		if (boss.getActivePoint() >= Character.getLimit()) {
			Character target = activeCharacters.get((new Random().nextInt(activeCharacters.size())));
			boss.attack(target);
			if (target.isDead()) {
				target.setActivePoint(0);
				activeCharacters.remove(target);
			}
			boss.setActivePoint(0);
		}
		for (Character character : activeCharacters) {
			if (!character.isReady()) {
				character.setActivePoint(character.getActivePoint() + character.getSpeed());
				if (character.getActivePoint() > Character.getLimit()) {
					character.setActivePoint(Character.getLimit());
				}
			}
		}		
	}

}
