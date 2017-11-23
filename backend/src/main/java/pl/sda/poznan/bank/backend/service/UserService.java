package pl.sda.poznan.bank.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.sda.poznan.bank.backend.model.History;
import pl.sda.poznan.bank.backend.model.User;
import pl.sda.poznan.bank.backend.repository.HistoryRepository;
import pl.sda.poznan.bank.backend.repository.UserRepository;
import pl.sda.poznan.bank.backend.web.viewmodel.UserRegistrationVM;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public HistoryRepository historyRepository;

    @Autowired
    public UserService(UserRepository userRepository, HistoryRepository historyRepository) {
   @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.historyRepository = historyRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User findUser(long id){
        return userRepository.findById(id);
    }

    public List<User> findAllUsers(){
        return (List<User>) userRepository.findAll();
    }

    public void saveUser(UserRegistrationVM userVM){
        String encodedPassword = this.passwordEncoder.encode(userVM.getPassword());
        User user = new User(userVM.getLogin(), encodedPassword, null, null, null, null);

        userRepository.save(user);
    }

    public List<History> userHistory(int id) {
        return Collections.emptyList();
    }



}
