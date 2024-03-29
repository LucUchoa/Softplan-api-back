package br.com.softplan.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.softplan.cadastro.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	//Pegar pessoa pelo CPF
	@Query(value = "SELECT p FROM Pessoa p WHERE p.cpf = :cpf")
	Pessoa FindByCpf(@Param("cpf") String sigla);
}
