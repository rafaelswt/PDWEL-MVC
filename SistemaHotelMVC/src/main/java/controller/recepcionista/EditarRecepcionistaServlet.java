package controller.recepcionista;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Recepcionista;
import modelo.Quarto;
import modelo.Recepcionista;
import modelo.repositorio.RecepcionistaRepositorio;
import modelo.repositorio.PersistenceConfig;
import modelo.repositorio.QuartoRepositorio;
import modelo.repositorio.RecepcionistaRepositorio;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


/**
 * Servlet implementation class EditarRecepcionistaServlet
 */
public class EditarRecepcionistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarRecepcionistaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int recepcionistaId = 0;
		Recepcionista recepcionista = null;
		
		try
		{
			recepcionistaId = Integer.parseInt(request.getParameter("id").trim());
			
			RecepcionistaRepositorio repositorio =
					new RecepcionistaRepositorio();
			
			recepcionista = repositorio.recuperarRecepcionistaPorID(recepcionistaId);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		if(recepcionista == null)
			recepcionista = new Recepcionista();
		
		request.setAttribute("recepcionista", recepcionista);
		
		request.setAttribute("tituloPagina",
				"Editar Recepcionista");
		
		request.setAttribute("pathView",
				"/recepcionista/editar.jsp");
		
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
			RecepcionistaRepositorio repositorio2 = new RecepcionistaRepositorio();
			
			Recepcionista h = new Recepcionista();
			
			h = repositorio2.recuperarRecepcionistaPorID(id);
			
			h.setNome(request.getParameter("txtNome"));
			
			h.setEndereco(request.getParameter("txtEndereco"));
			
			h.setTelefone(request.getParameter("txtTelefone"));

			repositorio2.atualizar(h);
			
			PersistenceConfig.closeEntityManager();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/recepcionista");
		
		rd.forward(request, response);
	}

}
