package ru.voneska.tpveasy.ctrl;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ru.voneska.tpveasy.tpv.TPVParser;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ResourceBundle;

/**
 * @author <a href="mailto:belkevglaz@gmail.com">Aksenov Ivan</a>
 */
public class LayoutController implements Initializable {

	@FXML
	private TreeView<String> statsTreeView;
	@FXML
	private MenuItem menuItemOpen;

	private Stage stage;


	public void initialize(URL url, ResourceBundle resourceBundle) {
		assert statsTreeView != null;

		TreeItem<String> rootItem = new TreeItem<String>("Inbox");
		rootItem.setExpanded(true);
		for (int i = 1; i < 6; i++) {
			TreeItem<String> item = new TreeItem<String>("Message" + i);
			rootItem.getChildren().add(item);
		}

		statsTreeView.setRoot(rootItem);

		menuItemOpen.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent actionEvent) {
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Open TPV File");
				File file = fileChooser.showOpenDialog(stage);
				if (file != null) {
					try {
						TPVParser parser = new TPVParser(file);
						parser.parse();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});

	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
