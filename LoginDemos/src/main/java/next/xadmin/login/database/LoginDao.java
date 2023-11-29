package next.xadmin.login.database;


import java.sql.*;
import org.postgresql.Driver.*;
import next.xadmin.login.bean.LoginBean;
import next.xadmin.login.bean.LoginMessage;

public class LoginDao {
	private String dbUrl = "jdbc:postgresql://localhost:5432/myFirstDatabase";
	private String dbUname = "postgres";
	private String dbPassword =  "TrashCannot2004";
	private String dbDriver = "org.postgresql.Driver";
	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(dbUrl,dbUname,dbPassword);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	public boolean validate(LoginBean loginbean) {
		loadDriver(dbDriver);
		Connection connection = getConnection();
		boolean status = false;
		String sql = "SELECT * FROM public.login where (username = ? and password = ?);";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, loginbean.getUsername());
			ps.setString(2, loginbean.getPassword());
			ResultSet rs = ps.executeQuery();
			status = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;

	}
	public boolean validate(LoginMessage loginMessage) {
		loadDriver(dbDriver);
		//passes in the databse driver
		Connection connection = getConnection();
		//call the getconnection method 
		boolean status = false;
		//postgtresql syntax 
		String sql = "SELECT * FROM public.login where (username = ? and password = ?);";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, loginMessage.getUsername());
			ps.setString(2, loginMessage.getMessage());
			ResultSet rs = ps.executeQuery();
			status = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;

	}
	/*
	public String insert(LoginMessage loginMessage) {
		loadDriver(dbDriver);
		Connection con = getConnection();
		String result = "Data entered succsesfully";
		String postgresql = "insert into loginmessage (username, message) values(?,?);";
		try {
			PreparedStatement ps = con.prepareStatement(postgresql);
			ps.setString(1, loginMessage.getUsername());
			ps.setString(2, loginMessage.getMessage());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "Data did not go through";
		}
		
		return result;
	}
	*/
	
	
}
