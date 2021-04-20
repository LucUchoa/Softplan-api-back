package br.com.softplan.cadastro.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Pauta implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6246932555021484621L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(name = "data_cadastro", nullable = false)
	private LocalDateTime dataCadastro;
	
	private int tempoPauta;
	
	private int votosNecessarios;
	
	@Column(name = "data_fim")
	private LocalDateTime dataFim;
	
	@Column(nullable = false)
	private int idUsuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public int getVotosNecessarios() {
		return votosNecessarios;
	}

	public void setVotosNecessarios(int votosNecessarios) {
		this.votosNecessarios = votosNecessarios;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getTempoPauta() {
		return tempoPauta;
	}

	public void setTempoPauta(int tempoPauta) {
		this.tempoPauta = tempoPauta;
	}

	public LocalDateTime getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDateTime dataFim) {
		this.dataFim = dataFim;
	}
	
	
}
