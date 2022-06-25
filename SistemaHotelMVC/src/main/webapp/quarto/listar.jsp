<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Quarto"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%

Collection<Quarto> quartos = new ArrayList<Quarto>();
if(request.getAttribute("quartos") != null)
	quartos =
			(Collection<Quarto>) request.getAttribute("quartos");

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
				href="${pageContext.request.contextPath}/quarto/cadastrar"
				role="button">Cadastrar novo quarto</a>
		</div>
	</div>
</div>
<table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
  <thead>
      <tr>
      <th class="th-sm">ID
      </th>
      <th class="th-sm">Data de Entrada
      </th>
      <th class="th-sm">Data de Saída
      </th>
      <th class="th-sm">Bloco
      </th>
      <th class="th-sm">Ocupado
      </th>
      <th class="th-sm">Tipo
      </th>
    </tr>
  </thead>
  <tbody>
  	<%
  		for(Quarto q: quartos)
  		{
  			out.println("<tr>");
  			out.println("<td>" + q.getId() + "</td>");
  			out.println("<td>" + q.getData_entrada() + "</td>");
  			out.println("<td>" + q.getData_saida() + "</td>");
  			out.println("<td>" + q.getLocalizacao() + "</td>");
  			out.println("<td>" + (q.isStatus_quarto() == true ? "Sim" : "Não") + "</td>");
  			out.println("<td>" + q.getTipo_quarto() + "</td>");
  			
  			out.println("<td>");
  			out.println("<a role=\"button\" class=\"btn btn-secondary\" ");
  			out.print("href=\"");
  			out.print(request.getContextPath());
  			out.print("/quarto/editar?id=");
  			out.print(q.getId());
  			out.print("\" >");
  			out.println("<i class=\"bi bi-pencil-square\"></i>");
  			out.println("</a>");
  			
  			out.println("<td>");
  			out.println("<a role=\"button\" class=\"btn btn-secondary\" ");
  			out.print("href=\"");
  			out.print(request.getContextPath());
  			out.print("/quarto/excluir?id=");
  			out.print(q.getId());
  			out.print("\" >");
  			out.println("<i class=\"bi bi-x-square\"></i>");
  			out.println("</a>");
  			out.println("</tr>");
  			
  			out.println("</tr>");
  			
  		}
  	%>
  </tbody>
</table>
