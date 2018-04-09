package people;

import java.sql.ResultSet;
import java.sql.SQLException;

import sql.Database;

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
	public void search(String name, String id, String bloodType, String organ) throws SQLException {
		Database.readCommand("SELECT * FROM Patient WHERE Id = '" + id + "'" + "OR Name = '" + name +"' OR Bloodtype = '" + bloodType + "'OR Organ = '" + organ + "'" );
		ResultSet results = Database.getResults();
		while (results.next()) {
			String name1 = results.getString("name");
   	 	 	String type = results.getString("bloodtype");
   	 	 	//String organ1 = results.getString("organ");
   	 	 	
   	 	 	System.out.println(name1);
   	 	 	System.out.println(type);
   	 	 	//System.out.println(organ1);
        }
	}
}
