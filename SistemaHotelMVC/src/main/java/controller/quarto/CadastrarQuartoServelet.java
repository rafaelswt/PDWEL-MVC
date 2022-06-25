package controller.quarto;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Quarto;
import modelo.repositorio.PersistenceConfig;
import modelo.repositorio.QuartoRepositorio;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Persistence;

/**
 * Servlet implementation class CadastrarQuartoServelet
 */
public class CadastrarQuartoServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarQuartoServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("tituloPagina",
				"Cadastrar novo Quarto");
		
		request.setAttribute("pathView",
				"quarto/cadastrar.jsp");
		
		RequestDispatcher rd =
				request.getRequestDispatcher("/template.jsp");
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Quarto q = new Quarto();
		
		q.setLocalizacao(request.getParameter("txtBloco"));
		q.setTipo_quarto(request.getParameter("txtTipo"));
		
		QuartoRepositorio quartoRepositorio = new QuartoRepositorio();
		
		quartoRepositorio.criar(q);
		
		Collection<Quarto> quartos = quartoRepositorio.recuperarQuartos();
		
		PersistenceConfig.closeEntityManager();
		
		request.setAttribute("quartos", quartos);
		
		request.setAttribute("tituloPagina",
				"Quartos Cadastrados");
		
		request.setAttribute("pathView",
				"quarto/listar.jsp");
		
		request.setAttribute("mensagemAlerta", "Quarto cadastrado com sucesso!");
		
		jakarta.servlet.RequestDispatcher rDispatcher = request.getRequestDispatcher("/template.jsp");
		
		rDispatcher.forward(request, response);
	}

}
