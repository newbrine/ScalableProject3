package People;

import java.sql.SQLException;
import java.util.ArrayList;

public interface People {
	public void add(String name, String id, String bloodtype, String organ) throws SQLException;
	
	public void remove(String id);
	
	public ArrayList<String> search(String name, String id, String bloodType, String organ) throws SQLException;
}