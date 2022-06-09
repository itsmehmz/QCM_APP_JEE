<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Votre score</title>
</head>
<body>
<% 
    String  reponse = (String)request.getAttribute("reponse_string");

  %>
  
 <%= reponse %>
</body>
</html>