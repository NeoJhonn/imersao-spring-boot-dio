package br.com.jhonnyazevedo.first_steps_dio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.stream.Collector;

@Configuration
public class Beans {


    @Bean
    @Scope("prototype") // a cada novo uso do obejto é criado uma referência nova
    public Remetente remetente() {
        System.out.println("Criando um objeto Remetente");
        Remetente remetente = new Remetente();
        remetente.setEmail("noreply@dio.com.br");

        return remetente;
    }

    // Bean para a Interface Collector
    @Bean
    public Collector createBean() {
        System.out.println("Bean Collector created");
        return null;
    }

    // Bean para a Interface Iterable
    @Bean
    public Iterable  createBean2() {
        System.out.println("Bean Iterable created");
        return null;
    }
}
