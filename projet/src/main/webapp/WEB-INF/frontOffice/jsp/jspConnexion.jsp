<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
<link rel="stylesheet" href="css/style.css" >

</head>
<body>
	<br>
	<br>
	<br>
	<div id="cadre">
	<h1>ACTOREP</h1>
		<form id="formCon" method="post" action="seConnecter">
			<br />
			<label for="Email">Email<span class="requis">*</span></label>
			<input type="text" name="email">
			<br />
			<br>
			<label for="mdp">Mot de passe<span class="requis">*</span></label>
			<input type= "password" name="mdp">
			<br />
			<br />
			<br>
			<input id="submit" type="submit" value="Se connecter">
		</form>
		<p id="error">${error1}</p>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<%@ include file = "jspFooter.jsp" %>
	

</body>
</html>