package people;

import sql.Database;

public class Donor implements People {
	public Donor() {}
	
	@Override
	public void add(String name, int id, String bloodtype) {
		Database.readCommand("INSERT INTO Donor VALUES ('"+ name + "', " + Integer.toString(id) + ", '" + bloodtype + "')");
	}

	@Override
	public void remove(int id) {
		Database.readCommand("DELETE Donor WHERE Id=" + id);
	}
}
