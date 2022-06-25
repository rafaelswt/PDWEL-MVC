package controller.recepcionista;

import java.awt.font.ImageGraphicAttribute;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Recepcionista;
import modelo.Quarto;
import modelo.repositorio.RecepcionistaRepositorio;
import modelo.repositorio.PersistenceConfig;
import modelo.repositorio.QuartoRepositorio;
import modelo.repositorio.Repositorio;

/**
 * Servlet implementation class CadastrarRecepcionista
 */
public class CadastrarRecepcionistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarRecepcionistaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		QuartoRepositorio repositorio = new QuartoRepositorio();
		
		Collection<Quarto> quartosVazios =
				repositorio.recuperarQuartosPorStatus(false);
	
		if(quartosVazios == null)
		{
			quartosVazios = new ArrayList<Quarto>();
		}
		
		request.setAttribute("quartosVazios", quartosVazios);
		
		request.setAttribute("tituloPagina",
				"Cadastrar Recepcionista viculado a um quarto");
		
		request.setAttribute("pathView",
				"/recepcionista/cadastrar.jsp");
		
		RequestDispatcher rd =
				request.getRequestDispatcher("/template.jsp");
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Recepcionista r = new Recepcionista();
		
		r.setNome(request.getParameter("txtNome"));
		
		r.setEndereco(request.getParameter("txtEndereco"));
		
		r.setTelefone(request.getParameter("txtTelefone"));


		RecepcionistaRepositorio repositorio2 = new RecepcionistaRepositorio();
		
		repositorio2.criar(r);
		
		Collection<Recepcionista> recepcionistas = repositorio2.recuperarRecepcionistas();
	
		request.setAttribute("recepcionistas", recepcionistas);
		
		request.setAttribute("tituloPagina",
				"Recepcionistas Cadastrados");
		
		request.setAttribute("pathView",
				"recepcionista/listar.jsp");
		
		request.setAttribute("mensagemAlerta", "Recepcionista cadastrado com sucesso!");
		
		jakarta.servlet.RequestDispatcher rDispatcher = request.getRequestDispatcher("/template.jsp");
		
		rDispatcher.forward(request, response);
		
		
		

	}

}
