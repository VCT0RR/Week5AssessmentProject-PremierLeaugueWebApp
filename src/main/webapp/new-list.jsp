<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New Player List</title>
</head>
<body>
<form action = "createNewListServlet" method = "post">
List Name: <input type = "text" name = "listName"><br />
Date Added: <input type = "text" name = "month" placeholder = "mm" size = "4"> 
<input type = "text" name = "day" placeholder = "dd" size = "4">
<input type = "text" name = "year" placeholder = "yyyy" size = "4">
Player Name: <input type = "text" name = "playerName"><br />

Available Clubs:<br />
<select name = "allClubsToAdd" multiple size = "6">
<c:forEach items = "${requestScope.allClubs}" var= "currentclub">
	<option value="${currentclub.id}"> ${currentclub.city} | ${currentclub.club} | ${currentclub.teamManager} | ${currentclub.footballRanking}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value = "Create List & Add Clubs">
</form>
<a href = "index.html">Add New Club</a>
</body>
</html>