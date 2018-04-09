package People;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import SQL.Database;

public class Donor implements People {
	public Donor() {}
	
	@Override
	public void add(String name, String id, String bloodtype, String organ) {
		Database.readCommand("SELECT * FROM Donor WHERE Id = '" + id + "'");
		try {
			ResultSet results = Database.getAndCloseResults();
			if (!results.next()) {
				Database.readCommand("INSERT INTO Donor VALUES ('" + name + "', '" + id + "', '" + bloodtype + "', '" + organ + "')");
			} else {
				System.out.println("There is another donor with this ID number.");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void remove(String id) {
		Database.readCommand("SELECT * FROM Donor WHERE Id = '" + id + "'");
		try {
			ResultSet results = Database.getResults();
			if (results.next()) {
				Database.readCommand("DELETE FROM Donor WHERE Id = '" + id + "'");
			} else {
				System.out.println("There is no donor with this ID number.");
			}
			Database.closeResults(results);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public ArrayList<String> search(String name, String id, String bloodType, String organ) throws SQLException {
		Database.readCommand("SELECT * FROM Donor WHERE Id = '" + id + "'" + "OR Name = '" + name +"' OR Bloodtype = '" + bloodType + "'OR Organ = '" + organ + "'" );
		ResultSet results = Database.getResults();
		while (results.next()) {
			String name1 = results.getString("name");
   	 	 	String type = results.getString("bloodtype");
   	 	 	//String organ1 = results.getString("organ");
   	 	 	
   	 	 	System.out.println(name1);
   	 	 	System.out.println(type);
   	 	 	//System.out.println(organ1);
        }
		return new ArrayList<String>();
		}
}