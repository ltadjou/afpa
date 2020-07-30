<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>
<div class="mx-auto border rounded p-5 m-5 bg-secondary text-white" style="width:400px">
  <h2>ADMINISTRATEUR</h2><br/>
  <form action="authentification" method="POST">
    <div class="form-group">
      <label for="identifiant">Identifiant:</label>
      <input type="text" class="form-control" id="idtf" name="idtf" value="${idtf}">
    </div>
    <div class="form-group">
      <label for="pwd">Mot de passe:</label>
      <input type="password" class="form-control" id="pwd" name="pwd">
    </div>
    <button type="submit" class="btn btn-primary">Se connecter</button>	
    <p class="text-warning">${err}</p>
  </form>
</div>
</body>
</html>