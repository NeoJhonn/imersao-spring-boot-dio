package dio.jhonny_azevedo.dio_exemplo_spring_data_jpa;

import dio.jhonny_azevedo.dio_exemplo_spring_data_jpa.models.User;
import dio.jhonny_azevedo.dio_exemplo_spring_data_jpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartApp implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        User jhonny = new User("Jhonny", "neojhon", "123456");

        repository.save(jhonny);

        for (User user : repository.findAll()) {
            System.out.println(user);
        }
    }
}
