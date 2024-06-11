package br.com.jhonnyazevedo.first_steps_dio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SistemaMensagem {

    @Autowired
    private Remetente noreply;

    @Autowired
    private Remetente techTeam;

    public void enviarConfirmacaoCadastro(){
        System.out.println(noreply);
        System.out.println("Seu cadastro foi aprovado");
    }

    public void enviarMensagemBoasVidas(){
        techTeam.setEmail("tech@dio.com.br");
        System.out.println(techTeam);
        System.out.println("Bem vindo a tech elite");
    }
}
