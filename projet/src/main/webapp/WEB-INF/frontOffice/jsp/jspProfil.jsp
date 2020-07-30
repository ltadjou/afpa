<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Profil</title>
<link rel="stylesheet" href="css/style.css" >
</head>
<body>

<h1 class='titreprofil'>VOTRE PROFIL</h1>

<p class='connexionprofil'><a  href="vers-jspHome">Se déconnecter</a></p>

 

<div >
<h1 class= 'nomprofil'>${nom} ${prenom} </h1>
<h2 class ='acteurprofil'>${acteur}</h2>

</div>

<div>
<input type="image" class="photoprofil" src="${photop}">
</div>

<div class='infosprofil' id='infos'>

<p id='tel'>Téléphone : ${tel}</p>
<p id='email'>Email : ${mail}</p>
<p id='ville'> Ville : ${ville}</p>
</div>

<div class='presprofil'>
<label class='presprofillabel'>${pres}</label> <br>
</div>

<div id='serviceprofil'>

 <c:forEach items="${services}" var="s">
${s.nom} <br>
    </c:forEach>

</div>

<div class='offreprofil'>
<label class='offreprofillabel' >${offre}</label> <br>
</div>
<p class= 'boutonmodif'>
<input type="button" value="Modifier" />
</p>

</body>
</html>