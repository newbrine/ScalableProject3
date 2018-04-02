package GUI;

import java.util.ArrayList;

import people.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class GUIController {
	
	@FXML
	TextField name;
	
	@FXML
	TextField id;
	
	@FXML
	TextField bloodType;

	@FXML
	public void initialize() {}
	
	@FXML
	public void addNewPatient() {
		Patient patient = new Patient();
		patient.add(name.getText(), id.getText(), bloodType.getText());
		name.clear();
		id.clear();
		bloodType.clear();
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
