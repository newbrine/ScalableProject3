package bloodDonor;
import java.sql.*;
import java.util.Scanner;

public class Database {
	
	
	
	public Database() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection("jdbc:sqlite:blooddonor.db");
        Statement stat = con.createStatement();
	}
	
    
	public void exec(String name) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:sqlite:blooddonor.db");
        Statement stat = con.createStatement();
		stat.execute(name);
		 ResultSet results = stat.getResultSet();
         while (results.next()) {
            
        	 	 String name1 = results.getString("name");
        	 	 String type = results.getString("bloodtype");
             System.out.println(name1);
             System.out.println(type);
             }
             System.out.println();
         con.close();
         

	
	}  

	public void create(String name) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:sqlite:blooddonor.db");
        Statement stat = con.createStatement();
		stat.execute("create table if not exists " + name + " ( name varchar(50), bloodtype varchar(25))");
		con.close();
	}
	
	public void insert(String name, String type, String tablename) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:sqlite:blooddonor.db");
        Statement stat = con.createStatement();
		stat.execute("insert into " + tablename + " values " + "(\'" + name + "\', \'" + type + "\')"  );
		
	}
	
	public void remove(String name, String tablename) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:sqlite:blooddonor.db");
        Statement stat = con.createStatement();
        //System.out.println("DELETE FROM " +  tablename +  " WHERE name = " + name  );
        //stat.execute("DELETE FROM " +  tablename +  " WHERE name = " + name  );
        stat.execute("DELETE FROM " +  "\'" + tablename + "\'" + " WHERE name = " +  "\'" + name + "\'");
        
        }
	
	public void drop(String tablename) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:sqlite:blooddonor.db");
        Statement stat = con.createStatement();
        stat.execute("DROP FROM TABLE" +  "\'" + tablename);
        }
	
	public void match(String typeD, String typeP) {
		
	}
	


}
