package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MyNote extends Application {

	@Override
	public void start(Stage primaryStage) {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_LEFT);
		grid.setHgap(8);
		grid.setVgap(8);
		grid.setPadding(new Insets(10, 5, 10, 5));

		VBox vbox = new VBox(3);

		HBox hbox1 = new HBox(3);
		Label Topic = new Label("Topic :");
		TextField topicTextField = new TextField();
		topicTextField.setPrefWidth(200);

		hbox1.getChildren().addAll(Topic, topicTextField);

		HBox hbox2 = new HBox(3);
		Label Date = new Label("Date : ");
		DatePicker datepicker = new DatePicker();
		datepicker.setPrefWidth(150);

		hbox2.getChildren().addAll(Date, datepicker);

		vbox.getChildren().addAll(hbox1, hbox2);
		grid.add(vbox, 0, 1);

		TextArea textArea = new TextArea();
		grid.add(textArea, 0, 2);

		HBox hbox3 = new HBox(3);
		hbox3.setAlignment(Pos.BOTTOM_RIGHT);
		Button OKBtn = new Button("OK");
		OKBtn.setPrefWidth(60);
		Button ClearBtn = new Button("Clear");
		ClearBtn.setPrefWidth(60);

		hbox3.getChildren().addAll(OKBtn, ClearBtn);

		grid.add(hbox3, 0, 3);

		OKBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Message");
				alert.setHeaderText("Message");
				alert.setContentText("Topic : " + topicTextField.getText() + "\nDate : " + datepicker.getValue()
						+ "\nDescription : " + textArea.getText());
				alert.showAndWait();
			}
		});
		
		ClearBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				topicTextField.setText("");
				datepicker.setValue(null);
				textArea.setText("");
			}
			
		});

		Scene scene = new Scene(grid, 270, 300);

		primaryStage.setScene(scene);
		primaryStage.setTitle("MyNote");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
