
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<%@ include file = "jspHeader.jsp" %>
<link rel="stylesheet" href="css/style.css" >
</head>
<body id= "body">
	<br>
	<br>
	<br>
	<br>
	<h1>Trouvez votre professionnel</h1>
	<br>
	
	
	
	
	<form action="rechercher" method="post" id="f1">

		<select name="categories">
    		<c:forEach var="c" items="${sessionScope['scopedTarget.imit01Session'].categories}"  >
        		<option  value="${c.nom}">${c.nom}</option>
    		</c:forEach>
		</select>

		<select name ="acteurs">
    		<c:forEach items="${sessionScope['scopedTarget.imit01Session'].acteurs}" var="a">

        		<option selected="true" value="${a.nom}">${a.nom}</option>
    		</c:forEach>
		</select>
		
		<input id="inputDept" name = "dept" type= text placeholder= "Numéro du département">
		<br>
		<input id="submit" type="submit" value="Rechercher">
	</form>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<footer><%@ include file = "jspFooter.jsp" %></footer>
</body>
</html>