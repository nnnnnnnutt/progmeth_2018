import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ControlPane extends VBox {

	private Button addButton;
	private Button clearButton;
	private Button viewButton;
	private InputField nameInput;
	private InputField voteInput;
	private ImageView imageView;

	public ControlPane() {

		// TODO Complete ControlPane constructor
		setAlignment(Pos.CENTER);
		setPrefWidth(250);
		setPadding(new Insets(15));
		setSpacing(10);
		this.nameInput = new InputField("Name", "Enter Name (String)");

		this.voteInput = new InputField("Vote Count", "Enter Vote Count (Number)");

		this.addButton = new Button("Add");
		addButton.setPrefWidth(100);

		this.clearButton = new Button("Clear");
		clearButton.setPrefWidth(100);

		this.viewButton = new Button("View");
		viewButton.setPrefWidth(100);

		// Default Setting. Do NOT CHANGE !!!
		setBorder(new Border(
				new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		setBackground(new Background(new BackgroundFill(Color.IVORY, null, null)));

		// ImageView On Top of ControlPane
		imageView = new ImageView(new Image(ClassLoader.getSystemResource("images/User.png").toString()));

		imageView.setPreserveRatio(true);
		imageView.setFitWidth(150);
		imageView.setFitHeight(150);
		Rectangle clip = new Rectangle(imageView.getFitWidth(), imageView.getFitHeight());
		clip.setArcWidth(150);
		clip.setArcHeight(150);
		imageView.setClip(clip);

		getChildren().addAll(imageView, this.nameInput, this.voteInput, this.addButton, this.clearButton,
				this.viewButton);

	}

	// TODO Generate getter methods
	public Button getAddButton() {
		return addButton;
	}

	public Button getClearButton() {
		return clearButton;
	}

	public Button getViewButton() {
		return viewButton;
	}

	public InputField getNameInput() {
		return nameInput;
	}

	public InputField getVoteInput() {
		return voteInput;
	}

	public ImageView getImageView() {
		return imageView;
	}
}
