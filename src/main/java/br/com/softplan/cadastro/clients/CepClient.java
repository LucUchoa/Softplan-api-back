package br.com.softplan.cadastro.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.softplan.cadastro.dto.EnderecoDTO;

//metodo que usa o serviço viacep para pega o endereço pelo cep
@FeignClient(value = "Endereco", url = "viacep.com.br/ws/")
public interface CepClient {

	@RequestMapping(method = RequestMethod.GET, value = "{cep}/json/")
	EnderecoDTO getEndereco(@PathVariable("cep") int cep);
}
