package pl.sda.poznan.bank.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.poznan.bank.backend.exception.TestUserExceptions;
import pl.sda.poznan.bank.backend.exception.UserException;
import pl.sda.poznan.bank.backend.model.User;
import pl.sda.poznan.bank.backend.repository.HistoryRepository;
import pl.sda.poznan.bank.backend.repository.UserRepository;
import pl.sda.poznan.bank.backend.web.viewmodel.UserRegistrationVM;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ConversionService conversionService;

    private UserException userException;

    @Autowired
    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       ConversionService conversionService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.conversionService = conversionService;
    }

    public void saveUser(UserRegistrationVM userVM) {
        try {
            TestUserExceptions.TestUserAlreadyRegistered(userVM);
        } catch (UserException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        String encodedPassword = this.passwordEncoder.encode(userVM.getPassword());
        User user = conversionService.convert(userVM, User.class);
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    public User findUser(long id) {
        return userRepository.findById(id);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }
}
