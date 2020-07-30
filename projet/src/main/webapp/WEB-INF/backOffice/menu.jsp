<div class="container-expand-sm bg-dark">
<div class="row">
<div class="col-sm-10">
<nav class="navbar navbar-expand-sm navbar-dark">
  <a class="navbar-brand" href="#">Bonjour ${sessionScope['scopedTarget.sessionAdmin'].lastLogIn.prenom}</a>
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="RechercherProfilaValider">Profils à valider</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Recherche profil</a>
    </li>
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        Administrateur
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="droitsAd">Gestion des droits</a>
        <a class="dropdown-item" href="nvlAd">Nouvel administrateur</a>
      </div>
    </li>
   <li class="nav-item">
      <a class="nav-link" href="#">Statistique</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Documents</a>
    </li>

  </ul> 
</nav>
</div>
<div class="col-sm-2 text-center my-auto">
<form action="deconnecter" method="POST">
<button class="btn btn-primary" type="submit">Se déconnecter</button>
</form>
</div>
</div>
</div>

