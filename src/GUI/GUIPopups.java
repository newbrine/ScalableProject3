package GUI;

import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GUIPopups {

	public GUIPopups() {
		
	}
	
	public void AddPatientDonor() {
		popup();
	}
	
	public void DeletePatientDonor() {
		Stage popup = new Stage();
		popup.initModality(Modality.APPLICATION_MODAL);
		VBox layout = new VBox();
		
		HBox IDNumberHbox = new HBox();
		Label IDNumberLabel = new Label("ID Number: ");
		TextField IDNumberField = new TextField();
		IDNumberField.setPrefWidth(250);
		IDNumberField.setPromptText("Enter Patient/Donor ID nubmer");
		IDNumberField.setEditable(true);
		IDNumberHbox.getChildren().addAll(IDNumberLabel, IDNumberField);
		
		HBox buttonHbox = new HBox();
		Button sendButton = new Button();
		sendButton.setText("Add");
		sendButton.setOnAction((event) -> {popup.close();});
		
		buttonHbox.getChildren().add(sendButton);
		
		layout.getChildren().addAll(IDNumberHbox, buttonHbox);
		Scene popupscene = new Scene(layout, 350, 63);
		popup.setScene(popupscene);
		popup.show();
	}
	
	public void SearchPatientDonor() {
		popup();
	}
	
	public void popup(){
		Stage popup = new Stage();
		popup.initModality(Modality.APPLICATION_MODAL);
		VBox layout = new VBox();
		
		HBox nameHbox = new HBox();
		Label nameLabel = new Label("Name: ");
		TextField nameField = new TextField();
		nameField.setPrefWidth(250);
		nameField.setPromptText("Enter Patient/Donor name");
		nameField.setEditable(true);
		nameHbox.getChildren().addAll(nameLabel, nameField);
		
		HBox IDNumberHbox = new HBox();
		Label IDNumberLabel = new Label("ID Number: ");
		TextField IDNumberField = new TextField();
		IDNumberField.setPrefWidth(250);
		IDNumberField.setPromptText("Enter Patient/Donor ID nubmer");
		IDNumberField.setEditable(true);
		IDNumberHbox.getChildren().addAll(IDNumberLabel, IDNumberField);
		
		HBox bloodHbox = new HBox();
		Label bloodLabel = new Label("Blood Type: ");
		TextField bloodField = new TextField();
		bloodField.setPrefWidth(250);
		bloodField.setPromptText("Enter Patient/Donor blood type");
		bloodField.setEditable(true);
		bloodHbox.getChildren().addAll(bloodLabel, bloodField);
		
		HBox buttonHbox = new HBox();
		Button searchButton = new Button();
		Button addButton = new Button();
		searchButton.setText("Search");
		addButton.setText("Add");
		addButton.setOnAction((event) -> {popup.close();});
		searchButton.setOnAction((event) -> {popup.close();});
		buttonHbox.getChildren().addAll(addButton, searchButton);
		
		layout.getChildren().addAll(nameHbox, IDNumberHbox, bloodHbox, buttonHbox);
		Scene popupscene = new Scene(layout, 350, 125);
		popup.setScene(popupscene);
		popup.show();
	}
}
