package controller.conta;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Conta;
import modelo.repositorio.PersistenceConfig;
import modelo.repositorio.ContaRepositorio;

import java.io.IOException;
import java.util.Collection;

/**
 * Servlet implementation class ListarContaServlet
 */
public class ListarContaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarContaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContaRepositorio repositorio = new ContaRepositorio();
		
		Collection<Conta> contas = repositorio.recuperarContas();
		
		PersistenceConfig.closeEntityManager();
		
		request.setAttribute("contas", contas);
		
		request.setAttribute("tituloPagina",
				"Contas Cadastradas");
		
		request.setAttribute("pathView",
				"conta/listar.jsp");
		
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
