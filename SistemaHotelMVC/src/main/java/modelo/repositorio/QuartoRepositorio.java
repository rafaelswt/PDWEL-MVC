package modelo.repositorio;

import java.util.Collection;

import javax.persistence.EntityTransaction;


import modelo.Quarto;

public class QuartoRepositorio extends Repositorio<Quarto> {
	
	public Quarto recuperarQuartoPorID(
			int id)
		{
			Quarto resultado = null;
			
			try
			{
				resultado =
					PersistenceConfig.getEntityManager()
						.find(Quarto.class, id);
			}
			catch (Exception e)
			{
				System.out.println(
					"Erro ao tentar recuperar o Quarto! " +
					e.getMessage());
			}
			return resultado;
		}
		public Collection<Quarto>
		recuperarQuartos()
		{
			Collection<Quarto> resultado = null;
			
			try
			{
				// HQL: "FROM Quarto"
				resultado =
					PersistenceConfig.getEntityManager()
						.createQuery(
							"FROM " +
							Quarto.class.getName())
						.getResultList();
			}
			catch (Exception e)
			{
				System.out.println("Erro ao tentar recuperar os quartos cadastrados! " +
						e.getMessage());
			}
			
			return resultado;
		}
		public Collection<Quarto> recuperarQuartosPorStatus(
				Boolean situacao)
		{
			Collection<Quarto> resultado = null;
			
			try
			{
				// HQL: "FROM PessoaFisica WHERE situacao = ?"
				resultado = PersistenceConfig.getEntityManager()
						.createQuery(
								"FROM " + 
								Quarto.class.getName() +
								" WHERE status_quarto = :situacao"
						)
						.setParameter("situacao", situacao)
						.getResultList();
				
			}
			catch (Exception e)
			{
				System.out.println(
						"Erro ao tentar recuperar os quartos cadastrados! " +
						e.getMessage());
				e.printStackTrace();
			}
			
			return resultado;
		}
		public static boolean excluirQuarto(Quarto quarto)
		{
			boolean resultado = true;

			EntityTransaction transaction = PersistenceConfig.getEntityManager().getTransaction();
			
			try
			{
				transaction.begin();
				quarto = PersistenceConfig.getEntityManager().find(Quarto.class, quarto.getId());
				PersistenceConfig.getEntityManager().remove(quarto);
				transaction.commit();
			} catch (Exception e)
			{
				System.out.println("Erro ao tentar excluir quarto! " + e.getMessage());
				e.printStackTrace();
				transaction.rollback();
				resultado = false;
			}
			
			return resultado;
		}

}
