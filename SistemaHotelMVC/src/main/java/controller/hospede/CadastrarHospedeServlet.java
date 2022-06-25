package controller.hospede;

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
import modelo.Conta;
import modelo.Hospede;
import modelo.Quarto;
import modelo.Recepcionista;
import modelo.repositorio.ContaRepositorio;
import modelo.repositorio.HospedeRepositorio;
import modelo.repositorio.PersistenceConfig;
import modelo.repositorio.QuartoRepositorio;
import modelo.repositorio.RecepcionistaRepositorio;
import modelo.repositorio.Repositorio;

/**
 * Servlet implementation class CadastrarHospede
 */
public class CadastrarHospedeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarHospedeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		QuartoRepositorio repositorio = new QuartoRepositorio();
		
		RecepcionistaRepositorio repositorio2 = new RecepcionistaRepositorio();
		
		Collection<Quarto> quartosVazios =
				repositorio.recuperarQuartosPorStatus(false);
		
		Collection<Recepcionista> recepcionistas =
				repositorio2.recuperarRecepcionistas();
	
		if(quartosVazios == null)
		{
			quartosVazios = new ArrayList<Quarto>();
		}
		
		if(recepcionistas == null)
		{
			recepcionistas = new ArrayList<Recepcionista>();
		}
		
		request.setAttribute("quartosVazios", quartosVazios);
		
		request.setAttribute("recepcionistas", recepcionistas);
		
		request.setAttribute("tituloPagina",
				"Cadastrar Hospede viculado a um quarto");
		
		request.setAttribute("pathView",
				"/hospede/cadastrar.jsp");
		
		RequestDispatcher rd =
				request.getRequestDispatcher("/template.jsp");
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Hospede h = new Hospede();
		
		h.setNome(request.getParameter("txtNome"));
		
		h.setEndereco(request.getParameter("txtEndereco"));
		
		h.setTelefone(request.getParameter("txtTelefone"));
		
		String idQuartoSelecionadoString = request.getParameter("quartosDisponiveis");
			
	
		int id = 0;

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
		
		//criar conta e vincular 
		ContaRepositorio repContaRepositorio = new ContaRepositorio();
		
		Conta c1 = new Conta();
		c1.setSituacao(false);
		
		repContaRepositorio.criar(c1);
		h.setConta(c1);
		
		//
		
		h.setQuarto(q);
			
		
		//selecionar recepcionista
		
		String idRecepcionistas = request.getParameter("recepcionistas");
		
		 id = 0;

		try
		{
			id = Integer.parseInt(idRecepcionistas);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		Recepcionista r = new Recepcionista();
		
		RecepcionistaRepositorio repR = new RecepcionistaRepositorio();
		
		r = repR.recuperarRecepcionistaPorID(id);
		
		//vincula recepciona ao quarto
		Set<Quarto> quartoset = new HashSet<Quarto>();
		quartoset.add(q);
		
		r.setQuartos(quartoset);
		
		//vincula recepciona a conta
		Set<Conta> contaset = new HashSet<Conta>();
		contaset.add(c1);
		
		r.setContas(contaset);
		
		repR.atualizar(r);
			
		HospedeRepositorio repositorio2 = new HospedeRepositorio();
		
		repositorio2.criar(h);
		
		Collection<Hospede> hospedes = repositorio2.recuperarHospedes();
	
		request.setAttribute("hospedes", hospedes);
		
		request.setAttribute("tituloPagina",
				"Hospedes Cadastrados");
		
		request.setAttribute("pathView",
				"hospede/listar.jsp");
		
		request.setAttribute("mensagemAlerta", "Hospede cadastrado com sucesso!");
		
		jakarta.servlet.RequestDispatcher rDispatcher = request.getRequestDispatcher("/template.jsp");
		
		rDispatcher.forward(request, response);
		
	}

}
