package ru.voneska.tpveasy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.voneska.tpveasy.ctrl.RootController;

/**
 */
public class App extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample.fxml"));
		Parent root = (Parent) loader.load();
		RootController controller = loader.getController();
		controller.setStage(stage);

		stage.setTitle("TPV Easy Viewer");
		stage.setScene(new Scene(root, 500, 400));
		stage.show();

	}


	public static void main(String[] args) {
		launch(args);
	}
}
