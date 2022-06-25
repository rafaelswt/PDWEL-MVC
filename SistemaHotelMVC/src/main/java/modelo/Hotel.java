package modelo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Hotel")
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	
	private String endereco;
	
	private int telefone;
	
	@OneToOne
	@JoinColumn(name ="gerente_id", referencedColumnName = "id")
	private Gerente gerente;
	
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

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	
	
	
	

	
}
