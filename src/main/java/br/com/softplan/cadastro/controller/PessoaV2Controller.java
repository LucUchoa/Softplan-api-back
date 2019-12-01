package br.com.softplan.cadastro.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.softplan.cadastro.manager.PessoaV2Manager;
import br.com.softplan.cadastro.model.PessoaV2;

@RestController
@RequestMapping("v2/api-cadastro/")
public class PessoaV2Controller {

	@Autowired
	private PessoaV2Manager manager;
	
	@GetMapping("pessoa/{id}")
	public Optional<PessoaV2> getPessoaV2(@PathVariable(value = "id") Long id) {
		return manager.buscarPessoa(id);
	}

	@GetMapping("pessoas")
	public List<PessoaV2> getTodasPessoasV2() {
		return manager.buscarTodasPessoas();
	}

	@PostMapping("pessoa")
	public String setPessoaV2(@Valid PessoaV2 pessoa) {
		return manager.salvarPessoa(pessoa);
	}
	
	@PutMapping("pessoa")
	public String editPessoaV2(@Valid PessoaV2 pessoa) {
		return manager.atualizarPessoa(pessoa);
	}
	
	@DeleteMapping("pessoa/{id}")
	public String deletePessoaV2(@PathVariable(value = "id") Long id) {
		return manager.deletarPessoa(id);
	}
}
