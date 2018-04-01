package sql;

import java.sql.*;

public class Database {
	private static Statement stat;
	private static Connection con;
	
	public Database() {}
	
    public static void createDB(String DBName) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:" + DBName);
        stat = con.createStatement();
    }
    
    public static void readCommand(String command) {
    	try {
			stat.execute(command);
		} catch (SQLException e) {
			System.out.println("Invalid argument");
		}
    }
    
    public static ResultSet getResults() throws SQLException {
    	return stat.getResultSet();
    }
    
    public PreparedStatement prepareStat(String command) throws SQLException {
    	return con.prepareStatement(command);
    }
}
