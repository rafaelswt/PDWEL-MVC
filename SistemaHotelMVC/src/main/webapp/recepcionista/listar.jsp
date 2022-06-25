<%@page import="java.util.HashSet"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Recepcionista"%>
<%@page import="modelo.Quarto"%>
<%@page import="modelo.Conta"%>

<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

Collection<Recepcionista> recepcionistas = new ArrayList<Recepcionista>();
if(request.getAttribute("recepcionistas") != null)
	recepcionistas =
			(Collection<Recepcionista>) request.getAttribute("recepcionistas");

//get recepcionista_quarto



String mensagemAlerta, classeDivAlerta = "";
mensagemAlerta = (String) request.getAttribute("mensagemAlerta");

if(mensagemAlerta == null) {
	mensagemAlerta = "";
	classeDivAlerta = "div-oculta";
}
String mensagemErro, classeDivErro = "";
mensagemErro = (String) request.getAttribute("mensagemErro");

if(mensagemErro == null) {
	mensagemErro = "";
	classeDivErro = "div-oculta";
}
%>

<!-- Bootstrap Alerts -->
<!-- https://getbootstrap.com/docs/4.6/components/alerts/ -->
<div class="alert alert-primary alert-dismissible fade show <%= classeDivAlerta %>" role="alert">
	<h4 class="alert-heading">Feito!</h4>
	<%= mensagemAlerta %>
	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
</div>
<div class="alert alert-danger <%= classeDivErro %>" role="alert">
	<h4 class="alert-heading">Erro!</h4>
	<%= mensagemErro %>
	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
</div>
<div class="container">
	<div class="row">
		<div class="col-xl-12 d-flex flex-row">
			<a class="btn btn-primary"
				href="${pageContext.request.contextPath}/recepcionista/cadastrar"
				role="button">Cadastrar novo recepcionista</a>
		</div>
	</div>
</div>

<table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
  <thead>
    <tr>
      <th class="th-sm">ID
      </th>
      <th class="th-sm">Nome
      </th>
      <th class="th-sm">Endereço
      </th>
      <th class="th-sm">Telefone
      </th>
      <!--  
      <th class="th-sm">Conta
      </th>
      <th class="th-sm">Quarto
      </th>
      -->
    </tr>
  </thead>
  <tbody>
  	<%
  		for(Recepcionista p: recepcionistas)
  		{
  			out.println("<tr>");
  			out.println("<td>" + p.getId() + "</td>");
  			out.println("<td>" + p.getNome() + "</td>");
  			out.println("<td>" + p.getEndereco() + "</td>");
  			out.println("<td>" + p.getTelefone() + "</td>");
  	
  			out.println("<td>");
  			out.println("<a role=\"button\" class=\"btn btn-secondary\" ");
  			out.print("href=\"");
  			out.print(request.getContextPath());
  			out.print("/recepcionista/editar?id=");
  			out.print(p.getId());
  			out.print("\" >");
  			out.println("<i class=\"bi bi-pencil-square\"></i>");
  			out.println("</a>");
  			
  			out.println("<td>");
  			out.println("<a role=\"button\" class=\"btn btn-secondary\" ");
  			out.print("href=\"");
  			out.print(request.getContextPath());
  			out.print("/recepcionista/excluir?id=");
  			out.print(p.getId());
  			out.print("\" >");
  			out.println("<i class=\"bi bi-x-square\"></i>");
  			out.println("</a>");
  			out.println("</tr>");
  			
  			out.println("</tr>");
  			
  		}
  	%>
  </tbody>
</table>
