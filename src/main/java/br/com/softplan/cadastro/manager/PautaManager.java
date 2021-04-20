package br.com.softplan.cadastro.manager;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.softplan.cadastro.dto.PautaDTO;
import br.com.softplan.cadastro.model.Pauta;
import br.com.softplan.cadastro.repository.PautaRepository;

@Transactional
@Component
public class PautaManager {
	
	@Autowired
	private PautaRepository repository;

	
	public String salvarPauta(PautaDTO pautadto) {
		Pauta pauta = new Pauta();
		DtoParaModel(pautadto, pauta);
		repository.save(pauta);
		return ("Cadastro da pauta realizado com Sucesso Seu Id: " + repository.findFirstByOrderByIdDesc().getId());
	}
	public String IniciarPauta(long id) {
		Optional<Pauta> pauta;
		pauta = repository.findById(id);
		
		if(pauta.get().getTempoPauta() == 0) {
			pauta.get().setTempoPauta(1);
			pauta.get().setDataFim(LocalDateTime.now().plusMinutes(1));
		}
		else {
			pauta.get().setDataFim(LocalDateTime.now().plusMinutes(pauta.get().getTempoPauta()));
		}
		repository.save(pauta.get());
		return "Votacao da Pauta Iniciada!"; 
	}
	
	public Optional<Pauta> getPautaById(long id) {
		return repository.findById(id);
	}
	
	public void DtoParaModel(PautaDTO pautadto,Pauta pauta) {
		pauta.setDescricao(pautadto.getDescricao());
		pauta.setDataCadastro(LocalDateTime.now());
		pauta.setTempoPauta(pautadto.getTempoPauta());
		pauta.setVotosNecessarios(pautadto.getVotosNecessarios());
		pauta.setIdUsuario(pautadto.getIdUsuario());
	}

}
