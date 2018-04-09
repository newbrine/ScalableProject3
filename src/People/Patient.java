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
		Database.readCommand("SELECT * FROM Patient WHERE Id = '" + id + "' OR Name = '" + name +"' OR Bloodtype = '" + bloodType + "' OR Organ = '" + organ + "'" );
		ResultSet results = Database.getResults();
		outputResult.add(formatString("Name", "ID", "BloodType", "Organ"));
		while (results.next()) {
			outputResult.add(formatString(results.getString("Name"), results.getString("Id"), results.getString("Bloodtype"), results.getString("Organ")));
			outputResult.add("dont see me");
		}
		System.out.println(outputResult);
		Database.closeResults(results);
		return outputResult;
	}
	
	public int longestValue(String searchValue) {
		try {
			Database.readCommand("SELECT " + searchValue + " FROM Patient");
			ResultSet nameList = Database.getResults();
			int temp = 0;
			while(nameList.next()) {
				if(nameList.getString(searchValue).length() > temp) {
					temp = nameList.getString(searchValue).length();
				}
			}
			Database.closeResults(nameList);
			return temp;
		} catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	int longestName = longestValue("Name");
	int longestID = longestValue("Id");
	int longestOrgan = longestValue("Organ");
	int longestBloodType = 9;
	
	public String formatString(String name, String id, String bloodType, String organ) throws SQLException {
		String formatted = "";
		
		formatted = formatted + name;
		while(formatted.length() <= longestName + 1) {
			formatted = formatted + " ";
		}
		
		formatted = formatted + id;
		while(formatted.length() <= longestName + longestID + 2) {
			formatted = formatted + " ";
		}
		
		formatted = formatted + bloodType;
		while(formatted.length() <= longestName + longestID + longestBloodType + 3) {
			formatted = formatted + " ";
		}
		
		formatted = formatted + organ;
		while(formatted.length() <= longestName + longestID + longestBloodType + longestOrgan + 4) {
			formatted = formatted + " ";
		}
		return formatted;
	}
}