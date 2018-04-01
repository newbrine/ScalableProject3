package people;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
import sql.Database;

public class PatientTest {
	@Test
	public void Test() throws ClassNotFoundException, SQLException {
		Database.createDB("test");
		Database.readCommand("DROP TABLE Patient");
		Database.readCommand("CREATE TABLE Patient (Name TEXT, Id INTEGER, Bloodtype TEXT)");
		Patient patient = new Patient();
		patient.add("ali", 001, "O");
		Database.readCommand("select * from Patient");
		ResultSet results = Database.getStat().getResultSet();
		String name1 = results.getString("Name");
		int id = results.getInt("Id");
		String type = results.getString("Bloodtype");
		assertTrue(name1.equals("ali"));
		assertTrue(id == 001);
		assertTrue(type.equals("O"));
	}
}
