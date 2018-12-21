import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class InputField extends VBox {
	
	private TextField textField;
	
	public InputField(String title, String promptText) {
		
		// TODO Complete InputField constructor
		setSpacing(5);
		setPadding(new Insets(5));
		Label Title = new Label(title);
		this.textField = new TextField(promptText);
		getChildren().addAll(Title, this.textField);
		
	}

	public String getText() {
		// TODO Implement this method
		return textField.getText().trim();
	}
	
}
