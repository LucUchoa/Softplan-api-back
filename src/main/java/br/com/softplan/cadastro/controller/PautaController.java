package br.com.softplan.cadastro.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.softplan.cadastro.dto.PautaDTO;
import br.com.softplan.cadastro.manager.PautaManager;
import br.com.softplan.cadastro.model.Pauta;

@RestController
@RequestMapping("pauta/")
public class PautaController {

	@Autowired
	private PautaManager manager;
	
	@GetMapping("{id}")
	public Pauta getPauta(@PathVariable(value = "id") Long id) {
		return manager.getPautaById(id);
	}
	
	@GetMapping("iniciar/{id}")
	public String startPauta(@PathVariable(value = "id") Long id) {
		return manager.IniciarPauta(id);
	}	
	
	@PostMapping("pauta")
	public String setPauta(@Valid PautaDTO pauta) {
		return manager.salvarPauta(pauta);
	}
	
}
