<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Association</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>
	
	<form method="post" action="affecterProduitsToMagasins">

	<h1>Liste des produits</h1>
	
	<div class="container text-center">
	  <div class="row">
	  	<div class="col">#</div>
	    <div class="col">Id</div>
	    <div class="col">Nom</div>
	    <div class="col">Référence</div>
	    <div class="col">Prix</div>
	    <div class="col">Poids</div>
	    <div class="col">Action</div>
	  </div>
	  
	  <c:forEach var="prod" items="${ listeP }">
		  <div class="row">
		  	<div class="col">
		  		<input type="checkbox" name="selectedProduits" value="${ prod.getId() }" class="form-check-input mt-0" >
		  	</div>
		  	<div class="col">
		  		<a href="getProduit/${ prod.getId() }">${ prod.getId() }</a>
		  	</div>
		  	<div class="col"><c:out value="${ prod.getNom() }"></c:out></div>
		    <div class="col"><c:out value="${ prod.getReference() }"></c:out></div>
		    <div class="col"><c:out value="${ prod.getPrix() }"></c:out></div>
		    <div class="col"><c:out value="${ prod.getPoids() }"></c:out></div>
		    <div class="col">
		    	<a href="deleteProduit/${ prod.getId() }"> <button type="button" class="btn btn-outline-danger">Supprimer</button></a>
		    </div>
		  </div>
	  </c:forEach>
	  
	  <hr>
	  
	  <h1>Liste des magasins</h1>
	  
	  <div class="container text-center">
	  <div class="row">
	  	<div class="col">#</div>
	    <div class="col">Id</div>
	    <div class="col">Nom</div>
	    <div class="col">Adresse</div>
	    <div class="col">CP</div>
	    <div class="col">Ville</div>
	    <div class="col">Action</div>
	  </div>
	  
	  <c:forEach var="mag" items="${ listeM }">
		  <div class="row">
		  	<div class="col">
		  		<input type="checkbox" name="selectedMagasins" value="${ mag.getId() }" class="form-check-input mt-0" >
		  	</div>
		  	<div class="col">
		  		<a href="getMagasin/${ mag.getId() }">${ mag.getId() }</a>
		  	</div>
		  	<div class="col"><c:out value="${ mag.getNom() }"></c:out></div>
		    <div class="col"><c:out value="${ mag.getAdresse() }"></c:out></div>
		    <div class="col"><c:out value="${ mag.getCp() }"></c:out></div>
		    <div class="col"><c:out value="${ mag.getVille() }"></c:out></div>
		    <div class="col">
		    	<a href="deleteMagasin/${ mag.getId() }"> <button type="button" class="btn btn-outline-danger">Supprimer</button></a>
		    </div>
		  </div>
	  </c:forEach>
	  
	</div>
	  
	</div>
	
	<button type="submit" class="btn btn-outline-success btn-sm">Valider</button>
	<button type="reset" class="btn btn-outline-secondary btn-sm">Annuler</button>
	
	</form>

</body>
</html>