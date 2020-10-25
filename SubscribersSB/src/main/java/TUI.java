
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import domain.Human;
import domain.HumanRepository;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

//Text User Interface
public class TUI implements Initializable {
	
	private static HumanRepository hr;
	@FXML
	private TextField inputName;
	@FXML
	private TextField inputEmail;
	@FXML
	private ListView<Human> printHuman = new ListView<>();
	@FXML
	private Button addEmail;
	@FXML
	private Button editEmail;
	@FXML
	private Button deleteEmail;
	
	public void editHumanData() throws SQLException {
		Human h = null;
		hr = new HumanRepository();
		String name = String.valueOf(inputName.getText());
		String email = String.valueOf(inputEmail.getText());
		h = new Human(name,email);
		hr.update(h);
		inputName.clear();
		inputEmail.clear();
		showHumanData();
	}
	public void readHumanData() throws SQLException {
		Human h = null;
		hr = new HumanRepository();
		String name = String.valueOf(inputName.getText());
		String email = String.valueOf(inputEmail.getText());
		h = new Human(name,email);
		hr.create(h);
		inputName.clear();
		inputEmail.clear();
		showHumanData();
	}
	public void deleteHuman() throws SQLException {
		hr = new HumanRepository();
		String email = String.valueOf(inputEmail.getText());
		hr.delete(email);
		inputEmail.clear();
		inputName.clear();
		showHumanData();
	}
	
	public void showHumanData() {
		ArrayList<Human> people = new ArrayList<Human>();
		try {
			hr = new HumanRepository();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			people = hr.all();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    for (Human human : people) {
			printHuman.getItems().add(human);
		}
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources){
		showHumanData();
	}
	public void showAbout() throws IOException {
        Parent root = FXMLLoader.load( getClass().getResource("About.fxml") );
        Scene scene = new Scene(root);
        SubscribersApp.lnkStage.setScene(scene);
	}
	public void backToMain() throws IOException {
        Parent root = FXMLLoader.load( getClass().getResource("Subscribers.fxml") );
        Scene scene = new Scene(root);
        SubscribersApp.lnkStage.setScene(scene);
	}
}
