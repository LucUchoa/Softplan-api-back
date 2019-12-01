package br.com.softplan.cadastro.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
public class PessoaV2 implements Serializable  {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1811210380398717715L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String nome;

	private String sexo;

	@Email
	private String email;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_nascimento", nullable = false, columnDefinition = "DATE")
	private LocalDate dataNascimento;

	private String naturalidade;

	private String nacionalidade;

	@CPF(message = "cpf inválido")
	@Column(nullable = false, unique = true)
	private String cpf;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@Column(name = "data_cadastro", nullable = false, columnDefinition = "DATE")
	private LocalDate dataCadastro;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_atualizacao", columnDefinition = "DATE")
	private LocalDate dataAtualizacao;
	
	
	@Column(nullable = false, unique = true)
	String endereco;

	
	

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDate getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDate dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
