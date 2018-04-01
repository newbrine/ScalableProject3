package people;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
import sql.Database;

public class DonorTest {
	@Test
	public void addTest() throws ClassNotFoundException, SQLException {
		Database.createDB("test");
		Database.readCommand("DROP TABLE Donor");
		Database.readCommand("CREATE TABLE Donor (Name TEXT, Id TEXT, Bloodtype TEXT)");
		Donor donor = new Donor();
		donor.add("ali", "001", "O");
		Database.readCommand("select * from Donor");
		ResultSet results = Database.getResults();
		String name1 = results.getString("Name");
		int id = results.getInt("Id");
		String type = results.getString("Bloodtype");
		assertTrue(name1.equals("ali"));
		assertTrue(id == 001);
		assertTrue(type.equals("O"));
	}
}
