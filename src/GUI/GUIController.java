package GUI;

import People.Donor;
import People.Patient;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class GUIController {
	
	@FXML
	TextField addName;
	
	@FXML
	TextField addID;
	
	@FXML
	TextField addOrgans;
	
	@FXML
	ComboBox<String> addBloodType;
	
	@FXML
	ComboBox<String> addPatientOrDonor;
	
	@FXML
	TextField searchName;
	
	@FXML
	TextField searchID;
	
	@FXML
	TextField searchOrgans;
	
	@FXML
	ComboBox<String> searchBloodType;
	
	@FXML
	ComboBox<String> searchPatientOrDonor;
	
	@FXML
	TextField removeID;
	
	@FXML
	ComboBox<String> removePatientOrDonor;
	
	@FXML
	ListView<String> searchResults;
	
	Patient patient;
	Donor donor;
	ObservableList<String> results = FXCollections.observableArrayList();
	
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
		if (addPatientOrDonor.getValue().equals("Patient")) {
			patient.add(addName.getText(), addID.getText(), addBloodType.getValue(), addOrgans.getText());
		} else {
			donor.add(addName.getText(), addID.getText(), addBloodType.getValue(), addOrgans.getText());
		}
		clearFields(addName, addID, addOrgans, addBloodType, addPatientOrDonor);
	}
	
	@FXML
	public void deletePatientOrDonor() {
		if (removePatientOrDonor.getValue().equals("Patient")) {
			patient.remove(removeID.getText());
		} else {
			donor.remove(removeID.getText());
		}
		clearFields(null, removeID, null, null, removePatientOrDonor);
	}
	
	@FXML
	public void searchPatientDonor() {
		if (searchPatientOrDonor.getValue().equals("Patient")) {
			try {
				results.addAll(patient.search(searchName.getText(), searchID.getText(), searchBloodType.getValue(), searchOrgans.getText()));
				updateListView();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
		else {
			try {
				donor.search(searchName.getText(), searchID.getText(), searchBloodType.getValue(), searchOrgans.getText());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		clearFields(searchName, searchID, searchOrgans, searchBloodType, searchPatientOrDonor);
	}
	
	public void clearFields(TextField name, TextField id, TextField available, ComboBox<String> bloodType, ComboBox<String> patientDonor) {
		if(name != null) {name.clear();}
		if(id != null) {id.clear();}
		if(available != null) {available.clear();}
		if(bloodType != null) {bloodType.valueProperty().set(null);}
		if(patientDonor != null) {patientDonor.valueProperty().set(null);}
	}
	
	public void bloodTypeSetup(ComboBox<String> bloodTypeBox) {
		bloodTypeBox.setItems(FXCollections.observableArrayList("AB+", "AB-", "A+", "A-", "B+", "B-", "O+", "O-"));
	}
	
	public void patientDonorSetup(ComboBox<String> patientOrDonorBox) {
		patientOrDonorBox.setItems(FXCollections.observableArrayList("Patient", "Donor"));
		patientOrDonorBox.setPromptText("Select Patient or Donor");
	}
	
	public void updateListView() {
		searchResults.setItems(results);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}