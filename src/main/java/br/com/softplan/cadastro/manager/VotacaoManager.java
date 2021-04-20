package br.com.softplan.cadastro.manager;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.softplan.cadastro.clients.CpfClient;
import br.com.softplan.cadastro.dto.CpfDTO;
import br.com.softplan.cadastro.dto.VotacaoDTO;
import br.com.softplan.cadastro.model.Pauta;
import br.com.softplan.cadastro.model.Pessoa;
import br.com.softplan.cadastro.model.Votacao;
import br.com.softplan.cadastro.repository.PautaRepository;
import br.com.softplan.cadastro.repository.PessoaRepository;
import br.com.softplan.cadastro.repository.VotacaoRepository;

@Transactional
@Component
public class VotacaoManager {

	@Autowired
	private VotacaoRepository votacaoRepository;

	@Autowired
	private PautaRepository pautaRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private CpfClient client;

	public String votar(VotacaoDTO voto) {
		Votacao votacao = new Votacao();
		Pessoa pessoa = pessoaRepository.findById(voto.getIdUsuario()).orElse(null);
		CpfDTO resultCpf = new CpfDTO();
		Pauta pauta = pautaRepository.findById(voto.getIdPauta()).orElse(null);

		DtoParaModel(voto, votacao);

		if (pessoa != null) {
			resultCpf = client.getCpf(pessoa.getCpf());
			if (resultCpf.getStatus().equals("ABLE_TO_VOTE")) {

				if (pauta != null) {
					if (votacao.getDataVoto().isBefore(pauta.getDataFim())) {
						if (votacaoRepository.FindVoto(votacao.getIdUsuario(), votacao.getIdPauta()) != null) {
							return "Ja votou";
						} else {
							votacaoRepository.save(votacao);
							return "Voto salvo";
						}
					} else {
						return "Votacao encerrada";
					}
				} else {
					return "Pauta nao cadastrada";
				}

			} else {
				return "Usuario sem permissao de voto";
			}
		} else {
			return "Usuario Nao cadastrado";
		}
	}
	
	public String resultadoVotacao(Long idPauta) {
		return "Votos sim: " + votacaoRepository.QuantidadeVotos(idPauta, "sim") + " votos nao: " + votacaoRepository.QuantidadeVotos(idPauta, "nao");
	}

	public void DtoParaModel(VotacaoDTO voto, Votacao votacao) {
		votacao.setDataVoto(LocalDateTime.now());
		votacao.setIdPauta(voto.getIdPauta());
		votacao.setIdUsuario(voto.getIdUsuario());
		votacao.setVoto(voto.getVoto());
	}

}
