package br.com.softplan.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.softplan.cadastro.model.Votacao;

@Repository
public interface VotacaoRepository extends JpaRepository<Votacao, Long> {
	//pegar voto pelo id usuario e pauta
	@Query(value = "SELECT v FROM Votacao v WHERE v.idUsuario = :idUsuario and v.idPauta = :idPauta")
	Votacao FindVoto(@Param("idUsuario") Long usuario,@Param("idPauta") Long pauta );
	//Pegar quantidade de votos
	@Query(value = "SELECT count(v) FROM Votacao v WHERE v.voto = :voto and v.idPauta = :idPauta")
	Long QuantidadeVotos(@Param("idPauta") Long idPauta, @Param("voto") String voto);
}
