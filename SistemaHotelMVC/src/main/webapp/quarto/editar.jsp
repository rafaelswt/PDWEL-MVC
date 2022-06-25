
<%@page import="modelo.Quarto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
Quarto quarto = (Quarto) request.getAttribute("quarto");
%>

<form method="POST"
	  action="${pageContext.request.contextPath}/quarto/editar">
	  
	<input type="hidden" name="numId" id="numId"
	value="<%=quarto.getId()%>">
	<p>
		<label for="txtTipo">Tipo: </label>
		<select name="txtTipo" required>
			<option value="" selected>- Selecione -</option>
			<option value="Simples">Simples</option>
			<option value="Especial">Especial</option>
		</select>
	</p>
	<p>
		<label for="txtBloco">Bloco: </label>
		<select name="txtBloco" required>
			<option value="" selected>- Selecione -</option>
			<option value="A">A</option>
			<option value="B">B</option>
			<option value="C">C</option>
		</select>
	</p>
	<p>
		<input type="submit" value="Enviar">
	</p>
	