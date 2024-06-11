package br.com.jhonnyazevedo.first_steps_dio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FirstStepsDioApplication {


	public static void main(String[] args) {
		SpringApplication.run(FirstStepsDioApplication.class, args);


	}


	@Bean
	public CommandLineRunner run (SistemaMensagem sistema) {
		return args -> {
			sistema.enviarConfirmacaoCadastro();
			sistema.enviarMensagemBoasVidas();
			sistema.enviarConfirmacaoCadastro();
		};
	}

}
