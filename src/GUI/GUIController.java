package GUI;

import java.util.ArrayList;

import People.Donor;
import People.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
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
	ComboBox bloodType;
	
	@FXML
	ComboBox patientOrDonor;
	
	@FXML
	TextField availableBloodOrOrgans;
	
	@FXML
	TextField removeID;
	
	Patient patient;
	Donor donor;
	@FXML
	public void initialize() {
		patient = new Patient();
		donor = new Donor();
		bloodTypeSetup();
		patientDonorSetup();
	}
	
	@FXML
	public void addNewPatientOrDonor() {
		patient.add(name.getText(), id.getText(), bloodType.getValue(), availableBloodOrOrgans.getText());
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
	
	public void bloodTypeSetup() {
		bloodType.setItems(FXCollections.observableArrayList("AB+", "AB-", "A+", "A-", "B+", "B-", "O+", "O-"));
		bloodType.setPromptText("Select Blood Type");
	}
	
	public void patientDonorSetup() {
		patientOrDonor.setItems(FXCollections.observableArrayList("Patient", "Donor"));
		patientOrDonor.setPromptText("Select Patient or Donor");
	}
}