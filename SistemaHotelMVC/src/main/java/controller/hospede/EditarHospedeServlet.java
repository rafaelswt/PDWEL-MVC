package controller.hospede;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Hospede;
import modelo.Quarto;
import modelo.Hospede;
import modelo.repositorio.HospedeRepositorio;
import modelo.repositorio.PersistenceConfig;
import modelo.repositorio.QuartoRepositorio;
import modelo.repositorio.HospedeRepositorio;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


/**
 * Servlet implementation class EditarHospedeServlet
 */
public class EditarHospedeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarHospedeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int hospedeId = 0;
		Hospede hospede = null;
		
		try
		{
			hospedeId = Integer.parseInt(request.getParameter("id").trim());
			
			HospedeRepositorio repositorio =
					new HospedeRepositorio();
			
			hospede = repositorio.recuperarHospedePorID(hospedeId);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		if(hospede == null)
			hospede = new Hospede();
		
		//quartos vazios
		QuartoRepositorio repositorio = new QuartoRepositorio();
		
		Collection<Quarto> quartosVazios = new ArrayList<Quarto>();
		
		Quarto quartoAtual = hospede.getQuarto();
		
		quartosVazios.add(quartoAtual);
		
		quartosVazios.addAll(repositorio.recuperarQuartosPorStatus(false));
	
		if(quartosVazios == null)
		{
			quartosVazios = new ArrayList<Quarto>();
		}
		
		request.setAttribute("quartosVazios", quartosVazios);
		
		request.setAttribute("hospede", hospede);
		
		request.setAttribute("tituloPagina",
				"Editar Hospede");
		
		request.setAttribute("pathView",
				"/hospede/editar.jsp");
		
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
			
			System.out.println("catch");
		}
		
		if(id > 0)
		{	
			HospedeRepositorio repH = new HospedeRepositorio();
			
			Hospede h = new Hospede();
					
			h = repH.recuperarHospedePorID(id);
			
			h.setNome(request.getParameter("txtNome"));
			
			h.setEndereco(request.getParameter("txtEndereco"));
			
			h.setTelefone(request.getParameter("txtTelefone"));

			
			String idQuartoSelecionadoString = request.getParameter("quartosDisponiveis");
				
			if(idQuartoSelecionadoString != null)
			{
				try
				{
					id = Integer.parseInt(idQuartoSelecionadoString);
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
				Quarto q = new Quarto();
				
				QuartoRepositorio repositorio = new QuartoRepositorio();
				
				q = repositorio.recuperarQuartoPorID(id);
				
				h.setQuarto(q);
			}	
			
	
			repH.atualizar(h);
			
			PersistenceConfig.closeEntityManager();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		
		rd.forward(request, response);
	}

}
