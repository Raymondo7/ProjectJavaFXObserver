package application;


import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class View extends VBox implements Observer {
	private TextField txt1;
	private TextField txt2;
	private TextField lblResultat;
	private Model model;
	
	public View(Model model) {
		this.model = model;
		this.model.addObserver(this);
		
		txt1 = new TextField();
		txt2 = new TextField();
		Button calculerBtn = new Button("Calculer");
		calculerBtn.setOnAction(event -> {
			int nbre1 = Integer.parseInt(txt1.getText());
			int nbre2 = Integer.parseInt(txt2.getText());
			lblResultat.clear();
			model.calculer(nbre1, nbre2);
		});
		
		lblResultat = new TextField();
		
		HBox hboxA = new HBox(new Label("Nombre 1 : "),txt1);
		HBox hboxB = new HBox(new Label("Nombre 2 : "),txt2);
		HBox hboxC = new HBox(new Label("Résultat : "),lblResultat);
		VBox vbox = new VBox(hboxA,hboxB,calculerBtn,hboxC);
		
		this.getChildren().add(vbox);
	}
	
	@Override
	public void notifier() {
		Platform.runLater(() -> lblResultat.appendText(String.valueOf(model.getResultat())));

	}

}
