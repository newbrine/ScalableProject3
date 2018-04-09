package GUI;

import People.Donor;
import People.Patient;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class GUIController {
	
	@FXML
	TextField addName;
	
	@FXML
	TextField addID;
	
	@FXML
	ComboBox<String> addOrgans;
	
	@FXML
	ComboBox<String> addBloodType;
	
	@FXML
	ComboBox<String> addPatientOrDonor;
	
	@FXML
	TextField searchName;
	
	@FXML
	TextField searchID;
	
	@FXML
	ComboBox<String> searchOrgans;
	
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
	
	@FXML
	ImageView joshPic;
	
	Patient patient;
	Donor donor;
	ObservableList<String> results = FXCollections.observableArrayList();
	
	@FXML
	public void initialize() {
		patient = new Patient();
		donor = new Donor();
		bloodTypeSetup(addBloodType);
		bloodTypeSetup(searchBloodType);
		organSetup(addOrgans);
		organSetup(searchOrgans);
		patientDonorSetup(addPatientOrDonor);
		patientDonorSetup(searchPatientOrDonor);
		patientDonorSetup(removePatientOrDonor);
	}
	
	@FXML
	public void addNewPatientOrDonor() {
		if(checkErrors(addName, addID)) {
			System.out.println("There is an error in one of the fields, please try again.");
		} else {
			if (addPatientOrDonor.getValue().equals("Patient")) {
				patient.add(addName.getText(), addID.getText(), addBloodType.getValue(), addOrgans.getValue());
			} else {
				donor.add(addName.getText(), addID.getText(), addBloodType.getValue(), addOrgans.getValue());
			}
		}
		clearFields(addName, addID, addOrgans, addBloodType, addPatientOrDonor);
	}
	
	@FXML
	public void deletePatientOrDonor() {
		if(!checkID(removeID.getText())) {System.out.println("The id number is invalid, please try again.");}
		else {
			if (removePatientOrDonor.getValue().equals("Patient")) {
				patient.remove(removeID.getText());
			} else {
				donor.remove(removeID.getText());
			}
		}
		clearFields(null, removeID, null, null, removePatientOrDonor);
	}
	
	@FXML
	public void searchPatientDonor() {
		if(checkErrors(addName, addID)) {
			System.out.println("There is an error in one of the fields, please try again.");
		} else {
			results.clear();
			if (searchPatientOrDonor.getValue().equals("Patient")) {
				try {
					results.addAll(patient.search(searchName.getText(), searchID.getText(), searchBloodType.getValue(), searchOrgans.getValue()));
					updateListView();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				try {
					results.addAll(donor.search(searchName.getText(), searchID.getText(), searchBloodType.getValue(), searchOrgans.getValue()));
					updateListView();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		clearFields(searchName, searchID, searchOrgans, searchBloodType, searchPatientOrDonor);
	}
	
	public void clearFields(TextField name, TextField id, ComboBox<String> available, ComboBox<String> bloodType, ComboBox<String> patientDonor) {
		if(name != null) {name.clear();}
		if(id != null) {id.clear();}
		if(available != null) {available.valueProperty().set(null);;}
		if(bloodType != null) {bloodType.valueProperty().set(null);}
		if(patientDonor != null) {patientDonor.valueProperty().set(null);}
	}
	
	public void bloodTypeSetup(ComboBox<String> bloodTypeBox) {
		bloodTypeBox.setItems(FXCollections.observableArrayList("AB+", "AB-", "A+", "A-", "B+", "B-", "O+", "O-"));
	}
	
	public void organSetup(ComboBox<String> organBox) {
		organBox.setItems(FXCollections.observableArrayList("Heart", "Kidney", "Liver", "Lung", "Pancreas", "Bone Marrow", "Tendon", "Skin", "Heart Valve", "Blood"));
	}
	
	public void patientDonorSetup(ComboBox<String> patientOrDonorBox) {
		patientOrDonorBox.setItems(FXCollections.observableArrayList("Patient", "Donor"));
	}
	
	public void updateListView() {
		searchResults.setItems(results);
	}
	
	public Boolean checkErrors(TextField name, TextField id) {
		if(!checkName(name.getText())) {return true;}
		if(!checkID(id.getText())) {return true;}
		return false;
	}
	
	//https://stackoverflow.com/questions/5238491/check-if-string-contains-only-letters
	public Boolean checkName(String name) {
		return name.matches("[a-zA-Z]+");
	}
	
	public Boolean checkID(String id) {
		return id.matches("[0-9]+");
	}
	
	@FXML
	public void showJosh() {
		joshPic.setVisible(true);
	}
}