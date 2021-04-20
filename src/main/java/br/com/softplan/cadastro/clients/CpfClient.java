package br.com.softplan.cadastro.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.softplan.cadastro.dto.CpfDTO;

//metodo que usa o serviço de CPF
@FeignClient(value = "Cpf", url = "user-info.herokuapp.com/users/")
public interface CpfClient {

	@RequestMapping(method = RequestMethod.GET, value = "{cpf}")
	CpfDTO getCpf(@PathVariable("cpf") String cpf);
}
