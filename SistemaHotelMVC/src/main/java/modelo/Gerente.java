package modelo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Gerente")
public class Gerente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String nome;
	
	private String endereco;
	
	private int telefone;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Hospede> hospedes;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public Set<Hospede> getHospedes() {
		return hospedes;
	}

	public void setHospedes(Set<Hospede> hospedes) {
		this.hospedes = hospedes;
	}
	
	
	


	
	
	
}
