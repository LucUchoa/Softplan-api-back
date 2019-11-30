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

import br.com.softplan.cadastro.manager.PessoaManager;
import br.com.softplan.cadastro.model.Pessoa;

@RestController
@RequestMapping("api-cadastro/")
public class PessoaController {

	@Autowired
	private PessoaManager manager;
	
	@GetMapping("pessoa/{id}")
	public Optional<Pessoa> getPessoa(@PathVariable(value = "id") Long id) {
		return manager.buscarPessoa(id);
	}

	@GetMapping("pessoas")
	public List<Pessoa> getTodasPessoas() {
		return manager.buscarTodasPessoas();
	}

	@PostMapping("pessoa")
	public String setPessoa(Pessoa pessoa) {
		return manager.salvarPessoa(pessoa);
	}
	
	@PutMapping("pessoa")
	public String editPessoa(@Valid Pessoa pessoa ) {
		return manager.atualizarPessoa(pessoa);
	}
	
	@DeleteMapping
	public String deletePessoa(Pessoa pessoa) {
		return manager.deletarPessoa(pessoa);
	}
}
