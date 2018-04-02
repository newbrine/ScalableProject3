package GUI;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GUIPopups {

	public GUIPopups() {}
	
	public void AddPatientDonor() {
		popup();
	}
	
	public void DeletePatientDonor() {
		Stage popup = new Stage();
		popup.initModality(Modality.APPLICATION_MODAL);
		VBox layout = new VBox();
		
		HBox IDNumberHbox = createLabelRow("ID Number: ", "Enter Patient/Donor ID number");
		
		HBox buttonHbox = new HBox();
		Button deleteButton = createButton("Delete");
		deleteButton.setOnAction((event) -> {popup.close();});
		buttonHbox.getChildren().add(deleteButton);
		
		layout.getChildren().addAll(IDNumberHbox, buttonHbox);
		Scene popupscene = new Scene(layout, 350, 63);
		popup.setScene(popupscene);
		popup.show();
	}
	
	public void SearchPatientDonor() {
		popup();
	}
	
	public void MatchPatientDonor() {
		Stage popup = new Stage();
		popup.initModality(Modality.APPLICATION_MODAL);
		VBox layout = new VBox();
		
		HBox bloodHbox = createLabelRow("Blood Type: ", "Enter Patient/Donor blood type");
		
		HBox buttonHbox = new HBox();
		Button deleteButton = createButton("Match");
		deleteButton.setOnAction((event) -> {popup.close();});
		buttonHbox.getChildren().add(deleteButton);
		
		layout.getChildren().addAll(bloodHbox, buttonHbox);
		Scene popupscene = new Scene(layout, 350, 63);
		popup.setScene(popupscene);
		popup.show();
	}
	
	public void popup(){
		Stage popup = new Stage();
		popup.initModality(Modality.APPLICATION_MODAL);
		VBox layout = new VBox();
		
		HBox nameHbox = createLabelRow("Name: ", "Enter Patient/Donor name");
		HBox IDNumberHbox = createLabelRow("ID Number: ", "Enter Patient/Donor ID number");		
		HBox bloodHbox = createLabelRow("Blood Type: ", "Enter Patient/Donor blood type");
		HBox patientDonorHbox = createChoiceRow();
		
		HBox buttonHbox = new HBox();
		Button searchButton = createButton("Search");
		Button addButton = createButton("Add");
		addButton.setOnAction((event) -> {popup.close();});
		searchButton.setOnAction((event) -> {popup.close();});
		buttonHbox.getChildren().addAll(addButton, searchButton);
		
		layout.getChildren().addAll(nameHbox, IDNumberHbox, bloodHbox, patientDonorHbox, buttonHbox);
		Scene popupscene = new Scene(layout, 350, 155);
		popup.setScene(popupscene);
		popup.show();
	}
	
	public Button createButton(String labelName) {
		Button button = new Button();
		button.setText(labelName);
		return button;
	}
	
	public HBox createLabelRow(String labelName, String textFieldText) {
		HBox box = new HBox();
		Label label = new Label(labelName);
		TextField textField = new TextField();
		textField.setPrefWidth(250);
		textField.setPromptText(textFieldText);
		textField.setEditable(true);
		box.getChildren().addAll(label, textField);
		return box;
	}
	
	public HBox createChoiceRow() {
		HBox box = new HBox();
		ChoiceBox patientDonorSelect = new ChoiceBox(FXCollections.observableArrayList("Patient", "Donor"));
		box.getChildren().add(patientDonorSelect);
		return box;
	}
}