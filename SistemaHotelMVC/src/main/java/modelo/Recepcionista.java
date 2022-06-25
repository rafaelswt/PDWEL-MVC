package modelo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Recepcionista {
	
	protected String nome;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	
	protected String telefone;
	
	protected String endereco;
	
	
	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	protected Set<Conta> contas;

	
	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	protected Set<Quarto> quartos;
	
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Set<Conta> getContas() {
		return contas;
	}

	public void setContas(Set<Conta> contas) {
		this.contas = contas;
	}


	public Set<Quarto> getQuartos() {
		return quartos;
	}

	public void setQuartos(Set<Quarto> quartos) {
		this.quartos = quartos;
	}
	

}
	


