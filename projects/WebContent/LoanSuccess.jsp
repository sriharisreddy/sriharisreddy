<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
out.println("loan is successful");
%>
<br>
<% 
int pamt=(int)session.getAttribute("pamt");
out.println("your principle amount is:");
out.println(pamt);
%>
<br>
<% 
int time=(int)session.getAttribute("time");
out.println("your time duration is:");
out.println(time);
%>
<br>
<% 
double rate=(double)session.getAttribute("rate");
out.println("your rate of interest is:");
out.println(rate);
%>
<br>
<% 
double SI=(double)session.getAttribute("SI");
out.println("your simple interest is:");
out.println(SI);
%>
</body>
</html>