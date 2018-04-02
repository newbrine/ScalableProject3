package people;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import sql.Database;

public class Donor implements People {
	public Donor() {}
	
	@Override
	public void add(String name, String id, String bloodtype) {
		Database.readCommand("INSERT INTO Donor VALUES ('"+ name + "', '" + id + "', '" + bloodtype + "')");
	}

	@Override
	public void remove(String id) {
		Database database = new Database();
		try {
			PreparedStatement pstmt = database.prepareStat("DELETE FROM Donor WHERE Id = ?");
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
