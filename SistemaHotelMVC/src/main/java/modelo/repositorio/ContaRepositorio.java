package modelo.repositorio;

import java.util.Collection;

import modelo.Conta;
import modelo.Conta;

public class ContaRepositorio extends Repositorio<Conta> {
	
	public Conta recuperarContaPorID(
			int id)
		{
			Conta resultado = null;
			
			try
			{
				resultado =
					PersistenceConfig.getEntityManager()
						.find(Conta.class, id);
			}
			catch (Exception e)
			{
				System.out.println(
					"Erro ao tentar recuperar o Conta! " +
					e.getMessage());
			}
			return resultado;
		}
		public Collection<Conta>
		recuperarContas()
		{
			Collection<Conta> resultado = null;
			
			try
			{
				// HQL: "FROM Conta"
				resultado =
					PersistenceConfig.getEntityManager()
						.createQuery(
							"FROM " +
							Conta.class.getName())
						.getResultList();
			}
			catch (Exception e)
			{
				System.out.println("Erro ao tentar recuperar os hospedes cadastrados! " +
						e.getMessage());
			}
			
			return resultado;
		}
	

}
