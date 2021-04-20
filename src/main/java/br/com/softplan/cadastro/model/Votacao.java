package br.com.softplan.cadastro.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Votacao implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3020993518938579277L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Long idPauta;
	
	@Column(nullable = false)
	private Long idUsuario;
	
	@Column(nullable = false)
	private String voto;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@Column(name = "data_voto", nullable = false, columnDefinition = "DATETIME")
	private LocalDateTime dataVoto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdPauta() {
		return idPauta;
	}

	public void setIdPauta(Long idPauta) {
		this.idPauta = idPauta;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getVoto() {
		return voto;
	}

	public void setVoto(String voto) {
		this.voto = voto;
	}

	public LocalDateTime getDataVoto() {
		return dataVoto;
	}

	public void setDataVoto(LocalDateTime dataVoto) {
		this.dataVoto = dataVoto;
	}
	
	
	
}
