<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
<%
int aVar = 6;
String attr = (String) request.getAttribute("param");
%>
<div><%=aVar %></div>

<p>
We have retrieved attribute: <b><%=attr %></b>
</p>
 --%>

<p>
And again:
We have retrieved attribute: <b>${object }</b>
</p>
<p>
User name is: ${pe.name }
<br>User age is : ${pe.age }
</p>
</body>
</html>