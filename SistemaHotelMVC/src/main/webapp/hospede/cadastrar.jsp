<%@page import="modelo.Recepcionista"%>
<%@page import="modelo.Quarto"%>
<%@page import="java.util.Collection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%
Collection<Quarto> quartosvazios =
	(Collection<Quarto>) request.getAttribute("quartosVazios");
Collection<Recepcionista> recepcionistas =
(Collection<Recepcionista>) request.getAttribute("recepcionistas");
%>

<form method="POST"
	  action="${pageContext.request.contextPath}/hospede/cadastrar">
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
		<input type="number" name="txtTelefone">
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
		<label for="recepcionistas">Recepcionista:</label>
		<select name="recepcionistas" required>
			<%
			for(Recepcionista pf : recepcionistas)
			{
				out.print("<option value=\"");
				
				out.print(pf.getId());
				
				out.print("\">"); // <option value="XX">
				
				//out.print("Quarto: ");
				
				out.print(pf.getNome()); 
				
				//out.print(" Bloco "+pf.getLocalizacao()); 
				
				out.print("</option>");
			}
			%>
		</select>
	</p>
	
	
	<p>
		<input type="submit" value="Enviar">
	</p>
</form>