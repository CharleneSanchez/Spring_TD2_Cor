<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Les produits</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>
	<div class="container text-center">
	  <div class="row">
	    <div class="col">Id</div>
	    <div class="col">Nom</div>
	    <div class="col">Référence</div>
	    <div class="col">Prix</div>
	    <div class="col">Poids</div>
	    <div class="col">Action</div>
	  </div>
	  
	  <c:forEach var="prod" items="${ listeP }">
		  <div class="row">
		  	<div class="col">${ prod.getId() }</div>
		  	<div class="col"><c:out value="${ prod.getNom() }"></c:out></div>
		    <div class="col"><c:out value="${ prod.getReference() }"></c:out></div>
		    <div class="col"><c:out value="${ prod.getPrix() }"></c:out></div>
		    <div class="col"><c:out value="${ prod.getPoids() }"></c:out></div>
		    <div class="col">
		    	<a href="deleteProduit/${ prod.getId() }"> <button type="button" class="btn btn-outline-danger">Supprimer</button></a>
		    </div>
		  </div>
	  </c:forEach>
	  
	</div>
</body>
</html>