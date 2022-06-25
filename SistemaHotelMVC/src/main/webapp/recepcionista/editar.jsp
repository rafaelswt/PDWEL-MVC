<%@page import="modelo.Recepcionista"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="modelo.Quarto"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%
Recepcionista recepcionista = (Recepcionista) request.getAttribute("recepcionista");
Collection<Quarto> quartosvazios = (Collection<Quarto>) request.getAttribute("quartosVazios");
%>

<form method="POST"
	  action="${pageContext.request.contextPath}/recepcionista/editar">
	<input type="hidden" name="numId" id="numId"
	value="<%=recepcionista.getId()%>">
	<p>
		<label for="txtNome">Nome:</label>
		<input type="text" name="txtNome" value="<%=recepcionista.getNome()%>">
	</p>
	
	<p>
		<label for="txtEndereco">Endereço</label>
		<input type="text" name="txtEndereco" value="<%=recepcionista.getEndereco()%>">
	</p>
	
	<p>
		<label for="txtTelefone">Telefone:</label>
		<input type="text" name="txtTelefone" value="<%=recepcionista.getTelefone()%>">
	</p>
	<p>
		<input type="submit" value="Enviar">
	</p>
</form>