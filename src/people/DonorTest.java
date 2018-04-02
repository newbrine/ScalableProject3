package people;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
import sql.Database;

public class DonorTest {
	Donor donor = new Donor();
	
	@Test
	public void addTest() throws ClassNotFoundException, SQLException {
		Database.createDB("test");
		Database.readCommand("DROP TABLE IF EXISTS Donor");
		Database.readCommand("CREATE TABLE Donor (Name TEXT, Id TEXT, Bloodtype TEXT)");
		donor.add("ali", "001", "O");
		Database.readCommand("SELECT * FROM Donor");
		ResultSet results = Database.getResults();
		String name1 = results.getString("Name");
		String id = results.getString("Id");
		String type = results.getString("Bloodtype");
		Database.closeResults(results);
		assertTrue(name1.equals("ali"));
		assertTrue(id.equals("001"));
		assertTrue(type.equals("O"));
	}
	
	@Test
	public void removeTest() throws ClassNotFoundException, SQLException {
		donor.remove("'001'");
		Database.readCommand("SELECT * FROM Donor");
		ResultSet results = Database.getAndCloseResults();
		assertFalse(results.next());
	}
}
