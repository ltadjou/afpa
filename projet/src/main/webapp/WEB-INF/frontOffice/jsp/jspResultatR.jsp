<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultats de recherche</title>
<%@ include file = "jspHeader.jsp" %>
<link rel="stylesheet" href="css/style.css" >
</head>
<body>
	<h1>Trouvez votre professionnel</h1>
	<form action="rechercher2" method="post" id="f12">
		<select name="categories">
    		<c:forEach var="c" items="${sessionScope['scopedTarget.imit01Session'].categories}"  >
        		<option  value="${c.nom}">${c.nom}</option>
    		</c:forEach>
		</select>
		
		<select name ="acteurs">
			<c:forEach items="${sessionScope['scopedTarget.imit01Session'].acteurs}" var="a">
        		<option value="${a.nom}">${a.nom}</option>
    		</c:forEach>
		</select>
		<input type= text placeholder= "Numéro/ Nom du département">
		<input id="submit2" type="submit" value="Rechercher">
	</form>
	<br>
	<section id="sect1">
		
	</section>
	<section id="profils">
		<c:set var="i" value="1" />
		 <c:forEach items="${profils}" var="u">
            <tr>
	            <form id = 'showProfil' action="#" >
	                <fieldset>
	                    <input type="hidden" id = "profilId" value="${u.id}"/></<br>
	                    <td><strong>Profil ${i} :</strong></td></br>
	                    <td> ${u.presentation}   </br> ${u.offre} <td/>
	                    </br>
	                </fieldset>
	            </form>
        	</tr>
        	<c:set var="i" value="${i+1}" />
        </c:forEach>
        
	</section>
	
	<%@ include file = "jspFooter.jsp" %>
</body>
</html>