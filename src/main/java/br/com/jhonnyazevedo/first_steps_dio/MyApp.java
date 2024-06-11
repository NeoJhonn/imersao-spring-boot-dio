package br.com.jhonnyazevedo.first_steps_dio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyApp {

    @Autowired
    Calculator calculator;

    @Autowired
    Beans beans;

    public void run() throws Exception {
        // Aqui você pode criar toda uma lógica para rodar uma aplicação em console
        System.out.println("Soma: "+ calculator.sum(2, 30));
        // Testando a criação de um bean
        beans.createBean();
        beans.createBean2();

    }
}
