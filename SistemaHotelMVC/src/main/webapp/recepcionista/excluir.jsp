<%@page import="modelo.Recepcionista"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
Recepcionista recepcionista = (Recepcionista) request.getAttribute("recepcionista");
%>

<p>Tem certeza que deseja excluir o cadastro de <%=recepcionista.getNome()%>?</p>

<form action="${pageContext.request.contextPath}/recepcionista/excluir"
	method="POST">
	<input type="hidden" name="numId" value="<%=recepcionista.getId()%>">
	<p>
		<input type="submit" value="Sim">
	</p>
</form>