<%@page import="modelo.Quarto"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
Quarto quarto = (Quarto) request.getAttribute("quarto");
%>

<p>Tem certeza que deseja excluir o cadastro de <%=quarto.getId()%>?</p>

<form action="${pageContext.request.contextPath}/quarto/excluir"
	method="POST">
	<input type="hidden" name="numId" value="<%=quarto.getId()%>">
	<p>
		<input type="submit" value="Sim">
	</p>
</form>