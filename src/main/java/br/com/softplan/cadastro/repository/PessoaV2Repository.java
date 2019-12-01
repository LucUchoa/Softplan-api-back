package br.com.softplan.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.softplan.cadastro.model.PessoaV2;

@Repository
public interface PessoaV2Repository extends JpaRepository<PessoaV2, Long> {

}
