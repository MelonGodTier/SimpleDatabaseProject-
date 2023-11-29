package next.xadmin.login.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import next.xadmin.login.bean.LoginBean;
import next.xadmin.login.bean.LoginMessage;
import next.xadmin.login.database.LoginDao;
import next.xadmin.login.database.LoginMessageDao;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String message = request.getParameter("message");
		//RETURN THE PARAMETER AS STRING
		LoginBean loginBean = new LoginBean();
		//INSTANTIATE LOGINBEAN CLASS
		LoginMessage loginMessage = new LoginMessage();
		//instansiate LoginMessage
		loginMessage.setUsername(username);
		loginMessage.setMessage(message);
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		//set the follwing strings
		LoginDao loginDao = new LoginDao();
		//instansiate LoginDao
		LoginMessageDao loginmessageDao = new LoginMessageDao();
		//validate user login
		if(loginDao.validate(loginBean)) {
			HttpSession session = request.getSession(); 
			UUID uuid = UUID.randomUUID();
			String sessionKey = uuid.toString();
		     session.setAttribute("sessionKey", sessionKey);
		     //HashSet<String> keyStorage = SessionHashSet.getsessionStorage();
		  //   keyStorage.add(sessionKey);
		     System.out.println(sessionKey);
		     session.setMaxInactiveInterval(30*60);
		    // Cookie userName = new Cookie("sessionKey",sessionKey);
		     //userName.setMaxAge(30*60);
			response.sendRedirect("Message.jsp");
		}else {
			//login credientals wrong, redirected back to login page
			response.sendRedirect("login.jsp");
		}
	}

}
