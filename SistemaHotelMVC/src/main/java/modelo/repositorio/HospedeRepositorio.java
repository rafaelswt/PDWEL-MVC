package modelo.repositorio;

import java.util.Collection;

import javax.persistence.EntityTransaction;

import modelo.Hospede;
import modelo.Quarto;

public class HospedeRepositorio extends Repositorio<Hospede> {
	
	public Hospede recuperarHospedePorID(
			int id)
		{
			Hospede resultado = null;
			
			try
			{
				resultado =
					PersistenceConfig.getEntityManager()
						.find(Hospede.class, id);
			}
			catch (Exception e)
			{
				System.out.println(
					"Erro ao tentar recuperar o Hospede! " +
					e.getMessage());
			}
			return resultado;
		}
	
		@SuppressWarnings("unchecked")
		public Collection<Hospede>
			recuperarHospedes()
		{
			Collection<Hospede> resultado = null;
			
			try
			{
				// HQL: "FROM Hospede"
				resultado =
					PersistenceConfig.getEntityManager()
						.createQuery(
							"FROM " +
							Hospede.class.getName())
						.getResultList();
			}
			catch (Exception e)
			{
				System.out.println("Erro ao tentar recuperar os hospedes cadastrados! " +
						e.getMessage());
			}
			
			return resultado;
		}
		public static boolean excluirHospede(Hospede hospede)
		{
			boolean resultado = true;

			EntityTransaction transaction = PersistenceConfig.getEntityManager().getTransaction();
			
			try
			{
				transaction.begin();
				hospede = PersistenceConfig.getEntityManager().find(Hospede.class, hospede.getId());
				PersistenceConfig.getEntityManager().remove(hospede);
				transaction.commit();
			} catch (Exception e)
			{
				System.out.println("Erro ao tentar excluir hospede! " + e.getMessage());
				e.printStackTrace();
				transaction.rollback();
				resultado = false;
			}
			
			return resultado;
		}
		public static boolean atualizarHospede(Hospede hospede)
		{
			boolean resultado = true;
			EntityTransaction transaction = PersistenceConfig.getEntityManager().getTransaction();
			
			try
			{
				transaction.begin();
				PersistenceConfig.getEntityManager().merge(hospede);
				transaction.commit();
				
				System.out.println("Hospede Atualizado com sucesso");
			} catch (Exception e)
			{
				System.out.println("Erro ao tentar atualizar os dados do hospede! " + e.getMessage());
				e.printStackTrace();
				transaction.rollback();
				resultado = false;
			}
			
			return resultado;
		}

}
