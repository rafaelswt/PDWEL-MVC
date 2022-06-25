<%@page import="modelo.Conta"%>
<%@page import="modelo.Recepcionista"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="modelo.Quarto"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%
Conta conta = (Conta) request.getAttribute("conta");
%>

<form method="POST"
	  action="${pageContext.request.contextPath}/conta/editar">
	 <input type="hidden" name="id" id="id" value="<%=conta.getId()%>">
	<p style ="font-weight: bold;">
		<label for="txtID">ID:</label>
		<%=conta.getId()%>
	</p>

	<select id='ddlTrueFalse' name='pago'>
	  <option value= "false">Não Pago</option>
	  <option value= "true" >Pago</option>
	</select>
	<p></p>
	<p>
		<input type="submit" value="Enviar">
	</p>
</form>


