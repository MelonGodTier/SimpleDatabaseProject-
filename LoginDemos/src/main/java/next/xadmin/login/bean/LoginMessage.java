package next.xadmin.login.bean;

public class LoginMessage {
 public LoginMessage(String username, String message) {
		super();
		this.username = username;
		this.message = message;
	}
public LoginMessage() {
	super();
}
private String username; 
 private String message;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
}
