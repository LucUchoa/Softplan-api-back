package br.com.softplan.cadastro.manager;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.softplan.cadastro.model.Pessoa;
import br.com.softplan.cadastro.repository.PessoaRepository;

@Transactional
@Component
public class PessoaManager {

	@Autowired
	private PessoaRepository repository;

	public List<Pessoa> buscarTodasPessoas() {
		return repository.findAll();
	}

	public String salvarPessoa(Pessoa pessoa) {
		pessoa.setDataCadastro(LocalDate.now());
		repository.save(pessoa);
		return "Sucesso";
	}

	public String deletarPessoa(Pessoa pessoa) {
		repository.delete(pessoa);
		return "Pessoa deletada com sucesso";
	}
	
	public String atualizarPessoa(Pessoa pessoa) {
		pessoa.setDataAtualizacao(LocalDate.now());
		repository.save(pessoa);
		return "Atualizado com sucesso";
	}

	public Optional<Pessoa> buscarPessoa(long id) {
		return repository.findById(id);
	}

}
