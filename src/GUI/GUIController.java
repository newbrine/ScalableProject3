package GUI;

import people.Donor;
import people.Patient;
<<<<<<< HEAD
import sql.Database;

import java.util.ArrayList;
=======

import java.sql.SQLException;
>>>>>>> master

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
		clearFields(addName, addID, addAvailableBloodOrOrgans, addBloodType, addPatientOrDonor);
	}
	
	@FXML
	public void deletePatientOrDonor() {
		if (removePatientOrDonor.getValue() == "Patient") {
			patient.remove(removeID.getText());
		} else {
			donor.remove(removeID.getText());
		}
		clearRemoveFields();
	}
	
	@FXML
	public void searchPatientDonor() {
<<<<<<< HEAD
		ArrayList<String> criteria = searchCriteria();
		if (searchPatientOrDonor.getValue().equals("Patient")) {
			String command = "SELECT * FROM Patient WHERE " + criteria.get(0);
			for (int i = 1; i < criteria.size(); i++) {
				command = command + criteria.get(i);
			}
			Database.readCommand(command);
		}
		else {
			String command = "SELECT * FROM Donor WHERE " + criteria.get(0);
			for (int i = 1; i < criteria.size(); i++) {
				command = command + criteria.get(i);
			}
			Database.readCommand(command);
		}
		clearFields(searchName, searchID, searchAvailableBloodOrOrgans, searchBloodType, searchPatientOrDonor);
=======
		if (searchPatientOrDonor.getValue() == "Patient") {
			try {
				patient.search(searchName.getText(), searchID.getText(), searchBloodType.getValue(), searchOrgans.getText());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		else {
			try {
				donor.search(searchName.getText(), searchID.getText(), searchBloodType.getValue(), searchOrgans.getText());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		clearFields(searchName, searchID, searchOrgans, searchBloodType, searchPatientOrDonor);
		
		
>>>>>>> master
	}
	
	public void clearFields(TextField name, TextField id, TextField available, ComboBox<String> bloodType, ComboBox<String> patientDonor) {
		name.clear();
		id.clear();
		available.clear();
		bloodType.valueProperty().set(null);
		patientDonor.valueProperty().set(null);
	}
	
	public void clearRemoveFields() {
		removeID.clear();
		removePatientOrDonor.valueProperty().set(null);
	}
	
	public void bloodTypeSetup(ComboBox<String> bloodTypeBox) {
		bloodTypeBox.setItems(FXCollections.observableArrayList("AB+", "AB-", "A+", "A-", "B+", "B-", "O+", "O-"));
	}
	
	public void patientDonorSetup(ComboBox<String> patientOrDonorBox) {
		patientOrDonorBox.setItems(FXCollections.observableArrayList("Patient", "Donor"));
		patientOrDonorBox.setPromptText("Select Patient or Donor");
	}
	
<<<<<<< HEAD
	public ArrayList<String> searchCriteria() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Name = ");
		list.add("Id = ");
		list.add("Bloodtype = ");
		list.add("Organ = ");
		list = searchCriteriaHelperField(list, searchName, "Name");
		list = searchCriteriaHelperField(list, searchID, "Id");
		list = searchCriteriaHelperField(list, searchAvailableBloodOrOrgans, "Organ");
		list = searchCriteriaHelperChoiceBox(list, searchBloodType, "Bloodtype");
		return list;
	}
	
	public ArrayList<String> searchCriteriaHelperField(ArrayList<String> list, TextField field, String criteria) {
		if (field.getText() != "") {
			int i = list.indexOf(criteria + " = ");
			list.add(i, criteria + " = " + field.getText());
		}
		else {
			list.remove(criteria + " = ");
		}
		return list;
	}
	
	public ArrayList<String> searchCriteriaHelperChoiceBox(ArrayList<String> list, ComboBox<String> box, String criteria) {
		if (box.getValue() != null) {
			int i = list.indexOf(criteria + " = ");
			list.add(i, criteria + " = " + box.getValue());
		}
		else {
			list.remove(criteria + " = ");
		}
		return list;
	}
=======
>>>>>>> master
}