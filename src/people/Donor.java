package people;

import sql.Build;

public class Donor implements People {
	@Override
	public void add(String name, int id, String bloodtype) {
		Build.readCommand("INSERT INTO Donor VALUES (" + name + ", " + Integer.toString(id) + ", " + bloodtype + ")");
	}

	@Override
	public void remove(int id) {
		Build.readCommand("DELETE Donor WHERE Id=" + id);
	}
}
