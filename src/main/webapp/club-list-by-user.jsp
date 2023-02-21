<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PL Club Player Lists</title>
</head>
<body>
<form method = "post" action = "listNavigationServlet"
><table>
<c:forEach items="${requestScope.allLists}" var="currentlist">
<tr>
	<td><input type="radio" name="id" value="${currentlist.id}"></td>
	<td><h2>${currentlist.listName}</h2></td></tr>
	<tr><td colspan="3">Date Added: ${currentlist.dateAdded}</td></tr>
	<tr><td colspan="3">Player: 
	${currentlist.player.playerName}</td></tr>
	<c:forEach var = "listVal" items = "${currentlist.listOfClubs}">
		<tr><td></td><td colspan="3">
		${listVal.city}, ${listVal.club}, ${listVal.teamManager}, ${listVal.footballRanking}
		</td>
	</tr>
	</c:forEach>
</c:forEach>
</table>

<input type = "submit" value = "edit" name = "doThisToList">
<input type = "submit" value = "delete" name = "doThisToList">
<input type = "submit" value = "add" name = "doThisToList">
</form>

<a href="addClubsForListServlet">Create New List</a>
<a href="index.html">Insert New Club</a>
</body>
</html>
