<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Conta"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

Collection<Conta> contas = new ArrayList<Conta>();
if(request.getAttribute("contas") != null)
	contas =
			(Collection<Conta>) request.getAttribute("contas");
%>
<!-- 
<div class="container">
	<div class="row">
		<div class="col-xl-12 d-flex flex-row">
			<a class="btn btn-primary"
				href="${pageContext.request.contextPath}/conta/cadastrar"
				role="button">Cadastrar novo conta</a>
		</div>
	</div>
</div>
-->
<table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
  <thead>
      <tr>
      <th class="th-sm">ID
      </th>
      <th class="th-sm">Pago
      </th>
    </tr>
  </thead>
  <tbody>
  	<%
  		for(Conta q: contas)
  		{
  			out.println("<tr>");
  			out.println("<td>" + q.getId() + "</td>");
  			out.println("<td>" + (q.isSituacao() == true ? "Sim" : "Não") + "</td>");

  			out.println("<td>");
  			out.println("<a role=\"button\" class=\"btn btn-secondary\" ");
  			out.print("href=\"");
  			out.print(request.getContextPath());
  			out.print("/conta/editar?id=");
  			out.print(q.getId());
  			out.print("\" >");
  			out.println("<i class=\"bi bi-pencil-square\"></i>");
  			out.println("</a>");
  			
  			out.println("</tr>");
  			
  		}
  	
  		
  	%>
  </tbody>
</table>
