package people;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
import sql.Database;

public class PatientTest {
	Patient patient = new Patient();
	
	@Test
	public void addTest() throws ClassNotFoundException, SQLException {
		Database.createDB("test");
		Database.readCommand("DROP TABLE IF EXISTS Patient");
		Database.readCommand("CREATE TABLE Patient (Name TEXT, Id TEXT, Bloodtype TEXT, Organ TEXT)");
		patient.add("ali", "001", "O+", "Heart");
		Database.readCommand("SELECT * FROM Patient");
		ResultSet results = Database.getResults();
		String name1 = results.getString("Name");
		String id = results.getString("Id");
		String type = results.getString("Bloodtype");
		String organ = results.getString("Organ");
		Database.closeResults(results);
		assertTrue(name1.equals("ali"));
		assertTrue(id.equals("001"));
		assertTrue(type.equals("O+"));
		assertTrue(organ.equals("Heart"));
	}
	
	@Test
	public void removeTest() throws ClassNotFoundException, SQLException {
		patient.remove("001");
		Database.readCommand("SELECT * FROM Patient");
		ResultSet result = Database.getAndCloseResults();
		assertFalse(result.next());
	}
}
