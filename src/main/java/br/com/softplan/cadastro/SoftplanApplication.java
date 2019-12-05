package br.com.softplan.cadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;



@SpringBootApplication
@EnableFeignClients
public class SoftplanApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoftplanApplication.class, args);
	}

}
