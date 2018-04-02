package people;

import sql.Database;

public class Donor implements People {
	public Donor() {}
	
	@Override
	public void add(String name, String id, String bloodtype) {
		Database.readCommand("INSERT INTO Donor VALUES ('"+ name + "', '" + id + "', '" + bloodtype + "')");
	}

	@Override
	public void remove(String id) {
		Database.readCommand("DELETE FROM Donor WHERE Id = '" + id + "'");
	}
}
