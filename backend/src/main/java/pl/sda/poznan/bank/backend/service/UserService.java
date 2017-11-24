package pl.sda.poznan.bank.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.poznan.bank.backend.model.User;
import pl.sda.poznan.bank.backend.repository.HistoryRepository;
import pl.sda.poznan.bank.backend.repository.UserRepository;
import pl.sda.poznan.bank.backend.web.viewmodel.UserRegistrationVM;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, HistoryRepository historyRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(UserRegistrationVM userVM) {
        String encodedPassword = this.passwordEncoder.encode(userVM.getPassword());
        User user = new User();
        user.setLogin(userVM.getLogin());
        user.setEmail(userVM.getEmail());
        user.setPassword(encodedPassword);

        userRepository.save(user);
    }

    public User findUser(long id) {
        return userRepository.findById(id);
    }

}
