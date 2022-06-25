<%@page import="modelo.Hospede"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="modelo.Quarto"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%
Hospede hospede = (Hospede) request.getAttribute("hospede");
Collection<Quarto> quartosvazios = (Collection<Quarto>) request.getAttribute("quartosVazios");
%>

<form method="POST"
	  action="${pageContext.request.contextPath}/hospede/editar">  
	<input type="hidden" name="numId" id="numId"
	value="<%=hospede.getId()%>">
	<p>
		<label for="txtNome">Nome:</label>
		<input type="text" name="txtNome" value="<%=hospede.getNome()%>">
	</p>
	
	<p>
		<label for="txtEndereco">Endereço</label>
		<input type="text" name="txtEndereco" value="<%=hospede.getEndereco()%>">
	</p>
	
	<p>
		<label for="txtTelefone">Telefone:</label>
		<input type="text" name="txtTelefone" value="<%=hospede.getTelefone()%>">
	</p>
		<p>
		<label for="quartosDisponiveis">Quartos Disponíveis:</label>
		<select name="quartosDisponiveis" required>
			<%
			for(Quarto pf : quartosvazios)
			{
				out.print("<option value=\"");
				
				out.print(pf.getId());
				
				out.print("\">"); // <option value="XX">
				
				out.print("Quarto: ");
				
				out.print(pf.getId()); 
				
				out.print(" Bloco "+pf.getLocalizacao()); 
				
				out.print("</option>");
			}
			%>
		</select>
	</p>
	
	<p>
		<input type="submit" value="Enviar">
	</p>
</form>