<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<c:import url="menu.jsp"/>
<br>
<div class="container-expand-sm mx-5">
  <div class="row">
		<div class="col-sm-10">
      		<h4>Liste des administrateurs</h4>
     	</div>
     	<div class="col-sm-2 text-center my-auto">
     	<form action="majListAd" method="POST">
      		<button class="btn btn-primary" type="submit">Mettre à jour la liste</button>
      		<p class="text-primary text-center">${msg}</p>
      	</form>
     	</div>
      </div>
      <br>
      <table class="table">
    <thead>
      <tr>
        <th>ID</th>
        <th>Identifiant</th>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Date d'entree</th>
        <th>Actif</th>
        <th>Inactif</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${admins}" var="a">
    <tr>
    <td><a href="ficheAd?idA=${a.id}">${a.id}</a></td>
    <td>${a.identifiant}</td>
    <td>${a.nom}</td>
    <td>${a.prenom}</td>
    <td><fmt:formatDate value="${a.dateEntree}" pattern="dd/MM/yyyy"/></td>
    <td><input type="radio" class="form-check-input" disabled value="${a.statut.id}" 
     		<c:if test="${a.actif}">checked</c:if> ></td>
    <td><input type="radio" class="form-check-input" disabled value="${a.statut.id}"  
    <c:if test="${!a.actif}">checked</c:if> ></td>
    </tr>
     </c:forEach>
      </tbody>
      </table>
    </div>
</body>
</html>