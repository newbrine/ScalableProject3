package GUI;

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
	TextField addName;
	
	@FXML
	TextField addID;
	
	@FXML
	TextField addAvailableBloodOrOrgans;
	
	@FXML
	ComboBox<String> addBloodType;
	
	@FXML
	ComboBox<String> addPatientOrDonor;
	
	@FXML
	TextField searchName;
	
	@FXML
	TextField searchID;
	
	@FXML
	TextField searchAvailableBloodOrOrgans;
	
	@FXML
	ComboBox<String> searchBloodType;
	
	@FXML
	ComboBox<String> searchPatientOrDonor;
	
	@FXML
	TextField removeID;
	
	@FXML
	ComboBox<String> removePatientOrDonor;
	
	@FXML
	ListView searchResults;
	
	Patient patient;
	Donor donor;
	
	@FXML
	public void initialize() {
		patient = new Patient();
		donor = new Donor();
		bloodTypeSetup(addBloodType);
		bloodTypeSetup(searchBloodType);
		patientDonorSetup(addPatientOrDonor);
		patientDonorSetup(searchPatientOrDonor);
		patientDonorSetup(removePatientOrDonor);
	}
	
	@FXML
	public void addNewPatientOrDonor() {
		if (addPatientOrDonor.getValue() == "Patient") {
			patient.add(addName.getText(), addID.getText(), addBloodType.getValue(), addAvailableBloodOrOrgans.getText());
		} else {
			donor.add(addName.getText(), addID.getText(), addBloodType.getValue(), addAvailableBloodOrOrgans.getText());
		}
		addClearFields();
	}
	
	@FXML
	public void deletePatientOrDonor() {
		if (removePatientOrDonor.getValue() == "Patient") {
			patient.remove(removeID.getText());
		} else {
			donor.remove(removeID.getText());
		}
		removeClearFields();
	}
	
	@FXML
	public void searchPatientDonor() {
		searchClearFields();
	}
	
	public void addClearFields() {
		addName.clear();
		addID.clear();
		addAvailableBloodOrOrgans.clear();
	}
	
	public void removeClearFields() {
		removeID.clear();
	}
	
	public void searchClearFields() {
		searchName.clear();
		searchID.clear();
		searchAvailableBloodOrOrgans.clear();
	}
	
	public void bloodTypeSetup(ComboBox<String> bloodTypeBox) {
		bloodTypeBox.setItems(FXCollections.observableArrayList("AB+", "AB-", "A+", "A-", "B+", "B-", "O+", "O-"));
	}
	
	public void patientDonorSetup(ComboBox<String> patientOrDonorBox) {
		patientOrDonorBox.setItems(FXCollections.observableArrayList("Patient", "Donor"));
		patientOrDonorBox.setPromptText("Select Patient or Donor");
	}
}