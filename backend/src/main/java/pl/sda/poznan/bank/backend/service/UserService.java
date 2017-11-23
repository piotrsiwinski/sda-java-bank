package pl.sda.poznan.bank.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.sda.poznan.bank.backend.model.History;
import pl.sda.poznan.bank.backend.model.User;
import pl.sda.poznan.bank.backend.repository.HistoryRepository;
import pl.sda.poznan.bank.backend.repository.UserRepository;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {

    public UserRepository userRepository;

    public HistoryRepository historyRepository;

    @Autowired
    public UserService(UserRepository userRepository, HistoryRepository historyRepository) {
        this.userRepository = userRepository;
        this.historyRepository = historyRepository;
    }

    public User findUser(long id){
        return userRepository.findById(id);
    }

    public List<User> findAllUsers(){
        return (List<User>) userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public List<History> userHistory(int id) {
        return Collections.emptyList();
    }
}
