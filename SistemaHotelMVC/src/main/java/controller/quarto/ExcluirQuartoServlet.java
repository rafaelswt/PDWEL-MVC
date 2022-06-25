package controller.quarto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Quarto;
import modelo.repositorio.PersistenceConfig;
import modelo.repositorio.QuartoRepositorio;

import java.io.IOException;

/**
 * Servlet implementation class ExcluirQuartoServlet
 */
public class ExcluirQuartoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirQuartoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int quartoID = 0;
		Quarto quarto = null;
		
		try
		{
			quartoID = Integer.parseInt(request.getParameter("id").trim());
			
			QuartoRepositorio repositorio =
					new QuartoRepositorio();
			
			quarto = repositorio.recuperarQuartoPorID(quartoID);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		if(quarto == null)
			quarto = new Quarto();
		
		request.setAttribute("quarto", quarto);
		
		request.setAttribute("tituloPagina",
				"Excluir Quarto");
		
		request.setAttribute("pathView",
				"quarto/excluir.jsp");
		
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

			QuartoRepositorio repositorio = new QuartoRepositorio();
			
			Quarto q = repositorio.recuperarQuartoPorID(id);
			
			
			boolean bool = q.isStatus_quarto();
			
			if(bool == false)
			{
				repositorio.excluirQuarto(q);
				
				PersistenceConfig.closeEntityManager();
				
				request.setAttribute("mensagemAlerta", "Quarto excluido com sucesso!");
				
				PersistenceConfig.closeEntityManager();
				
			}
			else
			{
				request.setAttribute("mensagemErro", "O Quarto não pode ser excluido pois está em uso");
			}
			
		}
		
		jakarta.servlet.RequestDispatcher rd = request.getRequestDispatcher("/quarto");
		
		rd.forward(request, response);
	}

}
