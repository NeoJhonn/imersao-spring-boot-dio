package br.com.jhonny_azevedo.rest_api.services;

import br.com.jhonny_azevedo.rest_api.exceptions.BusinessException;
import br.com.jhonny_azevedo.rest_api.models.User;
import br.com.jhonny_azevedo.rest_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void addUsers(User user) {
        User existingUser = repository.findByLogin(user.getLogin());
        if (existingUser != null) {
            throw new BusinessException("Usuário já cadastrado!");
        }
        repository.save(user);
    }
}
