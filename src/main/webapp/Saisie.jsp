<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Calcul" method="post">
		<input type="number" name="operande1" placeholder="operande1"> 
		<input type="number" name="operande2" placeholder="operande2"> 
		<select name="operation">
			<option value="+">+</option>
			<option value="-">-</option>
			<option value="/">/</option>
			<option value="*">*</option>
		</select>
		<input type="submit" value="Calculer">
	</form>
	
	<c:if test="${param.error == 'invalid'}">
		<p style="color: red;">Veuillez enter des opérendes valides</p>
	</c:if>
		<c:if test="${param.error == 'denominateur==0'}">
		<p style="color: red;">Opérende2 (dénominateur) doit etre différent de 0</p>
	</c:if>
		<c:if test="${param.error == 'invalidee'}">
		<p style="color: red;">-------------------</p>
	</c:if>

</body>
</html>