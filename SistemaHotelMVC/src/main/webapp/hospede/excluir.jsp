<%@page import="modelo.Hospede"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
Hospede hospede = (Hospede) request.getAttribute("hospede");
%>

<p>Tem certeza que deseja excluir o cadastro de <%=hospede.getNome()%>?</p>

<form action="${pageContext.request.contextPath}/hospede/excluir"
	method="POST">
	<input type="hidden" name="numId" value="<%=hospede.getId()%>">
	<p>
		<input type="submit" value="Sim">
	</p>
</form>