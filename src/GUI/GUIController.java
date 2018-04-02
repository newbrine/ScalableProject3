package GUI;

import java.sql.SQLException;
import java.util.ArrayList;

import people.Donor;
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
	
	Patient patient;
	Donor donor;
	@FXML
	public void initialize() {
		patient = new Patient();
		donor = new Donor();
	}
	
	@FXML
	public void addNewPatient() {
		patient.add(name.getText(), id.getText(), bloodType.getText());
		clearTextFields();
	}
	
	public void addNewDonor() {
		donor.add(name.getText(), id.getText(), bloodType.getText());
		clearTextFields();
	}
	
	@FXML
	public void deletePatient() {
		patient.remove(id.getText());
		clearTextFields();
	}
	
	@FXML
	public void deleteDonor() {
		donor.remove(id.getText());
		clearTextFields();
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
	
	public void clearTextFields() {
		name.clear();
		id.clear();
		bloodType.clear();
	}
}
