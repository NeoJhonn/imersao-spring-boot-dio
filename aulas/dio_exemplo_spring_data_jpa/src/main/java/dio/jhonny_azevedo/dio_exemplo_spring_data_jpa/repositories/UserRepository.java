package dio.jhonny_azevedo.dio_exemplo_spring_data_jpa.repositories;

import dio.jhonny_azevedo.dio_exemplo_spring_data_jpa.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
