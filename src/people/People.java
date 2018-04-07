package people;

import java.sql.SQLException;

public interface People {
	public void add(String name, String id, String bloodtype, String organ) throws SQLException;
	
	public void remove(String id);
}
