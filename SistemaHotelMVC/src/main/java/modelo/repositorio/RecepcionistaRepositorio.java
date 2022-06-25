package modelo.repositorio;

import java.util.Collection;

import javax.persistence.EntityTransaction;

import modelo.Recepcionista;
import modelo.Recepcionista;

public class RecepcionistaRepositorio extends Repositorio<Recepcionista>{
	
	public Recepcionista recuperarRecepcionistaPorID(
			int id)
		{
			Recepcionista resultado = null;
			
			try
			{
				resultado =
					PersistenceConfig.getEntityManager()
						.find(Recepcionista.class, id);
			}
			catch (Exception e)
			{
				System.out.println(
					"Erro ao tentar recuperar o Recepcionista! " +
					e.getMessage());
			}
			return resultado;
		}
	
		@SuppressWarnings("unchecked")
		public Collection<Recepcionista>
			recuperarRecepcionistas()
		{
			Collection<Recepcionista> resultado = null;
			
			try
			{
				// HQL: "FROM Recepcionista"
				resultado =
					PersistenceConfig.getEntityManager()
						.createQuery(
							"FROM " +
							Recepcionista.class.getName())
						.getResultList();
			}
			catch (Exception e)
			{
				System.out.println("Erro ao tentar recuperar os recepcionistas cadastrados! " +
						e.getMessage());
			}
			
			return resultado;
		}
		public static boolean excluirRecepcionista(Recepcionista recepcionista)
		{
			boolean resultado = true;

			EntityTransaction transaction = PersistenceConfig.getEntityManager().getTransaction();
			
			try
			{
				transaction.begin();
				recepcionista = PersistenceConfig.getEntityManager().find(Recepcionista.class, recepcionista.getId());
				PersistenceConfig.getEntityManager().remove(recepcionista);
				transaction.commit();
			} catch (Exception e)
			{
				System.out.println("Erro ao tentar excluir recepcionista! " + e.getMessage());
				e.printStackTrace();
				transaction.rollback();
				resultado = false;
			}
			
			return resultado;
		}
	

}
