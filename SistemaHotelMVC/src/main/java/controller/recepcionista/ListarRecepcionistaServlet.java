package controller.recepcionista;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Recepcionista;
import modelo.repositorio.RecepcionistaRepositorio;
import modelo.repositorio.PersistenceConfig;

import java.io.IOException;
import java.util.Collection;

/**
 * Servlet implementation class ListarRecepcionistaServlet
 */
public class ListarRecepcionistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarRecepcionistaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RecepcionistaRepositorio repositorio = new RecepcionistaRepositorio();
		
		Collection<Recepcionista> recepcionistas = repositorio.recuperarRecepcionistas();
		
		PersistenceConfig.closeEntityManager();
		
		request.setAttribute("recepcionistas", recepcionistas);
		
		request.setAttribute("tituloPagina",
				"Recepcionistas Cadastrados");
		
		request.setAttribute("pathView",
				"recepcionista/listar.jsp");
		
		jakarta.servlet.RequestDispatcher rDispatcher = request.getRequestDispatcher("/template.jsp");
		
		rDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
