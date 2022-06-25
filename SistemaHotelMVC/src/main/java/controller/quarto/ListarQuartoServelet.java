package controller.quarto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Hospede;
import modelo.Quarto;
import modelo.repositorio.HospedeRepositorio;
import modelo.repositorio.PersistenceConfig;
import modelo.repositorio.QuartoRepositorio;

import java.io.IOException;
import java.util.Collection;

/**
 * Servlet implementation class ListarQuartoServelet
 */
public class ListarQuartoServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarQuartoServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		QuartoRepositorio repositorio = new QuartoRepositorio();
		
		Collection<Quarto> quartos = repositorio.recuperarQuartos();
		
		PersistenceConfig.closeEntityManager();
		
		request.setAttribute("quartos", quartos);
		
		request.setAttribute("tituloPagina",
				"Quartos Cadastrados");
		
		request.setAttribute("pathView",
				"quarto/listar.jsp");
		
		jakarta.servlet.RequestDispatcher rDispatcher = request.getRequestDispatcher("/template.jsp");
		
		rDispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
