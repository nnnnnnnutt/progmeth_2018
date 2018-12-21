import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class EventManager {
	
	private PieChartPane pieChartPane;
	private VoteLogPane voteLogPane;
	
	public EventManager(PieChartPane pieChartPane, VoteLogPane voteLogPane) {
		this.pieChartPane = pieChartPane;
		this.voteLogPane = voteLogPane;
	}
	
	public void setUpAddButtonEvent(Button addButton, InputField nameInput, InputField voteInput, ImageView imageView) {
		addButton.setOnAction(new AddButtonEventHandler(nameInput, voteInput, imageView));
	}
	
	public void setUpClearButtonEvent(Button clearButton) {
		// TODO Set up event handler
		clearButton.setOnAction(e -> {
			this.pieChartPane.clearData();
			this.voteLogPane.clearData();
		});
		
	}
	
	public void setUpViewButtonEvent(Button viewButton) {
		viewButton.setOnAction(e -> {
			Dialog dialog = new Dialog();
			dialog.show();
		});
	}
	
	private class AddButtonEventHandler implements EventHandler<ActionEvent>{
		
		private InputField nameInput;
		private InputField voteInput;
		private ImageView imageView;
		
		public AddButtonEventHandler(InputField nameInput, InputField voteInput, ImageView imageView) {
			this.nameInput = nameInput;
			this.voteInput = voteInput;
			this.imageView = imageView;
		}

		@Override
		public void handle(ActionEvent arg0) {
			try {
				// TODO Implement this block
				String name = this.nameInput.getText();
				Integer vote =Integer.valueOf(voteInput.getText());
				name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
				
				if (vote > 0) {
					pieChartPane.addData(name, vote);
					voteLogPane.addData(name, vote);
				}
				else {
					Alert warning = new Alert(AlertType.ERROR);
					warning.setContentText("Please Fill In Positive Vote Value");
					warning.show();
				}
				
				// Set ImageView according to name (Will go to Exception if name is not included in the list)
				imageView.setImage(new Image(ClassLoader.getSystemResource("images/" + name + ".jpg").toString()));
			} catch(NumberFormatException e) {
				// TODO Implement this block
				if (voteInput == null || voteInput.getText().trim().isEmpty()) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setContentText("Please Fill In Vote Count");
					alert.show();
				}
				else {
					Alert error = new Alert(AlertType.ERROR);
					error.setContentText("Incorrect Vote Format");
					error.show();
				}
				
			} catch(Exception e) {
				// Set default ImageView when name is not included in the list
				imageView.setImage(new Image(ClassLoader.getSystemResource("images/User.png").toString()));
			}
		}
		
	}

}
