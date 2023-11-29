<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv = "Content Type" content = "text/html; charset= UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String id = (String)request.getSession().getAttribute("sessionKey");
if(id == null){
	response.sendRedirect("login.jsp");
}
	
	
%>
<div align = "center">
<h1>User Text Form</h1>
<form action = "Message" method ="post">   
<table>
  <tr><td>User Name: </td><td><input type ="text" name ="username" ></td></tr> 
 <tr><td>Message: </td><td><input type ="password" name ="message" ></td></tr> 
 <button type="submit">Send Message</button>
</table>
</form>
</div>
</body>
</html>