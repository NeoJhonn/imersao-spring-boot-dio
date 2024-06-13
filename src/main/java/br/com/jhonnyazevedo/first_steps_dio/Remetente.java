package br.com.jhonnyazevedo.first_steps_dio;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
// aqui você define como sera o nome do bean/ojeto para pegar os dados do application.properties
@ConfigurationProperties(prefix = "remetente") // <-----------------
public class Remetente {

    private String nome;
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }
    @Override
    public String toString() {
        return "Remetente{" +
                "email='" + email + '\'' +
                '}';
    }
}
