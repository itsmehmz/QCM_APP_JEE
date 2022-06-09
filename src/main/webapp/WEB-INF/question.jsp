<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question</title>
</head>
<body>
<% 
    String  question = (String)request.getAttribute("question_string");
String spageid=request.getParameter("page");

  %>
  
 <%= question %>
  
</body>
</html>