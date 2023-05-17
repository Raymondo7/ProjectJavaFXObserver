package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller extends Application{
	private View view;
	private Model model;
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		model = new Model(0,0);
		view = new View(model);
		Scene scene = new Scene(view);
		
		
		primaryStage.setTitle("Appli d'addition");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
