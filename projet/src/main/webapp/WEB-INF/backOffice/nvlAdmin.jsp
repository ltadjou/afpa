<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <h4>Fiche de création d'un nouvel administrateur</h4><br><br>
      <form action="creerAd" method="POST">
      <c:import url="zCorpsAd.jsp"/>
      <br>
      <div class="row">
      <div class="col text-center">
      <button type="submit" class="btn btn-primary">Enregistrer</button>
      </div>
      </div>
      <p class="text-warning text-center">${err}</p>
      </form>
</div>
</body>
</html>