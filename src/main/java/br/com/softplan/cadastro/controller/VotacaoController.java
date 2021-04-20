package br.com.softplan.cadastro.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.softplan.cadastro.dto.VotacaoDTO;
import br.com.softplan.cadastro.manager.VotacaoManager;

@RestController
@RequestMapping("votacao/")
public class VotacaoController {
	
	@Autowired
	private VotacaoManager manager;
	
	@PostMapping("votar")
	public String setVoto(@Valid VotacaoDTO votacao) {
		return manager.votar(votacao);
	}
	
	@GetMapping("resultado/{id}")
	public String getPessoa(@PathVariable(value = "id") Long id) {
		return manager.resultadoVotacao(id);
	}
}
