package modelo;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Hospede")
public class Hospede 
{
	protected String nome;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	
	protected String telefone;
	
	protected String endereco;
	
	@OneToOne
	@JoinColumn(name = "quarto_id", referencedColumnName = "id")
	private Quarto quarto;
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "conta_id", referencedColumnName = "id")
	private Conta conta;
	
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

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		quarto.setData_entrada(LocalDate.now());
		quarto.setStatus_quarto(true);
		this.quarto = quarto;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}
