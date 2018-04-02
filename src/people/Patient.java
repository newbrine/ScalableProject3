package people;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import sql.Database;

public class Patient implements People {
	public Patient() {}
	
	@Override
	public void add(String name, String id, String bloodtype) {
		Database.readCommand("INSERT INTO Patient VALUES ('" + name + "', '" + id + "', '" + bloodtype + "')");
	}

	@Override
	public void remove(String id) {
		Database database = new Database();
		try {
			PreparedStatement pstmt = database.prepareStat("DELETE FROM Patient WHERE Id = ?");
			pstmt.setString(1, id);
			pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	
	public boolean isMatch(String bloodtype1, String bloodtype2) {
		return bloodtype1.equals(bloodtype2);
	}
}
