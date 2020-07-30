<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row my-auto">
  <div class="col-1 text-right">
     <p>ID</p>
    </div>
    <div class="col-1">
      <input type="text" class="form-control" id="idAd" name="idAd" value="${idAd}" readonly>
    </div>
    <div class="col-2 text-right">
      <p>Prénom *</p>
    </div>
    <div class="col-3">
      <input type="text" class="form-control" id="prenomAd" name="prenomAd" value="${prenomAd}">
		<p class="text-warning"></p>    
    </div>
    <div class="col-2 text-right">
      <p>Nom *</p>
    </div>
    <div class="col-3">
      <input type="text" class="form-control" id="nomAd" name="nomAd" value="${nomAd}">
  </div>
</div>
<br>
<div class="row">
  <div class="col-2 text-right">
    </div>
    <div class="col-2 text-right">
      <p>Identifiant</p>
    </div>
    <div class="col-3">
      <input type="text" class="form-control" id="idtf" name="idtf" value="${idtf}" readonly>
	<p class="text-warning"></p>      
    </div>
    <div class="col-2 text-right">
      <p>Mot de passe *</p>
    </div>
    <div class="col-3">
      <input type="password" class="form-control" id="mdpAd" name="mdpAd" value="${mdpAd}">
  	</div>
</div>
  <br>
<div class="row">
  <div class="col-2 text-right">
    </div>
    <div class="col-2 text-right">
      <p>Numéro employé *</p>
    </div>
    <div class="col-3">
      <input type="text" class="form-control" placeholder="------" id="numAd" name="numAd" value="${numAd}">
      <p class="text-warning">${errNum}</p>
    </div>
    <div class="col-2 text-right">
      <p>Date d'entrée *</p>
    </div>
    <div class="col-3">
      <input type="date" class="form-control" id="dateEnt" name="dateEnt" value="${dateEnt}">
  </div>
</div>
<br>
<div class="row">
  <div class="col-2 text-right">
    </div>
    <div class="col-2 text-right">
      <p>Statut</p>
    </div>
    <div class="col-2 text-center">
    <label class="form-check-label">
    <input type="radio" class="form-check-input" name="optradio" id="actif" value="A001" 
    <c:if test="${(empty actif) or actif}">checked</c:if> >actif
  </label>
    </div>
    <div class="col-1 text right">
      <label class="form-check-label">
    <input type="radio" class="form-check-input" name="optradio" id="inactif" value="A002" 
    <c:if test="${!(empty actif) and !actif}">checked</c:if> >inactif
  </label>
  </div>
   <div class="col-2 text-right">
      <p>Date de sortie</p>
    </div>
    <div class="col-3">
      <input type="date" class="form-control" id="dateSor" name="dateSor" value="${dateSor}">
  </div>
</div>
