package next.xadmin.login.database;

import java.sql.*;

import next.xadmin.login.bean.LoginMessage;

public class LoginMessageDao {
	//pass in all the necceary pieces to connect to the databse
	private String dbUrl = "jdbc:postgresql://localhost:5432/myFirstDatabase";
	private String dbUname = "postgres";
	private String dbPassword =  "TrashCannot2004";
	private String dbDriver = "org.postgresql.Driver";
	//pass in the database driver
	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//getting connected to database 
	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(dbUrl,dbUname,dbPassword);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public String insert(LoginMessage loginMessage) {
		loadDriver(dbDriver);
		Connection con = getConnection();
		String result = "Message and username entered successfully";
		String postgresql = "insert into loginmessage (username, message) values(?,?);";
		//syntax for postgresql databse to insert into loginmessage datatable 
		try {
			PreparedStatement ps = con.prepareStatement(postgresql);
			//get the username and message and set the designated parameter
			ps.setString(1, loginMessage.getUsername());
			ps.setString(2, loginMessage.getMessage());
			ps.executeUpdate();
			//execute the postgresql syntax 
			//executes the postgresql syntax above
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "Data not entered";
		}
		
		return result;
	}
}
