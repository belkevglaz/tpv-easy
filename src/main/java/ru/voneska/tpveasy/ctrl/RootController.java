package ru.voneska.tpveasy.ctrl;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author <a href="mailto:belkevglaz@gmail.com">Aksenov Ivan</a>
 */
public class RootController implements Initializable {

	@FXML
	private TreeView<String> statsTreeView;

	public void initialize(URL url, ResourceBundle resourceBundle) {
		assert statsTreeView != null;

		TreeItem<String> rootItem = new TreeItem<String>("Inbox");
		rootItem.setExpanded(true);
		for (int i = 1; i < 6; i++) {
			TreeItem<String> item = new TreeItem<String>("Message" + i);
			rootItem.getChildren().add(item);
		}

		statsTreeView.setRoot(rootItem);

	}
}
