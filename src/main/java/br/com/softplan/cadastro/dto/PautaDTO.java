package br.com.softplan.cadastro.dto;

import java.time.LocalDateTime;

public class PautaDTO {
	
	private String descricao;
	
	private int tempoPauta;
	
	private int idUsuario;
	
	private int votosNecessarios;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		

}
