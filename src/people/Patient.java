package people;

import sql.Database;

public class Patient implements People {
	@Override
	public void add(String name, int id, String bloodtype) {
		Database.readCommand("INSERT INTO Patient VALUES ('" + name + "', " + Integer.toString(id) + ", '" + bloodtype + "')");
	}

	@Override
	public void remove(int id) {
		Database.readCommand("DELETE Patient WHERE Id=" + id);
	}
	
	public boolean isMatch(String bloodtype1, String bloodtype2) {
		return bloodtype1.equals(bloodtype2);
	}
}
