\package people;

import java.sql.SQLException;

import sql.Database;

public class Donor implements People {
	public Donor() {}
	
	@Override
	public void add(String name, String id, String bloodtype) {
		Database.readCommand("INSERT INTO Donor VALUES ('"+ name + "', '" + id + "', '" + bloodtype + "')");
		try {
			Database.printAll("Donor");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(String id) {
		Database.readCommand("DELETE FROM Donor WHERE Id = '" + id + "'");
		try {
			Database.printAll("Donor");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
