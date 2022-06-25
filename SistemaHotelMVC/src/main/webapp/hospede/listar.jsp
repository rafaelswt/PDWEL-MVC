<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Hospede"%>
<%@page import="modelo.Quarto"%>
<%@page import="modelo.Conta"%>

<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

Collection<Hospede> hospedes = new ArrayList<Hospede>();
if(request.getAttribute("hospedes") != null)
{
	hospedes =
			(Collection<Hospede>) request.getAttribute("hospedes");
}

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
				href="${pageContext.request.contextPath}/hospede/cadastrar"
				role="button">Cadastrar novo hospede</a>
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
      <th class="th-sm">Conta
      </th>
      <th class="th-sm">Quarto
      </th>
    </tr>
  </thead>
  <tbody>
  	<%
  		for(Hospede p: hospedes)
  		{
  			out.println("<tr>");
  			out.println("<td>" + p.getId() + "</td>");
  			out.println("<td>" + p.getNome() + "</td>");
  			out.println("<td>" + p.getEndereco() + "</td>");
  			out.println("<td>" + p.getTelefone() + "</td>");
  			
  			int NumConta = 0;
  			int NumQuarto = 0;
  			
  			if(p.getConta() != null)
  			{
  				Conta c = p.getConta();
  				NumConta = c.getId();
  			}
  			
  			if(p.getQuarto() != null)
  			{
  				Quarto q = p.getQuarto();
  				NumQuarto = q.getId();
  			}
  			out.println("<td>" + NumConta + "</td>");
  			out.println("<td>" + NumQuarto + "</td>");
  			

  			out.println("<td>");
  			out.println("<a role=\"button\" class=\"btn btn-secondary\" ");
  			out.print("href=\"");
  			out.print(request.getContextPath());
  			out.print("/hospede/editar?id=");
  			out.print(p.getId());
  			out.print("\" >");
  			out.println("<i class=\"bi bi-pencil-square\"></i>");
  			out.println("</a>");
  			
  			out.println("<td>");
  			out.println("<a role=\"button\" class=\"btn btn-secondary\" ");
  			out.print("href=\"");
  			out.print(request.getContextPath());
  			out.print("/hospede/excluir?id=");
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
