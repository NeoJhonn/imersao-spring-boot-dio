package br.com.jhonny_azevedo.rest_api.controllers;
import br.com.jhonny_azevedo.rest_api.models.User;
import br.com.jhonny_azevedo.rest_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping("/add")
    private void addUsers(@RequestBody User user) {
        User existingUser = repository.findByLogin(user.getLogin());
        if (existingUser != null) {
            throw new RuntimeException("User already exists");
        }
        repository.save(user);
    }

    @GetMapping("/list")
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/{uuid}")
    public User getUserById(@PathVariable UUID uuid) {
        return repository.findById(uuid).orElse(null);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        User existingUser = repository.findById(user.getId()).orElse(null);
        if (existingUser != null) {
            existingUser.setLogin(user.getLogin());
            existingUser.setPassword(user.getPassword());
            return repository.save(existingUser);
        }
        return null;
    }

    @DeleteMapping("/{uuid}")
    public void deleteUser(@PathVariable UUID uuid) {
        repository.deleteById(uuid);
    }
}
