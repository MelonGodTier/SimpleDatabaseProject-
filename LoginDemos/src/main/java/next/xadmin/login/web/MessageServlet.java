package next.xadmin.login.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import next.xadmin.login.bean.LoginBean;
import next.xadmin.login.bean.LoginMessage;
import next.xadmin.login.database.LoginDao;
import next.xadmin.login.database.LoginMessageDao;
import next.xadmin.login.web.*;
import java.io.IOException;

import org.apache.tomcat.util.http.parser.Cookie;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Message")
//use annotation to define a Servlet
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MessageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// String username = (String) request.getAttribute("username");
		String username = request.getParameter("username"); 
		//getting the value of the username 
		String message = request.getParameter("message");  
		// gettting the value of the parameter
		if(session.getAttribute("sessionKey") == null) {
			response.sendRedirect("login.jsp");
			return;
		} 
		String id = session.getAttribute("sessionKey").toString();
		LoginMessage loginMessage = new LoginMessage(username, message);
		LoginMessageDao lmd = new LoginMessageDao();
		jakarta.servlet.http.Cookie[] cookies = request.getCookies();
		//instansiate LoginMessageDao (process the username and message and saves it to the database)
		String result = lmd.insert(loginMessage);
		response.sendRedirect("Success.jsp");
	}
}

