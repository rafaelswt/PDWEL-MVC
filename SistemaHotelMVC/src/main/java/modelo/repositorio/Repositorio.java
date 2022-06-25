package modelo.repositorio;

import java.util.Collection;

import javax.persistence.EntityTransaction;

import modelo.Quarto;

public class Repositorio<T>
{
	public boolean criar(T entidade)
	{
		boolean resultado = true;
		
		EntityTransaction transacao =
			PersistenceConfig
				.getEntityManager()
				.getTransaction();
		
		try
		{
			transacao.begin();
			PersistenceConfig.getEntityManager()
				.persist(entidade);
			transacao.commit();
		}
		catch (Exception e)
		{
			System.out.println(
				"Erro ao tentar persistir uma nova " +
				"entidade! " + e.getMessage());
			resultado = false;
			transacao.rollback();
		}
		
		return resultado;
	}
	
	public boolean atualizar(T entidade)
	{
		boolean resultado = true;
		
		EntityTransaction transacao =
				PersistenceConfig
					.getEntityManager()
					.getTransaction();
		
		try
		{
			transacao.begin();
			PersistenceConfig
				.getEntityManager().merge(entidade);
			transacao.commit();
		}
		catch (Exception e)
		{
			System.out.println(
				"Erro ao tentar atualizar a entidade! " +
					e.getMessage());
			transacao.rollback();
			resultado = false;
		}
		
		return resultado;
	}
	
	public boolean excluir(T entidade)
	{
		boolean resultado = true;
		
		EntityTransaction transacao =
			PersistenceConfig
				.getEntityManager()
				.getTransaction();
		
		try
		{
			transacao.begin();
			PersistenceConfig
				.getEntityManager().remove(entidade);
			transacao.commit();
		}
		catch (Exception e)
		{
			System.out.println(
				"Erro ao tentar excluir a entidade! " +
				e.getMessage());
			transacao.rollback();
			resultado = false;
		}
		
		return resultado;
	}
		
}
