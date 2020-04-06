package br.com.fiap.avaliacaospring;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class AvaliacaoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvaliacaoSpringApplication.class, args);
	}
}
