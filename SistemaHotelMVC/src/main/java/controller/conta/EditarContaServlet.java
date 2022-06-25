package controller.conta;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Conta;
import modelo.Recepcionista;
import modelo.repositorio.ContaRepositorio;
import modelo.repositorio.PersistenceConfig;
import modelo.repositorio.RecepcionistaRepositorio;

import java.io.IOException;

/**
 * Servlet implementation class EditarContaServlet
 */
public class EditarContaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarContaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int contaID = 0;
		Conta conta = null;
		try
		{
			contaID = Integer.parseInt(request.getParameter("id").trim());
			
			ContaRepositorio repositorio =
					new ContaRepositorio();
			
			conta = repositorio.recuperarContaPorID(contaID);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		request.setAttribute("conta", conta);
		
		request.setAttribute("tituloPagina",
				"Editar Conta");
		
		request.setAttribute("pathView",
				"/conta/editar.jsp");
		
		jakarta.servlet.RequestDispatcher rd =
				request.getRequestDispatcher("/template.jsp");
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int contaID = 0;
		Conta conta = null;
		try
		{
			contaID = Integer.parseInt(request.getParameter("id").trim());
			
			ContaRepositorio repositorio =
					new ContaRepositorio();
			
			conta = repositorio.recuperarContaPorID(contaID);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	
		if(contaID > 0)
		{	
			ContaRepositorio repC = new ContaRepositorio();
			
			Conta c = new Conta();
			
			c = repC.recuperarContaPorID(contaID);
			
			Boolean boolean1 = Boolean.parseBoolean(request.getParameter("pago"));
			
			if (boolean1 == true)
				c.setSituacao(true);
			else
				c.setSituacao(false);
			
			ContaRepositorio repositorio2 = new ContaRepositorio();
			
			repositorio2.atualizar(c);
			
			PersistenceConfig.closeEntityManager();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/conta");
		
		rd.forward(request, response);
		
	}

}
