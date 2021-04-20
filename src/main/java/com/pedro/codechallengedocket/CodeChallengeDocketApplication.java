package com.pedro.codechallengedocket;

import com.pedro.codechallengedocket.domain.Cartorio;
import com.pedro.codechallengedocket.domain.Endereco;
import com.pedro.codechallengedocket.repository.CartorioRepository;
import com.pedro.codechallengedocket.repository.EnderecoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodeChallengeDocketApplication implements CommandLineRunner {

	@Autowired
	private EnderecoRepository repEnd;

	@Autowired
	private CartorioRepository repCar;

	public static void main(String[] args) {
		SpringApplication.run(CodeChallengeDocketApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Endereco end1 = new Endereco("Rua Dimas Andriola", "129", "Jardim Oasis", "Cajazeiras", "PB", "58900-000");
		Cartorio cart1 = new Cartorio("Cartorio Pedro");
		cart1.setEndereco(end1);

		repEnd.save(end1);
		repCar.save(cart1);

	}

}
