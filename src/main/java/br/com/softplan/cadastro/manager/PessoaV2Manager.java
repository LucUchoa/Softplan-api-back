package br.com.softplan.cadastro.manager;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.softplan.cadastro.model.PessoaV2;

import br.com.softplan.cadastro.repository.PessoaV2Repository;

@Transactional
@Component
public class PessoaV2Manager {

	@Autowired
	private PessoaV2Repository repository;

	public List<PessoaV2> buscarTodasPessoas() {
		return repository.findAll();
	}

	public String salvarPessoa(PessoaV2 pessoa) {
		pessoa.setDataCadastro(LocalDate.now());
		repository.save(pessoa);
		return "Sucesso";
	}

	public String deletarPessoa(Long id) {
		repository.deleteById(id);
		return "Pessoa deletada com sucesso";
	}

	public String atualizarPessoa(PessoaV2 pessoa) {
		pessoa.setDataAtualizacao(LocalDate.now());
		repository.save(pessoa);
		return "Atualizado com sucesso";
	}

	public Optional<PessoaV2> buscarPessoa(long id) {
		return repository.findById(id);
	}
}
