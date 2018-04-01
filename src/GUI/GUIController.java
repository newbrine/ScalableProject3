package GUI;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class GUIController {

	@FXML
	public void initialize() {
		
	}
	
	@FXML
	public void addNewPatientDonor() {
		GUIPopups popups = new GUIPopups();
		popups.AddPatientDonor();
	}
	
	@FXML
	public void deletePatientDonor() {
		GUIPopups popups = new GUIPopups();
		popups.DeletePatientDonor();
	}
	
	@FXML
	public void searchPatientDonor() {
		GUIPopups popups = new GUIPopups();
		popups.SearchPatientDonor();
	}
	
	@FXML
	public void matchPatientDonor() {
		GUIPopups popups = new GUIPopups();
		popups.MatchPatientDonor();
	}
}
