package People;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import SQL.Database;

public class Patient implements People {
	public Patient() {}
	
	@Override
	public void add(String name, String id, String bloodtype, String organ) {
		Database.readCommand("SELECT * FROM Patient WHERE Id = '" + id + "'");
		try {
			ResultSet results = Database.getAndCloseResults();
			if (!results.next()) {
				Database.readCommand("INSERT INTO Patient VALUES ('" + name + "', '" + id + "', '" + bloodtype + "', '" + organ + "')");
			} else {
				System.out.println("There is another patient with this ID number.");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void remove(String id) {
		Database.readCommand("SELECT * FROM Patient WHERE Id = '" + id + "'");
		try {
			ResultSet results = Database.getResults();
			if (results.next()) {
				Database.readCommand("DELETE FROM Patient WHERE Id = '" + id + "'");
			} else {
				System.out.println("There is no patient with this ID number.");
			}
			Database.closeResults(results);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<String> search(String name, String id, String bloodType, String organ) throws SQLException {		
		ArrayList<String> outputResult = new ArrayList<String>();
		String command = "SELECT * FROM Patient WHERE";
		if (!name.equals("")) {
			command = command + " NAME = '" + name + "' AND";
		}
		if (!id.equals("")) {
			command = command + " Id = '" + id + "' AND";
		}
		if (bloodType != null) {
			command = command + " Bloodtype = '" + bloodType + "' AND";
		}
		if (organ != null) {
			command = command + " Organ = '" + organ + "'";
		}
		if (command.substring(command.length() - 6).equals(" WHERE")) {
			command = command.substring(0, command.length() - 6);
		}
		if (command.substring(command.length() - 4).equals(" AND")) {
			command = command.substring(0, command.length() - 4);
		}
		Database.readCommand(command);
		ResultSet results = Database.getResults();
		outputResult.add(formatString("Name", "ID", "BloodType", "Organ"));
		while (results.next()) {
			outputResult.add(formatString(results.getString("Name"), results.getString("Id"), results.getString("Bloodtype"), results.getString("Organ")));
		}
		Database.closeResults(results);
		return outputResult;
	}

	public String formatString(String name, String id, String bloodType, String organ) throws SQLException {
		String formatted = name + "  -  " + id + "  -  " + bloodType + "  -  " + organ;
		return formatted;
	}	
}
