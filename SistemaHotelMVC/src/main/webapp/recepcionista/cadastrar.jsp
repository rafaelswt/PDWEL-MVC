<%@page import="java.util.Collection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<form method="POST"
	  action="${pageContext.request.contextPath}/recepcionista/cadastrar">
	<p>
		<label for="txtNome">Nome:</label>
		<input type="text" name="txtNome">
	</p>
	<p>
		<label for="txtEndereco">Endereço</label>
		<input type="text" name="txtEndereco">
	</p>
	<p>
		<label for="txtTelefone">Telefone:</label>
		<input type="text" name="txtTelefone">
	</p>

	<p>
		<input type="submit" value="Enviar">
	</p>
</form>