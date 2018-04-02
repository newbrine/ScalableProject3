package people;

import sql.Database;

public class Patient implements People {
	public Patient() {}
	
	@Override
	public void add(String name, String id, String bloodtype) {
		Database.readCommand("INSERT INTO Patient VALUES ('" + name + "', '" + id + "', '" + bloodtype + "')");
	}

	@Override
	public void remove(String id) {
		Database.readCommand("DELETE FROM Patient WHERE Id = '" + id + "'");
	}
	
	public boolean isMatch(String bloodtype1, String bloodtype2) {
		return bloodtype1.equals(bloodtype2);
	}
}
