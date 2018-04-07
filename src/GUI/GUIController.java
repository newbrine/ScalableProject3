package GUI;

import java.util.ArrayList;

import people.Donor;
import people.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
	ChoiceBox bloodType;
	
	@FXML
	TextField removeID;
	
	Patient patient;
	Donor donor;
	@FXML
	public void initialize() {
		patient = new Patient();
		donor = new Donor();
		bloodType.setItems(FXCollections.observableArrayList("AB+", "AB-", "A+", "A-", "B+", "B-", "O+", "O-"));
	}
	
	@FXML
	public void addNewPatientOrDonor() {
		patient.add(name.getText(), id.getText(), bloodType.toString());
		clearTextFields();
	}
	
	@FXML
	public void deletePatientOrDonor() {
		patient.remove(removeID.getText());
		clearTextFields();
	}
	
	@FXML
	public void searchPatientDonor() {
		
	}
	
	@FXML
	public void matchPatientToDonor() {
		
	}
	
	public void clearTextFields() {
		name.clear();
		id.clear();
	}
}