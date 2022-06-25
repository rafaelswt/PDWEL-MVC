package controller.recepcionista;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Recepcionista;
import modelo.Quarto;
import modelo.repositorio.RecepcionistaRepositorio;
import modelo.repositorio.PersistenceConfig;

import java.io.IOException;

import org.w3c.dom.css.RGBColor;

/**
 * Servlet implementation class ExcluirRecepcionistaServlet
 */
public class ExcluirRecepcionistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirRecepcionistaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int recepcionistaID = 0;
		Recepcionista recepcionista = null;
		
		try
		{
			recepcionistaID = Integer.parseInt(request.getParameter("id").trim());
			
			RecepcionistaRepositorio repositorio =
					new RecepcionistaRepositorio();
			
			recepcionista = repositorio.recuperarRecepcionistaPorID(recepcionistaID);
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
				"Excluir Recepcionista");
		
		request.setAttribute("pathView",
				"recepcionista/excluir.jsp");
		
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
			RecepcionistaRepositorio repositorio = new RecepcionistaRepositorio();
			
			Recepcionista r = repositorio.recuperarRecepcionistaPorID(id);
			
			//checar conta vinculada
			
			if(r.getContas()!= null || r.getQuartos() != null)
			{
				
				request.setAttribute("mensagemErro", "O Recepcionista não pode ser excluido pois está em uso!");
		
			}
			else {
				request.setAttribute("mensagemAlerta", "Hospede excluido com sucesso!");
				
				repositorio.excluirRecepcionista(r);
				
				PersistenceConfig.closeEntityManager();
			}
			
		}
		
		jakarta.servlet.RequestDispatcher rd = request.getRequestDispatcher("/recepcionista");
		
		rd.forward(request, response);
	}

}
