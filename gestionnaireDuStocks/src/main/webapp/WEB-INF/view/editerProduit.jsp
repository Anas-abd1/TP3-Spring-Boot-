<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<script type="text/javascript" src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Modifier un Produit</title>
</head>
<body>
<div class="container">
<div class="card-body">
<form action="updateProduit" method="post">
<div class="form-group">
<label class="control-label">ID Produit :</label>
<input type="text" name="idProduit" value="${produit.id}" readonly class="form-control"/>
</div>
<div class="form-group">
<label class="control-label">Nom Produit :</label>
<input type="text" name="nomProduit" value="${produit.nom}" class="form-control"/>
</div>
<div class="form-group">
<label class="control-label">Stock Produit :</label>
<input type="text" name="stockProduit" value="${produit.stock}" class="form-control"/>
</div>

<div class="form-group">
<label class="control-label"> Taxe Produit :</label>
<input type="text" name="taxeProduit" value="${produit.taxe}" class="form-control"/>
</div>

<div class="form-group">
<label class="control-label">Jours Produit :</label>
<input type="text" name="joursProduit" value="${produit.jours}" class="form-control"/>
</div>

<div class="form-group">
<label class="control-label"> Date Recu :</label>
<fmt:formatDate pattern="yyyy-MM-dd" value="${produit.daterecu}" var="formatDate" />
<input type="date" name="date" value="${formatDate}" class="form-control"/>
</div>
<div>
<button type="submit" class="btn btn-primary">Modifier</button>
</div>
</form>
</div>
<br/>
<br/>
<a href="ListeProduits">Liste Produits</a>
</div>
</body>
</html>