package ru.voneska.tpveasy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.voneska.tpveasy.ctrl.LayoutController;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author <a href="mailto:belkevglaz@gmail.com">Aksenov Ivan</a>
 */
public class App extends Application {

	private static final String WAS_HOME_PARAM = "was.home";

	static String[] jars = new String[]{
			"\\lib\\bootstrap.jar",
			"\\plugins\\com.ibm.ws.runtime.jar",
			"\\plugins\\com.ibm.ws.emf.jar",
			"\\runtimes\\com.ibm.ws.admin.client_8.5.0.jar"
	};

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/layout.fxml"));
		Parent root = (Parent) loader.load();
		LayoutController controller = loader.getController();
		controller.setStage(stage);

		stage.setTitle("TPV Easy Viewer");
		stage.setScene(new Scene(root, 500, 400));
		stage.show();
	}

	public static void main(String[] args) {

		File wasHome = new File(System.getProperty(WAS_HOME_PARAM));
		if (wasHome.exists()) {
			try {

				for (String jar : jars) {
					loadJar(new File(System.getProperty(WAS_HOME_PARAM) + jar));
				}

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		launch(args);
	}

	private static void loadJar(File wasRuntimeJar) throws MalformedURLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		URL url = wasRuntimeJar.toURI().toURL();
		URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
		Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
		method.setAccessible(true);
		method.invoke(classLoader, url);
	}
}
