package controller.quarto;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Conta;
import modelo.Quarto;
import modelo.repositorio.ContaRepositorio;
import modelo.repositorio.PersistenceConfig;
import modelo.repositorio.QuartoRepositorio;

import java.io.IOException;
import java.util.Collection;

/**
 * Servlet implementation class EditarQuartoServlet
 */
public class EditarQuartoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarQuartoServlet() {
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
		
		request.setAttribute("quarto", quarto);
		
		request.setAttribute("tituloPagina",
				"Editar Conta");
		
		request.setAttribute("pathView",
				"/quarto/editar.jsp");
		
		jakarta.servlet.RequestDispatcher rd =
				request.getRequestDispatcher("/template.jsp");
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int quartoID = 0;
		try
		{
			quartoID = Integer.parseInt(request.getParameter("numId"));
			
			Quarto q = new Quarto();
			
			QuartoRepositorio repQ =
					new QuartoRepositorio();
			
			q = repQ.recuperarQuartoPorID(quartoID);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	
		if(quartoID > 0)
		{	
			QuartoRepositorio repQ = new QuartoRepositorio();
			
			Quarto q = new Quarto();
			
			q = repQ.recuperarQuartoPorID(quartoID);
			
			q.setLocalizacao(request.getParameter("txtBloco"));
			q.setTipo_quarto(request.getParameter("txtTipo"));
			
			repQ.atualizar(q);
			
			PersistenceConfig.closeEntityManager();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/quarto");
		
		rd.forward(request, response);
	}

}
