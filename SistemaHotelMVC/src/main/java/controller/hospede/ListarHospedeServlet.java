package controller.hospede;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Hospede;
import modelo.repositorio.HospedeRepositorio;
import modelo.repositorio.PersistenceConfig;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

/**
 * Servlet implementation class ListarHospedeServlet
 */
public class ListarHospedeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarHospedeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HospedeRepositorio repositorio = new HospedeRepositorio();
		
		Collection<Hospede> hospedes = repositorio.recuperarHospedes();
		
		PersistenceConfig.closeEntityManager();
		
		request.setAttribute("hospedes", hospedes);
		
		request.setAttribute("tituloPagina",
				"Hospedes Cadastrados");
		
		request.setAttribute("pathView",
				"hospede/listar.jsp");
		
		jakarta.servlet.RequestDispatcher rDispatcher = request.getRequestDispatcher("/template.jsp");
		
		rDispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}

