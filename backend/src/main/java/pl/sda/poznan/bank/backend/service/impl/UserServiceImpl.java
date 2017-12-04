package pl.sda.poznan.bank.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.poznan.bank.backend.exception.EmailAlreadyRegisteredException;
import pl.sda.poznan.bank.backend.exception.LoginAlreadyRegisteredException;
import pl.sda.poznan.bank.backend.model.User;
import pl.sda.poznan.bank.backend.repository.UserRepository;
import pl.sda.poznan.bank.backend.service.UserService;
import pl.sda.poznan.bank.backend.web.viewmodel.UserRegistrationVM;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ConversionService conversionService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           ConversionService conversionService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.conversionService = conversionService;
    }

    @Override
    public void saveUser(UserRegistrationVM userVM) {
        userRepository.findByEmail(userVM.getEmail()).ifPresent(user -> {
            throw new EmailAlreadyRegisteredException();
        });
        userRepository.findByLogin(userVM.getLogin()).ifPresent(u -> {
            throw new LoginAlreadyRegisteredException();
        });

        String encodedPassword = this.passwordEncoder.encode(userVM.getPassword());
        User user = conversionService.convert(userVM, User.class);
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    @Override
    public User findUser(long id) {
        return userRepository.findById(id).orElse(null);
    }

}
