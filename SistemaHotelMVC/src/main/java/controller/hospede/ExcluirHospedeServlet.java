package controller.hospede;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Conta;
import modelo.Hospede;
import modelo.Quarto;
import modelo.repositorio.ContaRepositorio;
import modelo.repositorio.HospedeRepositorio;
import modelo.repositorio.PersistenceConfig;
import modelo.repositorio.QuartoRepositorio;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Servlet implementation class ExcluirHospedeServlet
 */
public class ExcluirHospedeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirHospedeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int hospedeID = 0;
		Hospede hospede = null;
		
		try
		{
			hospedeID = Integer.parseInt(request.getParameter("id").trim());
			
			HospedeRepositorio repositorio =
					new HospedeRepositorio();
			
			hospede = repositorio.recuperarHospedePorID(hospedeID);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		if(hospede == null)
			hospede = new Hospede();
		
		request.setAttribute("hospede", hospede);
		
		request.setAttribute("tituloPagina",
				"Excluir Hospede");
		
		request.setAttribute("pathView",
				"hospede/excluir.jsp");
		
		jakarta.servlet.RequestDispatcher rd =
				request.getRequestDispatcher("/template.jsp");
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try
		{
			id = Integer.parseInt(request.getParameter("numId"));
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		if(id > 0)
		{	
			HospedeRepositorio repositorio = new HospedeRepositorio();
			
			Hospede h = repositorio.recuperarHospedePorID(id);
			
			Conta c = new Conta();
			
			c = h.getConta();
			
			boolean bool = c.isSituacao();
			
			if(bool == true)
			{
				Quarto q = new Quarto();
				q = h.getQuarto();
				
				q.setStatus_quarto(false);
		
				q.setData_saida(LocalDate.now());
				
				//exclui conta
				
				ContaRepositorio repC = new ContaRepositorio();
							
				repositorio.excluirHospede(h);
				
				request.setAttribute("mensagemAlerta", "Hospede excluido com sucesso!");
				
				PersistenceConfig.closeEntityManager();
				
			}
			else
			{
				request.setAttribute("mensagemErro", "O Hospede não pode excluido pois sua conta não está paga");
			}
			
		}
		
		jakarta.servlet.RequestDispatcher rd = request.getRequestDispatcher("/hospede");
		
		rd.forward(request, response);
	}

}
