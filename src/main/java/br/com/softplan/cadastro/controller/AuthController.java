package br.com.softplan.cadastro.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.softplan.cadastro.model.Auth;

@RestController
@RequestMapping("auth/")
public class AuthController {

	
	@GetMapping("front")
	public String getAuth(Auth auth) {
		if(auth.getUsername().equals("softplan") && auth.getSenha().equals("softplan")) {
			return "Sucesso";
		}
		else {
			return "Erro";
		}
	}
}
