package br.com.softplan.cadastro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller para retornar as urls do gitlab
@RestController
@RequestMapping("source/")
public class SourceController {

	@GetMapping("back")
	public String getBack() {
		return "Codigo fonte do Back end no github url: https://github.com/LucUchoa/Softplan-api-back";
	}
	
	@GetMapping("front")
	public String getFront() {
		return "Codigo fonte do front end no github url:";
	}
}
