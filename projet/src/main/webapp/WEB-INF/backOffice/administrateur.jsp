<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
    <li class="nav-item">
      <a class="nav-link ${tab01}" data-toggle="tab" href="#droits">Gestion des droits</a>
    </li>
    <li class="nav-item">
      <a class="nav-link ${tab02}" data-toggle="tab" href="#nouveau">Nouvel administrateur</a>
    </li>
</ul>
  <!-- Tab panes -->
  <div class="tab-content">
    <div id="droits" class="container-expand-sm mx-3 tab-pane ${tab01}"><br>
      <div class="row">
		<div class="col-sm-10">
      		<h4>Liste des administrateurs</h4>
     	</div>
     	<div class="col-sm-2 text-center my-auto">
      		<button class="btn btn-primary" type="submit">Mettre à jour la liste</button>
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
    <td><a href="afficher"/>${a.id}</a></td>
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
   
    <div id="nouveau" class="container-expand-sm mx-3 tab-pane ${tab02}"><br>
      <h4>Fiche à remplir :</h4><br><br>
      <form action="creerAdmin" method="POST">
      <c:import url="ficheAdmin.jsp"/>
      <br>
      <div class="row">
      <div class="col text-center">
      <button type="submit" class="btn btn-primary">Enregistrer</button>
      </div>
      </div>
      <p class="text-warning text-center">${err}</p>
      </form>
    </div>
  </div>
</div>

</body>
</html>