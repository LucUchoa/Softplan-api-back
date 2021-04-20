package br.com.softplan.cadastro.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.softplan.cadastro.model.Pauta;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long> {
	//Pegar pessoa pelo id
	@Query(value = "SELECT p FROM Pauta p WHERE p.id = :id")
	Pauta FindPautaById(@Param("id") Long id);
	
	Pauta findFirstByOrderByIdDesc();
}
