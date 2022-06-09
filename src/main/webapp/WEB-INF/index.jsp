<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulaire</title>
</head>

<body>
  <% 
    String  formulaire = (String)request.getAttribute("formulaire_string");
  %>
         <%= formulaire %>
 
</body>
</html>