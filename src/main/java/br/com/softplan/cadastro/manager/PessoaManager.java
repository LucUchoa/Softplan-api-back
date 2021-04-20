package br.com.softplan.cadastro.manager;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.softplan.cadastro.clients.CepClient;
import br.com.softplan.cadastro.clients.CpfClient;
import br.com.softplan.cadastro.dto.CadastroDTO;
import br.com.softplan.cadastro.dto.CpfDTO;
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

	public String salvarPessoa(CadastroDTO cadastro) {
		Pessoa pessoa = new Pessoa();
		DtoParaModel(cadastro, pessoa);
		repository.save(pessoa);
		return ("Cadastro Realizado com Sucesso Seu Id: " + repository.FindByCpf(pessoa.getCpf()).getId());
	}

	public String deletarPessoa(Long id) {
		repository.deleteById(id);
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
	
	public void DtoParaModel(CadastroDTO cadastro,Pessoa pessoa) {
		pessoa.setDataCadastro(LocalDate.now());
		pessoa.setCpf(cadastro.getCpf());
		pessoa.setEmail(cadastro.getEmail());
		pessoa.setNome(cadastro.getNome());
		pessoa.setSexo(cadastro.getSexo());
	}

}
