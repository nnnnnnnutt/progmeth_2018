import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class PieChartPane extends VBox {
	
	ObservableList<Data> pieChartDataList = FXCollections.observableArrayList();
	
	public PieChartPane() {
		
		// TODO Complete PieChartPane constructor
		setAlignment(Pos.CENTER);
		setPrefWidth(450);
		setPadding(new Insets(15));
		setSpacing(10);
		
		// Default Setting. Do NOT CHANGE !!!
		setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, 
			CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		setBackground(new Background(new BackgroundFill(Color.IVORY, null, null)));
		getChildren().addAll(createHeaderLabel(),createPieChart());
	
	}
	
	public void addData(String name, int voteCount) {
		// TODO Implement this method
		int check = 0;
		for (int i = 0; i < pieChartDataList.size(); i++) {
			if(pieChartDataList.get(i).getName().equals(name)) {
				double vote = pieChartDataList.get(i).getPieValue();
				pieChartDataList.get(i).setPieValue(voteCount+vote);
				check += 1;
				break;
			}
		}
		if (check == 0) {
			Data newData = new Data(name, voteCount);
			pieChartDataList.add(newData);
		}
	}
	
	public void clearData() {
		// TODO Implement this method
		pieChartDataList.clear();
	}
	
	private PieChart createPieChart() {
		// TODO Implement this method
		PieChart pieChart = new PieChart();
        pieChart.setData(pieChartDataList);
		
		return pieChart;
	}
	
	private Label createHeaderLabel() {
		// TODO Implement this method
		Label label = new Label("Senbatsu Vote Summary");
		return label;
	}
	
}

