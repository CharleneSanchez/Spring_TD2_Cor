<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Les magasins</title>
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
	    <div class="col">Adresse</div>
	    <div class="col">CP</div>
	    <div class="col">Ville</div>
	    <div class="col">Action</div>
	  </div>
	  
	  <c:forEach var="mag" items="${ listeM }">
		  <div class="row">
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
</body>
</html>