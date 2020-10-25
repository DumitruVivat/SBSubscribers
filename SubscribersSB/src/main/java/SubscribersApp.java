
import java.io.IOException;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SubscribersApp extends Application {
	public static Stage lnkStage;
	
    @Override
    public void start(Stage stage) throws IOException {
    	lnkStage = stage;
    	// 1) Template/View
    	// 2) Controller
    	
    	Parent root = FXMLLoader.load( getClass().getResource("Subscribers.fxml") );
        
        Scene scene = new Scene(root);   
   
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        launch();
    }

}
