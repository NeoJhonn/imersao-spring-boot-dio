package br.com.jhonny_azevedo.rest_api.exceptions;

public class UserFoundException extends RuntimeException {

    public UserFoundException() {
        super("Usuário já existe.");
    }
}
