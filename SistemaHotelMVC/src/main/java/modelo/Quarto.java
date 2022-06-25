package modelo;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Quarto")
public class Quarto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String localizacao;
	
	private String tipo_quarto;
	
	private boolean status_quarto;
	
	private LocalDate data_entrada;

	private LocalDate data_saida;

	public int getId() {
		return id;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getTipo_quarto() {
		return tipo_quarto;
	}

	public void setTipo_quarto(String tipo_quarto) {
		this.tipo_quarto = tipo_quarto;
	}

	public boolean isStatus_quarto() {
		return status_quarto;
	}

	public void setStatus_quarto(boolean status_quarto) {
		this.status_quarto = status_quarto;
	}

	public LocalDate getData_entrada() {
		return data_entrada;
	}

	public void setData_entrada(LocalDate data_entrada) {
		this.data_entrada = data_entrada;
	}

	public LocalDate getData_saida() {
		return data_saida;
	}

	public void setData_saida(LocalDate data_saida) {
		this.data_saida = data_saida;
	}
	
	

}
