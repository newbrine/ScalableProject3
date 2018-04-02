||package people;

import java.sql.SQLException;

import sql.Database;

public class Patient implements People {
	public Patient() {}
	
	@Override
	public void add(String name, String id, String bloodtype) {
		Database.readCommand("INSERT INTO Patient VALUES ('" + name + "', '" + id + "', '" + bloodtype + "')");
		try {
			Database.printAll("Patient");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(String id) {
		Database.readCommand("DELETE FROM Patient WHERE Id = \' " + id + " '");
		try {
			Database.printAll("Patient");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isMatch(String bloodtype1, String bloodtype2) {
		return bloodtype1.equals(bloodtype2);
	}
}
