<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="crud.servlet.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="">

</form>

<% 			ArrayList<Emp> li = (ArrayList<Emp>) request.getAttribute("View");%>
		<% for(Emp e:li){
				
			
 %>
 <table border="3">
 <tr><td>  Id </td> <td> <%=e.getId() %> </td></tr>
 <tr><td>  Name</td> <td> <%=e.getName()%> </td></tr>
 <tr><td>  Email </td> <td> <%=e.getEmail() %> </td></tr>
 <tr><td>  Password </td> <td> <%=e.getPassword() %> </td></tr>
 </table>
 <br>
 <br>
 <br>
 <%} %>
</body>
</html>