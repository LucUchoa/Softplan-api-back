package br.com.softplan.cadastro.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.softplan.cadastro.model.Pauta;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long> {
	Pauta findFirstByOrderByIdDesc();
}
