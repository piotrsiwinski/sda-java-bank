package pl.sda.poznan.bank.backend.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sda.poznan.bank.backend.model.User;
import pl.sda.poznan.bank.backend.web.viewmodel.UserRegistrationVM;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    User findById(Long id);
    User findByLogin(String login);
    Optional<User> findByEmail(String email);

}
