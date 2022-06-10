package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage ventana) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,500,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			ventana.setScene(scene);
			ventana.setTitle("Memory match");
			ventana.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		Juego Obj = new Juego();
	}
}
