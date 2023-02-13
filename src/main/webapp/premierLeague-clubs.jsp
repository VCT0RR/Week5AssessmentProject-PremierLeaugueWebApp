<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Premier League Web App</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" 
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<style>

* {
    box-sizing: border-box;
}

body {
    background-color: #2E4057;
    font-family: 'Roboto', Arial, Helvetica, sans-serif;
}

p {
    color: darkblue;
    font-size: large;
}

h1 {
    color: #083D77;
    background-color: #DEA057;
    font-family: 'Montserrat', sans-serif;
    text-align: center;
    text-transform: uppercase;
    font-weight: 700;
    border-radius: 8px;
    margin-top: 6px;
}

.center {
    text-align: center;
}

h2.center {
	font-family: 'Dosis', sans-serif;
    font-size: 30px;
    text-transform: uppercase;
    color: green;
}

.container {
    max-width: 80%;
    padding: 5px 5px;
    margin: 0 auto;
    border: 2px solid green;
    background-color: rgb(232, 220, 199);
    border-radius: 20px;
    box-shadow: 5px 5px 5px rgba(0, 0, 0, .5);
}

footer {
    padding: 2px;
    background-color: rgb(232, 220, 199);
    margin: auto;
    margin-top: 15px;
    border-radius: 8px;
    width: 100%;
    text-align: center;
}

footer p {
    color: black;
}

form {
    width: 100%;
    max-width: 1000px;
    margin: auto;
    padding: 15px;
    border: thin solid lightgray;
    border-radius: 10px;
    display: table;
    flex-direction: column;
    justify-content: center;
    background-color: #DEA057;
    border: 2px solid black;
}

.form-group {
    margin-bottom: 1em;
    display: flex;
    align-items: center;
    justify-content: center;
    padding: 5px;

}

.table-group {
	border: 1px solid lightgray;
	text-align: center;
	display: flex;
	justify-content: center;
	padding: 5px;
}

.form-group label,
.label {
    margin-right: 0.5em;
    font-weight: 700;
    flex-basis: 8em;
    text-align: right;
}

.form-group input {
    line-height: 1;
}

.form-group input,
textarea,
.form-group select {
    border-radius: 4px;
    border: 1px solid gray;
    padding: 8px;
    font-size: .875rem;
    flex: 1;
}

.form-group select {
    background-position: right .75rem center;
    background-size: 16px 12px;
    appearance: none;
    padding-right: 3em;
}

.form-group select::after {
    display: block;
    clear: both;
    content: "";
}

.flex-buttons {
    display: flex;
    justify-content: space-evenly;
    padding: 10px;    
}

input[type=submit],
input[type=reset] {
    background-image: none;
    border-radius: 4px;
    border-color: black;
    box-shadow: none;
    display: inline-block;
    text-align: center;
    text-decoration: none;
    vertical-align: middle;
    padding: .375rem .75rem;
    font-size: 1rem;
}

input[type=submit] {
    background-color: #0b5ed7;
    border-color: #0a58ca;
    color: #fff;
}

input[type=reset] {
    margin-right: 1rem;
    background-color: #0b5ed7;
    border-color: #0a58ca;
    color: #fff;
}

a {
	text-align: center;
	display: flex;
	justify-content: center;
	font-family: 'Roboto', Arial, Helvetica, sans-serif;
    font-size: 25px;
}
</style>

</head>
<body>
<header>
	<h1>Premier League Clubs</h1>
	</header>
<div class="container">
	<form method="post" action="navigationServlet">
	<h2 class="center">Club Information</h2>	
	<div class="table-group">
		<table>
			<c:forEach items="${requestScope.allClubs}" var="currentclub">
			<tr>
			<td>
			<div class="form-group">
				<label>City: </label>
				<input type="radio" name="id" value="${currentclub.id}">
			</div>
			</td>
			
			<td>
			<div class="form-group">
				${currentclub.city}
			</div>
			</td>
			
			<td>
			<div class="form-group">
				${currentclub.club} 
			</div>
			</td>
			
			
			<td>
			<div class="form-group">
				${currentclub.teamManager}
			</div>
			</td>
			
			<td>
			<div class="form-group">
				${currentclub.footballRanking}
			</div>
			</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<div class="flex-buttons">
		<input type="submit" value="edit" name="doThisToClub">
		<input type="submit" value="delete" name="doThisToClub">
		<input type="submit" value="add" name="doThisToClub">
	</div>
	</form>
	<footer>
	<p> Copyright&copy; 2023 All Rights Reserved. Premier League Clubs</p>
	</footer>
</div>
</body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
    crossorigin="anonymous"></script>
    
</html>