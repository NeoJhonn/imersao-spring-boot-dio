package br.com.jhonnyazevedo.first_steps_dio.exemplo_application_properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

public class SistemaMensagem implements CommandLineRunner {

    // você pode settar valores nos atributos com a notação @Value
    // pegando esses valores do application.properties
    @Value("${nome}")
    private String name;
    // você pode definir um valor default
    // caso não ache a variável email, colocando ":valor padrão"
    @Value("${email: email@email.padrao.com}")
    private String email;
    @Value("${telefones}")
    private List<Long> telefone;



    @Override
    public void run(String... args) throws Exception {
        System.out.println(
            "Mensagem envida por: " + name
                + "\nE-mail: " + email
                + "\nTelefone: " + telefone
        );
        System.out.println("Seu cadastro foi aprovado");

    }
}
